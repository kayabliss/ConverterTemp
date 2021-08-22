package com.example.convertertemp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.convertertemp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val resetBtn: Button = findViewById(R.id.reset_button)
        val resetBtn: Button =binding.resetButton
        //val calBtn: Button = findViewById(R.id.calculate_button)
        val calBtn: Button = binding.calculateButton
        //val fehView = findViewById<View>(R.id.editTextNumber) as EditText //** look up "as" keywork in kotlin. Remember Clean organized code.
        val fehView: EditText = binding.editTextNumber
        val celView: EditText = binding.editTextNumber2
        //val celView = findViewById<View>(R.id.editTextNumber2) as EditText // This will give me a editable view, so that I can see the results and edit text .

        fun cel2Fah(temp: Float): Float {
          // get the user input: celsius editTextNumber2
        // (0°C × 9/ or 1.8) + 32 = 32°F
            var cel = ((temp * 9/5) + 32)
            return cel

        }

        fun fah2Cel(temp: Float): Float {//inner int to change to float or double. ...
            //(50°F - 32) x .5556 or 5/9 = 10°C
            var feh = (((temp - 32) * 5)/9)
            return feh.toFloat()
        }

        resetBtn.setOnClickListener {
            celView.getText().clear()
            fehView.getText().clear() // getText..finding whatever is in that view and . clear function clears the view.
        }

        calBtn.setOnClickListener{// Set on Click Listener - which listens to when the button is clicked // if they type in one of the views convert on of the edit text or the other.

             // Fahrenheit to Celsius
            if(celView.text.toString().isEmpty() ){//Checking if user typed anything in there? will give us a turn or false{
                var currentInput = fehView.text.toString().toFloat()// We set a new variable to a reference to what is written in fehview, get the data turn into text, then to a string and then to a float.
                var result = fah2Cel(currentInput)// we are calling the function and passing the parameter.
                celView.setText(result.toString())// we are setting( meaning display) the result to the celsius text box. c

            }else{
                // Celsius to Fahrenheit
                var userInput = celView.text.toString().toFloat()
                var resultF = cel2Fah(userInput)
                fehView.setText(resultF.toString())


            }
        }


    }
}

