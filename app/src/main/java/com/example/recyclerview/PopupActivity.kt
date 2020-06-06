package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_popup.*
import kotlinx.android.synthetic.main.activity_popup.editText5
import kotlinx.android.synthetic.main.item_hoge_data_cell.*

class PopupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        val hogeImageResorce = intent.getIntExtra("image",0)

        val hogeName = intent.getStringExtra("Name")

        val description = intent.getStringExtra("description")

        imageView.setImageResource(hogeImageResorce)

        textView.text = hogeName
        editText5.text = description

    }
}
