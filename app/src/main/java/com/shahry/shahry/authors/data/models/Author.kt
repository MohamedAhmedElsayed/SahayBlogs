package com.shahry.shahry.authors.data.models

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
open class Author(
    @PrimaryKey
    var id: Int? = null,
    var name: String? = null,
    var userName: String? = null,
    var email: String? = null,
    var avatarUrl: String? = null,
    var address: Address? = Address()

) : RealmObject(), Parcelable