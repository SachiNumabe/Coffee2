package com.example.recyclerview

import android.app.LauncherActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.Sort
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_hoge_data_cell.*

class MainActivity : AppCompatActivity() {

    val hogeData : List<hogeData> = listOf(
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"エチオピア","私は苦手"),
        hogeData(R.drawable.no_image,"コロンビア","バランスタイプ")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            // .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)

        val adapter = RecyclerViewAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.addall(hogeData)

        //read()

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

//    open class ListObject: RealmObject() {
//        @PrimaryKey
//        var id : Int? = null
//        @Required
//        var title = ""
//    }
//
//    private fun read() {
//        // 全件取ってきて、降順にソートする
//        val all = realm.where(ListObject::class.java).findAll()
//        val sortedAll = all.sort("id", Sort.DESCENDING)
//
//        // RecyclerViewに表示する
//        sortedAll.forEach { obj ->
//            hogeData.add(LauncherActivity.ListItem(obj, viewModel))
//        }
//    }

}
