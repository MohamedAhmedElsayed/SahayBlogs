package com.shahry.shahry.base.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.RealmConfiguration


@HiltAndroidApp
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initRealm()
    }

    private fun initRealm() {
        Realm.init(this)
        val config: RealmConfiguration = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)
    }
}