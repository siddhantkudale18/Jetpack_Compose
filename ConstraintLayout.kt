/*
This code defines a Jetpack Compose UI using ConstraintLayout.
The MainActivity sets up the UI with the example() composable function.
The example() function contains a ConstraintLayout that places two colored boxes (Box) 
and a Text component.
The layout positions each element using constraints to align them properly
*/

package com.example.practice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

// Main activity that sets up the UI
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Enables edge-to-edge display for immersive UI
        enableEdgeToEdge()
        
        // Sets the content view with Jetpack Compose UI
        setContent {
            example() // Calls the example composable function
        }
    }
}

// Composable function that uses ConstraintLayout to arrange UI elements
@Composable
fun example() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize() // Makes ConstraintLayout take full screen size
    ) {
        // Creates references for the UI elements
        val (box1, box2, text) = createRefs()

        // Red Box positioned at the top-left corner with margins
        Box(
            modifier = Modifier
                .size(100.dp) // Sets the size to 100.dp
                .background(Color.Red) // Background color red
                .constrainAs(box1) { // Constraints for positioning
                    top.linkTo(parent.top, margin = 16.dp) // Top margin of 16.dp
                    start.linkTo(parent.start, margin = 16.dp) // Start margin of 16.dp
                }
        )

        // Blue Box positioned below the red box and to its right
        Box(
            modifier = Modifier
                .size(100.dp) // Sets the size to 100.dp
                .background(Color.Blue) // Background color blue
                .constrainAs(box2) { // Constraints for positioning
                    top.linkTo(box1.bottom, margin = 16.dp) // Below red box with 16.dp margin
                    start.linkTo(box1.end, margin = 16.dp) // Right of red box with 16.dp margin
                }
        )

        // Text positioned below the blue box and centered horizontally
        Text(
            text = "Hello Jetpack Compose", // Text content
            modifier = Modifier.constrainAs(text) { // Constraints for positioning
                top.linkTo(box2.bottom, margin = 16.dp) // Below blue box with 16.dp margin
                start.linkTo(parent.start) // Aligns start with parent
                end.linkTo(parent.end) // Aligns end with parent (centers the text)
            }
        )
    }
}
