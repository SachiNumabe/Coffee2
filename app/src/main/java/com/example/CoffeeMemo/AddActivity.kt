package com.example.CoffeeMemo

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.annotations.PrimaryKey
import kotlinx.android.synthetic.main.activity_add.*
import java.io.FileDescriptor
import java.io.IOException
import java.util.*


class AddActivity : AppCompatActivity() {

    //Realmの変数を宣言
    val realm : Realm = Realm.getDefaultInstance()

    var Flavor: String = "ROASTED"
    var Acidity: String = "HIGH"
    var Body: String = "HIGH"
    var Region: String = "LATIN AMERICA"
    var Processing: String = "WASHED"

    var stringUri: String = ""

    private val RESULT_PICK_IMAGEFILE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        imageViewAdd.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, RESULT_PICK_IMAGEFILE)

        }

        // 変更イベントの実装
        ratingBarAdd.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
//            if(){
//
//            }
        }

        saveAddButton.setOnClickListener {
            val realmName: String = beanNameEditTextAdd.text.toString()
            val realmFlavor: String = Flavor
            val realmAcidity: String = Acidity
            val realmBody: String = Body
            val realmRegion: String = Region
            val realmProcessing: String = Processing
            val realmmemo: String = MemoEditText.text.toString()
            val realmImage: String = stringUri

            save(realmName,realmFlavor,realmAcidity,realmBody,realmRegion,realmProcessing,realmmemo,realmImage)

            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        if (requestCode == RESULT_PICK_IMAGEFILE && resultCode == Activity.RESULT_OK) {
            var uri: Uri? = null
            if (resultData != null) {
                uri = resultData.data
                if(uri != null){
                    try {
                        stringUri = uri.toString()
                    val bmp = getBitmapFromUri(uri)
                    imageViewAdd.setImageBitmap(bmp)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                }
            }

        }
    }

    @Throws(IOException::class)
    private fun getBitmapFromUri(uri: Uri): Bitmap {
        val parcelFileDescriptor =
            contentResolver.openFileDescriptor(uri, "r")
        val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
        val image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
        parcelFileDescriptor.close()

        return image

    }

    //画面終了時にRealmを終了する
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun save(realmName: String,realmFlavor: String,realmAcidity: String,realmBody: String,realmRegion: String,realmProcessing: String,realmmemo: String,realmImage: String){
        realm.executeTransaction{
                //保存するデータの新規作成
                val newRealmData:realmData = it.createObject(realmData::class.java, UUID.randomUUID().toString())

            newRealmData.RealmName = realmName
                newRealmData.RealmFlavor = realmFlavor
                newRealmData.RealmAcidity = realmAcidity
                newRealmData.RealmBody = realmBody
                newRealmData.RealmRegion = realmRegion
                newRealmData.RealmProcessing = realmProcessing
                newRealmData.Realmmemo = realmmemo
                newRealmData.RealmImageResorce = realmImage

        }

    }



    fun flavor(v : View) {
        // 選択されたボタンの色
        v.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        when (v.id){
            R.id.roastedButtonAdd -> {
                Flavor = "ROASTED"
                spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.spicesButtonAdd -> {
                Flavor = "SPICES"
                roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.nuttyButtonAdd -> {
                Flavor = "NUTTY/COCOA"
                spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.sweetButtonAdd -> {
                Flavor = "SWEET"
                spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.floralButtonAdd -> {
                Flavor = "FLORAL"
                spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.fruityButtonAdd -> {
                Flavor = "FRUITY"
                spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.sourButtonAdd -> {
                Flavor = "SOUR/FERMENTED"
                spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.greenButtonAdd -> {
                Flavor = "GREEN/VEGETABLE"
                spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.otherButtonAdd -> {
                Flavor = "OTHER"
                spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }

        }
    }
    fun acidity(v : View) {
        // 選択されたボタンの色
        v.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        when (v.id){
            R.id.AcidityHighButtonAdd -> {
                Acidity = "HIGH"
                AcidityMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AcidityLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.AcidityMediumButtonAdd -> {
                Acidity = "MEDIUM"
                AcidityHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AcidityLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.AcidityLowButtonAdd -> {
                Acidity = "LOW"
                AcidityHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AcidityMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
        }
    }
    fun body(v : View) {
        // 選択されたボタンの色
        v.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        when (v.id){
            R.id.bodyHighButtonAdd -> {
                Body = "HIGH"
                bodyMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                bodyLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.bodyMediumButtonAdd -> {
                Body = "MEDIUM"
                bodyHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                bodyLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.bodyLowButtonAdd -> {
                Body = "LOW"
                bodyHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                bodyMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
        }
    }
    fun region(v : View) {
        // 選択されたボタンの色
        v.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        when (v.id){
            R.id.LatinAmericaRegionButtonAdd -> {
                Region = "LATIN AMERICA"
                AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.AsiaPacificRegionButtonAdd -> {
                Region = "ASIA/PACIFIC"
                LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.AfricaRegionButtonAdd -> {
                Region = "AFRICA"
                LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.MultiRegionnButtonAdd -> {
                Region = "MULTI-REGION"
                LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.otherRegionButtonAdd -> {
                Region = "OTHER"
                LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
        }
    }
    fun processing(v : View) {
        // 選択されたボタンの色
        v.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        when (v.id){
            R.id.WashedProcessingButtonAdd -> {
                Processing = "WASHED"
                SemiWashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                NaturalProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.SemiWashedProcessingButtonAdd -> {
                Processing = "SEMI-WASHED"
                WashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                NaturalProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.NaturalProcessingButtonAdd -> {
                Processing = "NATURAL"
                WashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                SemiWashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                otherProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
            R.id.otherProcessingButtonAdd -> {
                Processing = "OTHER"
                WashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                SemiWashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
                NaturalProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            }
        }
    }

}
