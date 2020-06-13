package com.example.CoffeeMemo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable
import java.util.*


open class realmData (
    @PrimaryKey open var id: String = UUID.randomUUID().toString(),
    open var RealmName: String = "",
    open var RealmFlavor: String = "",
    open var RealmAcidity: String = "",
    open var RealmBody: String = "",
    open var RealmRegion: String = "",
    open var RealmProcessing: String = "",
    open var Realmmemo:String = "",
    open var RealmImageResorce: String = ""
):Serializable,RealmObject()
