package com.example.CoffeeMemo

import io.realm.RealmObject
import java.io.Serializable


data class realmData (
    var RealmName: String = "",
    var RealmFlavor: String = "",
    var RealmAcidity: String = "",
    var RealmBody: String = "",
    var RealmRegion: String = "",
    var RealmProcessing: String = "",
    var Realmmemo:String = "",
    var RealmImageResorce: String = ""
):Serializable,RealmObject()
