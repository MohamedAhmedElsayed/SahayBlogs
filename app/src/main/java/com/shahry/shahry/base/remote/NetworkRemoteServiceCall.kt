package com.shahry.shahry.base.remote

import com.shahry.shahry.R
import com.shahry.shahry.base.remote.NetworkCodesConst.Companion.HTTP_TIME_OUT_CODE
import com.shahry.shahry.base.remote.NetworkCodesConst.Companion.SUCCESS_SERVER_CODE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

interface NetworkRemoteServiceCall {

    /**
     * safeApiCall
     * @param apiCall as suspend fn to call api
     * pass suspend api fn as parameter to safeApiCall fn
     * invoke Api at IO thread and handle logic
     * @return NetworkResponse<T>  hase success state data and failure state data
     */
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> Response<T>,
    ): NetworkResponse<T> {
        return withContext(Dispatchers.IO) {
            try {
                // invoke suspend service method
                val response = apiCall.invoke()
                // get response code from http
                val httpCode =
                    (response.body() as? HttpException)?.response()?.code() ?: SUCCESS_SERVER_CODE

                // handle code range
                NetworkResponseHandler.handleResponse(
                    httpCode,
                    response = response.body()
                )
            } catch (throwable: Exception) {
                // check connection error
                if (throwable is IOException || (throwable is HttpException && throwable.code() == HTTP_TIME_OUT_CODE))
                    NetworkResponse.Failure(ErrorTypes.Network, R.string.network_connection_error)
                else {
                    // get http response
                    val statusResponse = (throwable as? HttpException)?.response()
                    // get response code fromm http exception
                    val httpCode = statusResponse?.code()
                    NetworkResponseHandler.handleResponse(
                        httpCode
                    )
                }
            }
        }
    }}