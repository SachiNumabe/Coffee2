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
import java.io.Serializable

class PopupActivity : AppCompatActivity() {

    val realm : Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        setSupportActionBar(toolbar_add)

        val hogeData: realmData = intent.getSerializableExtra("realmData") as realmData

        imageViewPopup.load(hogeData.RealmImageResorce){
            error(R.drawable.no_image)
        }
        beanNameEditTextPopup.text = hogeData.RealmName
        flavorTextViewEditPopup.text = hogeData.RealmFlavor
        acidityTextViewEditPopup.text = hogeData.RealmAcidity
        bodyTextViewEditPopup.text = hogeData.RealmBody
        regionTextViewEditPopup.text = hogeData.RealmRegion
        processingTextViewEditPopup.text = hogeData.RealmProcessing
        memoTextViewEditPopup.text = hogeData.Realmmemo

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.popup, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //メニューのどれがクリックされても呼ばれるメソッド
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.deleteButton ->{
                delete(item.itemId.toString())
                val Intent = Intent(this,MainActivity::class.java)
                startActivity(Intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //画面終了時にRealmを終了する
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun delete(id: String) {
        realm.executeTransaction {
            val realmData = realm.where(realmData::class.java).equalTo("id", id).findFirst()
                ?: return@executeTransaction
            realmData.deleteFromRealm()
        }
    }

}
