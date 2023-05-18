package com.example.housinite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class OwnersHomePage : AppCompatActivity() {
    lateinit var cardUploadApt : CardView
    lateinit var cardUploadHse : CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owners_home_page)

        cardUploadApt = findViewById(R.id.cardUploadApts)
        cardUploadApt.setOnClickListener {
            var intent = Intent(this,AddApartmentsActivity::class.java)
            startActivity(intent)
        }

        cardUploadHse = findViewById(R.id.cardUploadHse)
        cardUploadHse.setOnClickListener {
            var intent = Intent(this,AddHousesActivity::class.java)
            startActivity(intent)
        }

    }
}