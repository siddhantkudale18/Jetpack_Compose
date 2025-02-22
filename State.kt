/*This Kotlin code is an Android Jetpack Compose application that divides the screen 
vertically into two different color sections. Each section starts with a default 
color (Yellow and Red), and when the user clicks on a section, its color changes randomly.
*/

package com.example.practice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column (
                modifier = Modifier.fillMaxSize()
            ){
                ColorBox(
                   modifier = Modifier
                       .fillMaxHeight(0.5f)
                       .fillMaxWidth(),
                    initialColor = Color.Yellow
                )
                ColorBox(
                    modifier = Modifier
                        .fillMaxHeight(1f)
                        .fillMaxWidth(),
                    initialColor = Color.Red
                )
            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier, initialColor: Color) {
    // Use `var` with `by remember { mutableStateOf() }` for cleaner syntax
    var color by remember { mutableStateOf(initialColor) }

    // Apply `modifier` properly so the Box takes up the whole screen
    Box(
        modifier = modifier
            .background(color) // Corrected modifier usage
            .clickable {
                color = Color(
                    Random.nextFloat(), // Generates a random color
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            }
    )
}

