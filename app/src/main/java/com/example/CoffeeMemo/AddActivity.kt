package com.example.CoffeeMemo

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*
import java.io.FileDescriptor
import java.io.IOException


class AddActivity : AppCompatActivity() {

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

        roastedButtonAdd.setOnClickListener {
            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        spicesButtonAdd.setOnClickListener {
            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        nuttyButtonAdd.setOnClickListener {
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        sweetButtonAdd.setOnClickListener {
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        floralButtonAdd.setOnClickListener {
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        fruityButtonAdd.setOnClickListener {
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        sourButtonAdd.setOnClickListener {
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        greenButtonAdd.setOnClickListener {
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        otherButtonAdd.setOnClickListener {
            otherButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            spicesButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            roastedButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            nuttyButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sweetButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            floralButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            fruityButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            sourButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            greenButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        AcidityHighButtonAdd.setOnClickListener {
            AcidityHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            AcidityMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AcidityLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        AcidityMediumButtonAdd.setOnClickListener {
            AcidityMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            AcidityHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AcidityLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        AcidityLowButtonAdd.setOnClickListener {
            AcidityLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            AcidityHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AcidityMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        bodyHighButtonAdd.setOnClickListener {
            bodyHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            bodyMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            bodyLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        bodyMediumButtonAdd.setOnClickListener {
            bodyMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            bodyHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            bodyLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        bodyLowButtonAdd.setOnClickListener {
            bodyLowButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            bodyHighButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            bodyMediumButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        LatinAmericaRegionButtonAdd.setOnClickListener {
            LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        AsiaPacificRegionButtonAdd.setOnClickListener {
            AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        AfricaRegionButtonAdd.setOnClickListener {
            AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        MultiRegionnButtonAdd.setOnClickListener {
            MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        otherRegionButtonAdd.setOnClickListener {
            otherRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            LatinAmericaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AsiaPacificRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            AfricaRegionButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            MultiRegionnButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        WashedProcessingButtonAdd.setOnClickListener {
            WashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            SemiWashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            NaturalProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        SemiWashedProcessingButtonAdd.setOnClickListener {
            SemiWashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            WashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            NaturalProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        NaturalProcessingButtonAdd.setOnClickListener {
            NaturalProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            WashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            SemiWashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            otherProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        otherProcessingButtonAdd.setOnClickListener {
            otherProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));

            WashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            SemiWashedProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
            NaturalProcessingButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorGlay)));
        }

        saveAddButton.setOnClickListener {
           // create("")
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

//    private fun create(title: String) {
//        // プライマリーキーを取得
//        val savedId = sharedPreferences.getInt(ViewModel.KEY.REALM_ID.name, id)
//        val id = savedId + 1
//
//        // トランザクションして書き込む
//        realm.executeTransaction { realm ->
//            val obj = realm.createObject(MainActivity.ListObject::class.java, id)
//            obj.title = title
//        }
//
//        // プライマリーキーを保存
//        sharedPreferences.edit().putInt(ViewModel.KEY.REALM_ID.name, id).apply()
//    }



//    val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
//
//    // 変更イベントの実装
//    ratingBar.setOnRatingBarChangeListener{ ratingBar, rating, fromUser ->
//
//    }
}
