package com.shahry.shahry.authors.data.models

import android.os.Parcelable
import io.realm.RealmObject
import kotlinx.parcelize.Parcelize

@Parcelize
open class Address(
    var latitude: Double? = null,
    var longitude: Double? = null
) : RealmObject(), Parcelable