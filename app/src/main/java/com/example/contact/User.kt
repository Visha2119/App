package com.example.contact

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class User: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user)

        val name=findViewById<TextView>(R.id.nameDetail)
        val gender =findViewById<TextView>(R.id.genderDetail)
        val country=findViewById<TextView>(R.id.country)




        val extract = intent.extras

        val namevalue = extract?.getString("name")
        val gendervalue = extract?.getString("gender")
        val countryvalue=extract?.getString("country")

        name.text = namevalue.toString()
        gender.text = gendervalue.toString()
        country.text=countryvalue.toString()

    }
}
