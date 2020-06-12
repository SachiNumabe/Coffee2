package com.example.CoffeeMemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import coil.api.load
import io.realm.Realm
import io.realm.RealmObject.deleteFromRealm
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_popup.*

class PopupActivity : AppCompatActivity() {

    val realm : Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        setSupportActionBar(toolbar_add)

        val hogeImageResorce = intent.getStringExtra("image")
        val hogeName = intent.getStringExtra("Name")
        val flavor = intent.getStringExtra("flavor")
        val acidity = intent.getStringExtra("acidity")
        val body = intent.getStringExtra("body")
        val region = intent.getStringExtra("region")
        val processing = intent.getStringExtra("processing")
        val memo = intent.getStringExtra("memo")

        imageViewPopup.load(hogeImageResorce){
            error(R.drawable.no_image)
        }
        beanNameEditTextPopup.text = hogeName
        flavorTextViewEditPopup.text = flavor
        acidityTextViewEditPopup.text = acidity
        bodyTextViewEditPopup.text = body
        regionTextViewEditPopup.text = region
        processingTextViewEditPopup.text = processing
        memoTextViewEditPopup.text = memo

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.popup, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //メニューのどれがクリックされても呼ばれるメソッド
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.deleteButton ->{
                realm.executeTransaction {
                   // item.deleteFromRealm()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
