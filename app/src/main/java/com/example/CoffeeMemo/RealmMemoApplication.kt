package com.example.CoffeeMemo

import io.realm.Realm
import android.app.Application
import io.realm.RealmConfiguration

class RealmMemoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
//データベースに保存するモデルに変更を加えたとき、アプリを削除して再インストールする手間を省くことができるようになる
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}