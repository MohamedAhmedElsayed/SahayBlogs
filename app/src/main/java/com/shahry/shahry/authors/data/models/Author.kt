package com.shahry.shahry.authors.data.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Author(
    @PrimaryKey
    var id: Int? = null,
    var name: String? = null,
    var userName: String? = null,
    var email: String? = null,
    var avatarUrl: String? = null,
    var address: Address? = Address()

) : RealmObject()