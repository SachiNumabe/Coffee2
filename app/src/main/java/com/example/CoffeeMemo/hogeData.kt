package com.example.CoffeeMemo

import io.realm.annotations.PrimaryKey
import java.io.Serializable
import java.util.*


data class hogeData (
    val hogeName: String,
    val hogeFlavor: String,
    val hogeAcidity: String,
    val hogeBody: String,
    val hogeRegion: String,
    val hogeProcessing: String,
    val memo:String,
    val hogeImageResorce: String
)