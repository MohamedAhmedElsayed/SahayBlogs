package com.shahry.shahry.authors.data.models

import io.realm.RealmObject


open class Address(
    var latitude: Double? = null,
    var longitude: Double? = null
) : RealmObject()