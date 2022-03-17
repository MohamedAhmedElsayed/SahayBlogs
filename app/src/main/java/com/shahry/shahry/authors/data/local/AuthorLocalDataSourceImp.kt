package com.shahry.shahry.authors.data.local

import com.shahry.shahry.authors.data.models.Author
import io.realm.Realm
import io.realm.RealmList
import javax.inject.Inject

class AuthorLocalDataSourceImp @Inject constructor() : AuthorLocalDataSource {
    override suspend fun insertAuthors(authers: ArrayList<Author>) {
        Realm.getDefaultInstance().use {
            it.executeTransactionAsync {
                val authorsList = RealmList<Author>()
                authorsList.addAll(authers)
                it.insertOrUpdate(authorsList)
            }
        }

    }

    override suspend fun readAuthors(): ArrayList<Author> {
        val realm = Realm.getDefaultInstance()
        val list = realm.where(Author::class.java)?.findAll()
        var authorList = arrayListOf<Author>()
        if (!list.isNullOrEmpty()) {
            authorList = realm.copyFromRealm(list) as ArrayList<Author>
        }
        realm.close()
        return authorList
    }
}
