package com.example.burgerorderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btnOrder.setOnClickListener {

        //INTENT-->
        Intent(this,SecondActivity::class.java).also {
            startActivity(it)
        }

        //Toast.makeText(this,"Ye lo Toasty Toast",Toast.LENGTH_LONG).show()
        Toast(this).apply {
            duration = Toast.LENGTH_LONG
            view = layoutInflater.inflate(R.layout.custom_toast,clToast)
            show()
        }

        val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
        val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
        val cheese = cbCheese.isChecked
        val onions = cbOnions.isChecked
        val paneer = cbPaneer.isChecked
//        val orderString = "You ordered a burger with:\n" +
//                "${meat.text}" +
//                (if(cheese) "\nCheese" else "") +
//                (if (onions) "\nOnions" else "") +
//                (if (paneer) "\nPaneer" else "")
//        tvOrder.text = orderString

        var checkBoxSelected:String = ""
        if(cheese==true){
            checkBoxSelected += "\nCheese"
        }
        if(onions == true) {
            checkBoxSelected += "\nOnion"
        }
        if(paneer == true) {
            checkBoxSelected += "\nPaneer"
        }
        val orderString = "You ordered a burger with: \n ${meat.text} $checkBoxSelected"
        tvOrder.text = orderString
        }
    }
}