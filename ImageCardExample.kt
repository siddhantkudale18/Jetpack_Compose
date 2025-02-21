package com.example.imagecard // Change this to your actual package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Load image from resources
            val painter = painterResource(id = R.drawable.cat1)
            val description = "This is an image of a cat made by AI"
            val title = "The Cat"
            
            // Display Image Card
            ImageCard(
                painter = painter,
                contentDescription = description,
                title = title
            )
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp), // Add padding around the card
        shape = RoundedCornerShape(15.dp), // Rounded corners
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp) // Card shadow effect
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart // Align text at the bottom
        ) {
            // Display the image inside the card
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop, // Crop image to fit container
                modifier = Modifier.fillMaxSize()
            )
            
            // Overlay box for text
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}
