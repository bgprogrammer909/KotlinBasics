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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37a.ui.theme.AI37ATheme

class Practice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cardy()
        }
    }
}

@Composable
fun Cardy() {
   Scaffold {paddingValues ->
       Column(modifier=Modifier.padding(paddingValues).background(Color.Green).fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.End){
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = null,
                modifier =Modifier.size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

        }
           Row(modifier = Modifier.fillMaxWidth().padding(10.dp) ){
               Text("Card", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
           }
           Row(modifier = Modifier.fillMaxWidth().padding(10.dp) ){
               Text("Simple and easy to use app", color = Color.White, fontSize = 20.sp)
           }
           //one
           Row(modifier = Modifier.fillMaxWidth().padding(10.dp) ){
               Card(
                   modifier = Modifier.height(125.dp).weight(1f),
                   shape = RoundedCornerShape(5.dp),
                   colors = CardDefaults.cardColors(Color.White,
                       contentColor = Color.Black),
                   elevation = CardDefaults.cardElevation(10.dp)
               ){
                   Column(modifier = Modifier.fillMaxWidth(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center){
                       Image(
                           painter=painterResource(R.drawable.img_1),
                           contentDescription = null,
                           modifier = Modifier.size(80.dp)
                       )
                       Text("Black and white guy")
                       Text("Random", color = Color.Gray, fontSize = 10.sp)
                   }
               }
               Spacer(modifier = Modifier.width(15.dp))
               Card(
                   modifier = Modifier.height(125.dp).weight(1f),
                   shape = RoundedCornerShape(5.dp),
                   colors = CardDefaults.cardColors(Color.White,
                       contentColor = Color.Black),
                   elevation = CardDefaults.cardElevation(10.dp)
               ){
                   Column(modifier = Modifier.fillMaxWidth(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center){
                       Image(
                           painter=painterResource(R.drawable.img_1),
                           contentDescription = null,
                           modifier = Modifier.size(80.dp)
                       )
                       Text("Black and white guy")
                       Text("Random", color = Color.Gray, fontSize = 10.sp)

                   }
           }
               Spacer(modifier = Modifier.height(15.dp))
               //end
           }
           Row(modifier = Modifier.fillMaxWidth().padding(10.dp) ){
               Card(
                   modifier = Modifier.height(125.dp).weight(1f),
                   shape = RoundedCornerShape(5.dp),
                   colors = CardDefaults.cardColors(Color.White,
                       contentColor = Color.Black),
                   elevation = CardDefaults.cardElevation(10.dp)
               ){
                   Column(modifier = Modifier.fillMaxWidth(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center){
                       Image(
                           painter=painterResource(R.drawable.img_1),
                           contentDescription = null,
                           modifier = Modifier.size(80.dp)
                       )
                       Text("Black and white guy")
                       Text("Random", color = Color.Gray, fontSize = 10.sp)
                   }
               }
               Spacer(modifier = Modifier.width(15.dp))
               Card(
                   modifier = Modifier.height(125.dp).weight(1f),
                   shape = RoundedCornerShape(5.dp),
                   colors = CardDefaults.cardColors(Color.White,
                       contentColor = Color.Black),
                   elevation = CardDefaults.cardElevation(10.dp)
               ){
                   Column(modifier = Modifier.fillMaxWidth(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center){
                       Image(
                           painter=painterResource(R.drawable.img_1),
                           contentDescription = null,
                           modifier = Modifier.size(80.dp)
                       )
                       Text("Black and white guy")
                       Text("Random", color = Color.Gray, fontSize = 10.sp)

                   }
           }
               Spacer(modifier = Modifier.height(15.dp))
               //end
           }
           Row(modifier = Modifier.fillMaxWidth().padding(10.dp) ){
               Card(
                   modifier = Modifier.height(125.dp).weight(1f),
                   shape = RoundedCornerShape(5.dp),
                   colors = CardDefaults.cardColors(Color.White,
                       contentColor = Color.Black),
                   elevation = CardDefaults.cardElevation(10.dp)
               ){
                   Column(modifier = Modifier.fillMaxWidth(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center){
                       Image(
                           painter=painterResource(R.drawable.img_1),
                           contentDescription = null,
                           modifier = Modifier.size(80.dp)
                       )
                       Text("Black and white guy")
                       Text("Random", color = Color.Gray, fontSize = 10.sp)
                   }
               }
               Spacer(modifier = Modifier.width(15.dp))
               Card(
                   modifier = Modifier.height(125.dp).weight(1f),
                   shape = RoundedCornerShape(5.dp),
                   colors = CardDefaults.cardColors(Color.White,
                       contentColor = Color.Black),
                   elevation = CardDefaults.cardElevation(10.dp)
               ){
                   Column(modifier = Modifier.fillMaxWidth(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center){
                       Image(
                           painter=painterResource(R.drawable.img_1),
                           contentDescription = null,
                           modifier = Modifier.size(80.dp)
                       )
                       Text("Black and white guy")
                       Text("Random", color = Color.Gray, fontSize = 10.sp)

                   }
           }
               Spacer(modifier = Modifier.height(15.dp))
               //end
           }
           Row(modifier = Modifier.fillMaxWidth().padding(10.dp) ){
               Card(
                   modifier = Modifier.height(100.dp).weight(1f),
                   shape = RoundedCornerShape(5.dp),
                   colors = CardDefaults.cardColors(Color.White,
                       contentColor = Color.Black),
                   elevation = CardDefaults.cardElevation(10.dp)
               ){
                   Row (modifier = Modifier.fillMaxWidth())
//                       horizontalAlignment = Alignment.CenterHorizontally,
//                       verticalArrangement = Arrangement.Center)
                       {
                       Icon(
                           painter =painterResource(R.drawable.outline_settings_24),
                           contentDescription = null,
                           modifier= Modifier.size(90.dp)

                       )
                           Column {
                               Text("Settings", color = Color.Black, fontSize = 50.sp)
                               Text("This is the settings", color = Color.Gray, fontSize = 20.sp)
                           }


                   }
               }}



       }
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    Cardy()
}