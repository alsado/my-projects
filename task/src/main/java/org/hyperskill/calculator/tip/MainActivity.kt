package org.hyperskill.calculator.tip

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var bill = ""
    var tipPercentage = 0.0
    var tip = 0.0

    private fun setMessage(){
        if (bill.isEmpty()) {
            textView.visibility = View.INVISIBLE
        } else {
            tip = (bill.toDouble() * tipPercentage) / 100
            textView.visibility = View.VISIBLE
            textView.text = "Tip amount: ${DecimalFormat("0.00").format(tip)}"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.visibility = View.INVISIBLE

        slider.addOnChangeListener { _, value, _ ->
            tipPercentage = value.toDouble()
            setMessage()
        }

        editText.doAfterTextChanged { text ->
            bill = text?.toString() ?: ""
            setMessage()
        }
    }
}