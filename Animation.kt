/*
This is a Jetpack Compose animation example that animates a Box's size and background color.
The box changes size when a button inside it is clicked.
The box's background color keeps changing infinitely between Red and Green.
Jetpack Compose animations like animateDpAsState and rememberInfiniteTransition are used to
achieve smooth animations.
*/

package com.example.practice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge rendering for immersive UI
        setContent {

            // State variable to store the size of the Box
            var sizeState by remember { mutableStateOf(200.dp) }

            // Animated size transition when the state changes
            val size by animateDpAsState(
                targetValue = sizeState,
                animationSpec = tween( // Tween animation for smooth transition
                    durationMillis = 1000, // Animation duration (1 second)
                    delayMillis = 300, // Delay before animation starts
                    easing = LinearOutSlowInEasing // Easing function for smooth effect
                )
            )

            // Infinite color transition between Red and Green
            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.Red, // Start with Red color
                targetValue = Color.Green, // Transition to Green color
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 500), // Change color every 500ms
                    repeatMode = RepeatMode.Reverse // Reverse back and forth
                )
            )

            // Box container with animated size and color
            Box(
                modifier = Modifier
                    .size(size) // Dynamic size based on animation
                    .background(color), // Dynamic background color animation
                contentAlignment = Alignment.Center // Aligns button in the center
            ) {
                // Button to increase the size of the box
                Button(onClick = {
                    sizeState += 50.dp // Increase size by 50dp on each click
                }) {
                    Text("Increase Size") // Button label
                }
            }
        }
    }
}
