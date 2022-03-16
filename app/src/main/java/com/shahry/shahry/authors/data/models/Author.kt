package com.shahry.shahry.authors.data.models


data class Author(
    var id: Int? = null, var name: String? = null,
    var userName: String? = null,
    var email: String? = null,
    var avatarUrl: String? = null, var address: Address? = Address()

)