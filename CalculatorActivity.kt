package com.lionos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    private var currentInput = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_calculator
        )

        resultText =
            findViewById(R.id.resultText)

        // NUMEROS

        val buttons = listOf(
            R.id.btn0,
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9
        )

        for (id in buttons) {

            val button =
                findViewById<Button>(id)

            button.setOnClickListener {

                currentInput += button.text

                resultText.text =
                    currentInput
            }
        }

        // OPERADORES

        val plus =
            findViewById<Button>(R.id.btnPlus)

        val minus =
            findViewById<Button>(R.id.btnMinus)

        val multiply =
            findViewById<Button>(R.id.btnMultiply)

        val divide =
            findViewById<Button>(R.id.btnDivide)

        plus.setOnClickListener {

            currentInput += "+"
            resultText.text = currentInput
        }

        minus.setOnClickListener {

            currentInput += "-"
            resultText.text = currentInput
        }

        multiply.setOnClickListener {

            currentInput += "*"
            resultText.text = currentInput
        }

        divide.setOnClickListener {

            currentInput += "/"
            resultText.text = currentInput
        }

        // LIMPIAR

        val clear =
            findViewById<Button>(R.id.btnClear)

        clear.setOnClickListener {

            currentInput = ""

            resultText.text = "0"
        }

        // RESULTADO

        val equals =
            findViewById<Button>(R.id.btnEquals)

        equals.setOnClickListener {

            try {

                val result =
                    calculate(currentInput)

                resultText.text =
                    result.toString()

                currentInput =
                    result.toString()

            } catch (e: Exception) {

                resultText.text = "Error"
            }
        }
    }

    // =====================================
    // CALCULADORA SIMPLE
    // =====================================

    private fun calculate(expression: String): Double {

        return object {

            var pos = -1
            var ch = 0

            fun nextChar() {

                ch =
                    if (++pos < expression.length)
                        expression[pos].code
                    else -1
            }

            fun eat(charToEat: Int): Boolean {

                while (ch == ' '.code)
                    nextChar()

                if (ch == charToEat) {

                    nextChar()
                    return true
                }

                return false
            }

            fun parse(): Double {

                nextChar()

                val x = parseExpression()

                return x
            }

            fun parseExpression(): Double {

                var x = parseTerm()

                while (true) {

                    x = when {

                        eat('+'.code) ->
                            x + parseTerm()

                        eat('-'.code) ->
                            x - parseTerm()

                        else -> return x
                    }
                }
            }

            fun parseTerm(): Double {

                var x = parseFactor()

                while (true) {

                    x = when {

                        eat('*'.code) ->
                            x * parseFactor()

                        eat('/'.code) ->
                            x / parseFactor()

                        else -> return x
                    }
                }
            }

            fun parseFactor(): Double {

                if (eat('+'.code))
                    return parseFactor()

                if (eat('-'.code))
                    return -parseFactor()

                val startPos = pos

                while (
                    ch in '0'.code..'9'.code ||
                    ch == '.'.code
                ) {
                    nextChar()
                }

                return expression.substring(
                    startPos,
                    pos
                ).toDouble()
            }

        }.parse()
    }
}