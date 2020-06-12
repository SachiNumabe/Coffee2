package com.example.CoffeeMemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_hoge_data_cell.*

 class MainActivity : AppCompatActivity() {

     val realm : Realm = Realm.getDefaultInstance()

    val hogeData = readAll()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = RecyclerViewAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.addall(hogeData)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

//メニューのどれがクリックされても呼ばれるメソッド
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.addButton ->{val Intent = Intent(this,AddActivity::class.java)
                        startActivity(Intent) }
        }
        return super.onOptionsItemSelected(item)
    }

     fun readAll(): List<realmData>{
         return realm.copyFromRealm(realm.where(realmData::class.java).findAll())
     }



}
