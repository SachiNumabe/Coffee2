package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_hoge_data_cell.*

class MainActivity : AppCompatActivity() {

  //  val preview = Intent(this,PopupActivity::class.java)

    val hogeData : List<hogeData> = listOf(
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい"),
        hogeData(R.drawable.no_image,"ケニア","酸味がつよい")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = RecyclerViewAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.addall(hogeData)

      //  imageView.setOnClickListener {
        //   popup(hogeData[7],preview)
       // }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.add -> Intent(this,AddActivity::class.java)

        }
        return super.onOptionsItemSelected(item)
    }

    fun popup(hogeData: hogeData,preview:Intent) {
        preview.putExtra("image",hogeData.hogeImageResorce)
        preview.putExtra("Name",hogeData.hogeName)
        preview.putExtra("description",hogeData.description)
        startActivity(preview)
    }
}
