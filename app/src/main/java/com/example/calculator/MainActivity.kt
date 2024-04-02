package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import org.mariuszgromada.math.mxparser.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorScreen()
        }
    }
}


@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {

    var expression by remember{
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        // for calculation
        Column(modifier = modifier
            .weight(1f)
            .padding(16.dp)) {
            Text(modifier = Modifier
                .fillMaxWidth(),
                text = expression,
                style = TextStyle(
                    fontSize = 40.sp,
                    color = Color.White,
                    textAlign = TextAlign.End
                ),
                maxLines = 3
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(modifier = Modifier
                .fillMaxWidth(),
                text = result,
                style = TextStyle(
                    fontSize = 48.sp,
                    color = Color.White,
                    textAlign = TextAlign.End
                )
            )
        }

        // for buttons
        Column {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    isFunctional = true,
                    text = "AC",
                    modifier = modifier,
                    onClick = {
                        expression = ""
                        result = ""
                    })

                CalculatorButton(
                    isFunctional = true,
                    text = "⌫",
                    modifier = modifier,
                    onClick = {
                        expression = delCharacter(expression)
                    })

                CalculatorButton(
                    isFunctional = true,
                    text = "%",
                    modifier = modifier,
                    onClick = {

                        if(expression[expression.length-1].toString() == "%" || expression[expression.length-1].toString() == "÷" ||
                            expression[expression.length-1].toString() == "×" || expression[expression.length-1].toString() == "-" ||
                            expression[expression.length-1].toString() == "+") {
                            expression += ""
                        }else {
                            expression += it
                        }
                    })

                CalculatorButton(
                    isFunctional = true,
                    text = "÷",
                    modifier = modifier,
                    onClick = {
                        if(expression[expression.length-1].toString() == "%" || expression[expression.length-1].toString() == "÷" ||
                            expression[expression.length-1].toString() == "×" || expression[expression.length-1].toString() == "-" ||
                            expression[expression.length-1].toString() == "+") {
                            expression += ""
                        }else {
                            expression += it
                        }
                    })
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    text = "7",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    text = "8",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    text = "9",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    isFunctional = true,
                    text = "×",
                    modifier = modifier,
                    onClick = {
                        if(expression[expression.length-1].toString() == "%" || expression[expression.length-1].toString() == "÷" ||
                            expression[expression.length-1].toString() == "×" || expression[expression.length-1].toString() == "-" ||
                            expression[expression.length-1].toString() == "+") {
                            expression += ""
                        }else {
                            expression += it
                        }
                    })
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    text = "4",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    text = "5",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    text = "6",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    isFunctional = true,
                    text = "-",
                    modifier = modifier,
                    onClick = {
                        if(expression[expression.length-1].toString() == "%" || expression[expression.length-1].toString() == "÷" ||
                            expression[expression.length-1].toString() == "×" || expression[expression.length-1].toString() == "-" ||
                            expression[expression.length-1].toString() == "+") {
                            expression += ""
                        }else {
                            expression += it
                        }
                    })
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    text = "1",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    text = "2",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    text = "3",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    isFunctional = true,
                    text = "+",
                    modifier = modifier,
                    onClick = {
                        if(expression[expression.length-1].toString() == "%" || expression[expression.length-1].toString() == "÷" ||
                            expression[expression.length-1].toString() == "×" || expression[expression.length-1].toString() == "-" ||
                            expression[expression.length-1].toString() == "+") {
                            expression += ""
                        }else {
                            expression += it
                        }
                    })
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    isFunctional = true,
                    text = "AC",
                    modifier = modifier,
                    onClick = {
                        expression = ""
                        result = ""
                    })

                CalculatorButton(
                    text = "0",
                    modifier = modifier,
                    onClick = {
                        expression += it
                    })

                CalculatorButton(
                    text = ".",
                    modifier = modifier,
                    onClick = {
                        if(!expression.contains(".")) {
                            expression += it
                        }
                    })

                CalculatorButton(
                    isFunctional = true,
                    text = "=",
                    modifier = modifier,
                    onClick = {
                        if(expression.isEmpty()) return@CalculatorButton
                        result = solveExpression(expression)
                    })
            }
        }
    }
}

fun solveExpression(expression: String): String {

    var answer = ""

    try {
        answer = Expression(expression
            .replace("÷", "/")
            .replace("×", "*")
        ).calculate().toString()
    }catch (e:Exception) {
        e.printStackTrace()
        return "Invalid Expression"
    }

    return answer.replace(".0", "")
}


fun delCharacter(exp: String): String {
    if (exp.length >= 1) {
        return exp.substring(0, exp.length - 1)
    } else {
        return exp
    }
}

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    text: String = "",
    isFunctional: Boolean = false,
    onClick: (String) -> Unit = {}
) {

    val color = if (isFunctional) {
        Color(0xFFFF8000)
    } else {
        // Default button text color
        Color.White
    }

    Button(
        modifier = if (text == "=") {
            modifier
                .size(60.dp)
        } else {
            modifier
                .size(80.dp)
        }
            .clip(CircleShape),
        onClick = { onClick(text) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (text == "=") {
                Color(0xFFFF8000)
            } else {
                Color.Black
            }
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = if (text == "AC") {
                    24.sp
                } else {
                    30.sp
                },
                color = if (text == "=") {
                    Color.White
                } else {
                    color
                },
                textAlign = TextAlign.Center
            ),
        )
    }
}

@Preview
@Composable
fun CalculatorButtonsPrev() {
    CalculatorButton()
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPrev() {
    CalculatorScreen()
}
