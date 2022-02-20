package com.example.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val spn_genre = findViewById<Spinner>(R.id.spn_genre)
        val txt_age = findViewById<EditText>(R.id.txt_age)
        val label_result = findViewById<TextView>(R.id.txt_result)
        val calculate_button = findViewById<Button>(R.id.btn_calc)

        ArrayAdapter.createFromResource(
            this,
            R.array.spinner_genre,
            android.R.layout.simple_spinner_item,
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spn_genre.adapter = adapter
        }

        calculate_button.setOnClickListener {
            val genre = spn_genre.selectedItem as String
            val age = txt_age.text.toString().toInt()
            var result = 0

            if(genre == "Masculino"){
                result = 65 - age
            }else{
                result = 60 - age
            }

            label_result.text = "Falta $result anos para sua aposentadoria."
        }
    }
}