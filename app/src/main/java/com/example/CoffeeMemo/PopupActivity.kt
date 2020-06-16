package com.example.CoffeeMemo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_popup.*

class PopupActivity : AppCompatActivity() {

    val realm : Realm = Realm.getDefaultInstance()
    var hogeData: realmData = realmData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        setSupportActionBar(toolbar_add)

        hogeData = intent.getSerializableExtra("realmData") as realmData

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
                AlertDialog.Builder(this)
                    .setTitle("メモの消去")
                    .setMessage("本当に消去してもいいですか？")
                    .setPositiveButton(
                        "はい"
                    ) { dialog, which -> // OK button pressed
                        delete(hogeData.id)
                        val Intent = Intent(this,MainActivity::class.java)
                        startActivity(Intent)
                    }
                    .setNegativeButton("いいえ", null)
                    .show()
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
