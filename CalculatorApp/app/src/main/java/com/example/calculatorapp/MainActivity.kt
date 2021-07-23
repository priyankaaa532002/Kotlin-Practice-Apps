package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ac.setOnClickListener{
            inputText.text = ""
            outputText.text = ""
        }
        btn_0.setOnClickListener{
            inputText.append("0")
        }
        btn_1.setOnClickListener{
            inputText.append("1")
        }
        btn_2.setOnClickListener{
            inputText.append("2")
        }
        btn_3.setOnClickListener{
            inputText.append("3")
        }
        btn_4.setOnClickListener{
            inputText.append("4")
        }
        btn_5.setOnClickListener{
            inputText.append("5")
        }
        btn_6.setOnClickListener{
            inputText.append("6")
        }
        btn_7.setOnClickListener{
            inputText.append("7")
        }
        btn_8.setOnClickListener{
            inputText.append("8")
        }
        btn_9.setOnClickListener{
            inputText.append("9")
        }
        btn_plus.setOnClickListener{
            inputText.append(" + ")
        }
        btn_minus.setOnClickListener{
            inputText.append(" - ")
        }
        btn_multiplication.setOnClickListener{
            inputText.append(" * ")
        }
        btn_divide.setOnClickListener{
            inputText.append(" / ")
        }
        btn_start_bracket.setOnClickListener{
            inputText.append(" ( ")
        }
        btn_end_bracket.setOnClickListener{
            inputText.append(" ) ")
        }
        btn_dot.setOnClickListener{
            inputText.append(".")
        }
        btn_equal.setOnClickListener {
            val expression = ExpressionBuilder(inputText.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()

            if (result == longResult.toDouble()){
                outputText.text = longResult.toString()
            } else {
                outputText.text = result.toString()
            }
        }




    }
}