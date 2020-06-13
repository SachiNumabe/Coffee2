package com.example.CoffeeMemo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable
import java.util.*


open class realmData (
    @PrimaryKey open var id: String = UUID.randomUUID().toString(),
    var RealmName: String = "",
    var RealmFlavor: String = "",
    var RealmAcidity: String = "",
    var RealmBody: String = "",
    var RealmRegion: String = "",
    var RealmProcessing: String = "",
    var Realmmemo:String = "",
    var RealmImageResorce: String = ""
):Serializable,RealmObject()
