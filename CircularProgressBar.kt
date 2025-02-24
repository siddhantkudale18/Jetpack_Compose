/*
This code is an Android Jetpack Compose implementation of a circular progress bar with animation.
It visually represents a percentage value using an animated arc and displays the corresponding
number inside the circle.
*/

package com.example.practice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.TextUnit

// MainActivity: Entry point of the application
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables full-screen edge-to-edge rendering
        setContent {
            // Center the CircularProgressBar inside a Box
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                // Display CircularProgressBar with 70% progress
                CircularProgressBar(percentage = 0.7f, number = 100)
            }
        }
    }
}

// CircularProgressBar: Custom composable to display an animated circular progress indicator
@Composable
fun CircularProgressBar(
    percentage: Float,  // Percentage of progress (0.0 to 1.0)
    number: Int,  // Maximum number to display (e.g., 100 for percentage)
    fontSize: TextUnit = 28.sp,  // Text size inside the progress bar
    radius: Dp = 50.dp,  // Radius of the circular progress bar
    color: Color = Color.Blue,  // Color of the progress arc
    strokeWidth: Dp = 8.dp,  // Thickness of the progress arc
    animDuration: Int = 2000,  // Animation duration in milliseconds
    animDelay: Int = 0  // Delay before animation starts
) {
    // Mutable state to track whether the animation has started
    var animationPlayed by remember { mutableStateOf(false) }

    // Animated float state to smoothly transition from 0f to target percentage
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )

    // Start the animation when the composable enters the composition
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    // Box to center the Circular ProgressBar elements
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f) // Set the size of the progress bar
    ) {
        // Draw the circular progress arc using Canvas
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,  // Progress arc color
                startAngle = -90f,  // Start from the top (12 o'clock)
                sweepAngle = 360 * curPercentage.value,  // Draw the arc based on animated percentage
                useCenter = false,  // Open-ended arc (not a filled pie)
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round) // Rounded edges for smooth look
            )
        }

        // Display the animated percentage inside the circle as text
        Text(
            text = (curPercentage.value * number).toInt().toString(),  // Convert animated percentage to an integer
            color = Color.Black,  // Text color
            fontSize = fontSize,  // Font size
            fontWeight = FontWeight.Bold  // Make text bold
        )
    }
}
