package com.example.profilenotification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilenotification.ui.theme.ProfileNotificationTheme

import androidx.compose.runtime.*

// Layouts
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment

// Image
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileNotificationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileNotification()
                }
            }
        }
    }
}



@Composable
fun ProfileNotification(){
    // State variable to track if the badge should be shown or hidden
    var showBadge by remember { mutableStateOf(true) }

    // Column to arrange elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize(), //column take up the entire screen
        verticalArrangement = Arrangement.Center,  // center button and profile vertically
        horizontalAlignment = Alignment.CenterHorizontally // center button and profile horizontally


    ) {
        // stacking the profile image and the badge on top of each other
        Box {
            Image(
                painter = painterResource(id = R.drawable.profileicon), // use image.png here
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(200.dp) //  size of the image
                    .clip(CircleShape)
            )

            // Conditional badge display
            if (showBadge) {
                // Small circular badge in the bottom-end corner of the profile image
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red, shape = CircleShape)
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.Center // center the text inside the badge
                ) {
                    Text("3", color = Color.White, fontSize = 20.sp)
                }
            }
        }

        // Button below the profile image to toggle badge visibility
        Button(onClick = { showBadge = !showBadge }) {
            Text(if (showBadge) "Hide Badge" else "Show Badge")
        }
    }
}