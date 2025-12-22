package com.example.ai37a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37a.ui.theme.AI37ATheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
         Spotify()
        }
    }
}

@Composable
fun Spotify() {
    Scaffold {paddingValues->

        Column(modifier= Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = Color.Black)

        ) {
            Row(
                modifier = Modifier.padding(top=50.dp,start=20.dp,end=20.dp,bottom=20.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                Column {
                    Text("Recently played", style= TextStyle(fontSize = 18.sp,
                        fontWeight = FontWeight.Bold),
                        color = Color.White)
                }
                Row {
                    Icon(
                        painter= painterResource(R.drawable.outline_notifications_24),
                        contentDescription=null,
                        tint=Color.White,
                        modifier= Modifier.padding(5.dp)
                    )
                    Icon(
                        painter =painterResource(R.drawable.outline_refresh_24),
                        contentDescription =null,
                        tint=Color.White,
                        modifier= Modifier.padding(5.dp)
                    )
                    Icon(
                        painter =painterResource(R.drawable.outline_settings_24),
                        contentDescription = null,
                        tint=Color.White,
                        modifier= Modifier.padding(5.dp)
                    )

                }

            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start=10.dp,end=10.dp,bottom=20.dp),

                )
            {
                Column(modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier.height(100.dp)
                            .width(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text("Lana Del Rey",color=Color.White)
                }
                Column (modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_1),
                        contentDescription = null,
                        modifier = Modifier.height(100.dp)
                            .width(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text("Marvin Gaye",color=Color.White)

                }
            }
            Row(
                modifier= Modifier.padding(20.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.img_4),
                    contentDescription = null,
                    modifier = Modifier.height(70.dp)

                )
                Column{
                    Row{
                        Text("#SPOTIFYWRAPPED",color=Color.Gray)
                    }
                    Row {
                        Text("Your 2021 in review", style= TextStyle(fontSize = 20.sp,
                            fontWeight = FontWeight.Bold),
                            color = Color.White)
                    }
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start=10.dp,end=10.dp,bottom=20.dp),

                )
            {
                Column(modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_2),
                        contentDescription = null,
                        modifier = Modifier.height(150.dp)
                            .width(150.dp)

                    )
                    Text("Your top song 2021",color=Color.White)
                }
                Column (modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_5),
                        contentDescription = null,
                        modifier = Modifier.height(150.dp)
                            .width(150.dp)

                    )
                    Text("Your artists revealed",color=Color.White)

                }
            }
            Column {
                Row(modifier= Modifier.padding(start=20.dp)){
                    Text("Editor's picks", style= TextStyle(fontSize = 20.sp,
                        fontWeight = FontWeight.Bold),
                        color = Color.White)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 20.dp),

                    )
                {
                    Column(
                        modifier = Modifier.padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img),
                            contentDescription = null,
                            modifier = Modifier.height(150.dp)
                                .width(150.dp)

                        )
                        Text("Songs by Lana Del Ray", color = Color.Gray)
                    }
                    Column(
                        modifier = Modifier.padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img_3),
                            contentDescription = null,
                            modifier = Modifier.height(150.dp)
                                .width(150.dp)

                        )
                        Text("Songs by other artist like Bruno Mars,MJ and many more..", color = Color.Gray)

                    }
                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun SpotifyPreview() {
    Spotify()
}