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

        imageViewPopup.setImageResource(hogeImageResorce)

        beanNameEditTextPopup.text = hogeName
        MemoTextViewPopup.text = description

    }
}
