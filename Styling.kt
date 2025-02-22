// This is styling file
package com.example.practice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Box container to center the text on the screen with a dark background
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010)), // Dark gray background
                contentAlignment = Alignment.Center // Centers the text inside the Box
            ) {
                StyledText() // Calling the composable function to display text
            }
        }
    }
}

@Composable
fun StyledText() {
    Text(
        text = buildAnnotatedString {
            // Applying green color and large font size to 'J'
            withStyle(style = SpanStyle(color = Color.Green, fontSize = 50.sp)) {
                append("J")
            }
            append("etpack  ") // Regular text
            
            // Applying green color and large font size to 'C'
            withStyle(style = SpanStyle(color = Color.Green, fontSize = 50.sp)) {
                append("C")
            }
            append("ompose") // Regular text
        },
        color = Color.White, // Default text color
        fontSize = 30.sp, // Font size for the whole text
        fontWeight = FontWeight.Bold, // Bold text
        fontStyle = FontStyle.Italic, // Italic style
        textAlign = TextAlign.Center // Center align the text
    )
}
