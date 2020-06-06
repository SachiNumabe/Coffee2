package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_popup.*

class PopupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        val hogeImageResorce = intent.getIntExtra("image",0)

        val hogeName = intent.getStringExtra("Name")

        val description = intent.getStringExtra("description")

        imageView.setImageResource(hogeImageResorce)

        textVieww.text = hogeName
        editText5.text = description

    }
}
