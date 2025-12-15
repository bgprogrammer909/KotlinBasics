package com.example.ai37a

import android.graphics.Paint
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37a.ui.theme.AI37ATheme
import kotlin.math.round


class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileBody()
            }
        }
    }


@Composable
fun ProfileBody() {
//   this is required as it keeps the content within the limit not behind notification and home button
    Scaffold { padding->
        Column(
            modifier=Modifier
                .fillMaxSize()
                .background(color=Color.White)
                .padding(padding)
        ){
            Row(
                modifier= Modifier.fillMaxWidth()
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    painter =painterResource(R.drawable.baseline_keyboard_arrow_left_24),
                    contentDescription =null
                )
                Text("Srb2020",
                    style=TextStyle(fontWeight = FontWeight.Bold), fontSize = 18.sp)
                Icon(
                    painter =painterResource(R.drawable.baseline_more_horiz_24),
                    contentDescription =null
                )
            }
            Row(
                modifier= Modifier.fillMaxWidth(),
                verticalAlignment=Alignment.CenterVertically,
                horizontalArrangement=Arrangement.SpaceAround

            ){
                Image(
                    painter=painterResource(R.drawable.image),
                    contentDescription=null,
                    modifier= Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .clip(CircleShape),
                contentScale = ContentScale.Crop
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("414",
                        style=TextStyle(fontWeight = FontWeight.Bold), fontSize = 17.sp)
                    Text("Posts",
                        style=TextStyle(fontWeight = FontWeight.Bold), fontSize = 17.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("1M",
                        style=TextStyle(fontWeight = FontWeight.Bold), fontSize = 17.sp)
                    Text("Followers",
                        style=TextStyle(fontWeight = FontWeight.Bold), fontSize = 17.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("1432",
                        style=TextStyle(fontWeight = FontWeight.Bold), fontSize = 17.sp)
                    Text("Follows",
                        style=TextStyle(fontWeight = FontWeight.Bold), fontSize = 17.sp)
                }

            }

            Column(modifier = Modifier.padding(top=15.dp,start=5.dp,end=5.dp,bottom=5.dp)){
                Text("Sage of sun",
                    style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 19.sp
                )
            }
            Column(modifier = Modifier.padding(top=15.dp,start=5.dp,end=5.dp,bottom=5.dp)){
                Text("It is what it is!!!")
            }
            Button(onClick = {/*action
            */
            },
                shape = RoundedCornerShape(size = 10.dp),colors= ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Black)

            ){
                Text("Follow"
                )
            }
            Card(
                modifier= Modifier.height(200.dp)
                    .width(300.dp),
                shape=RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(10.dp)

            ) {
                Column(
                    modifier=Modifier.fillMaxSize()){
                    Text("Nice one")
                }
            }
            Row(modifier= Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround){
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter=painterResource(R.drawable.image),
                        contentDescription = "Story 1",
                        modifier= Modifier.height(75.dp)
                            .width(75.dp)
                            .clip(CircleShape),
                        contentScale= ContentScale.Crop
                    )
                    Text("story 1")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter=painterResource(R.drawable.image),
                        contentDescription = "Story ",
                        modifier= Modifier.height(75.dp)
                            .width(75.dp)
                            .clip(CircleShape),
                        contentScale= ContentScale.Crop
                    )
                    Text("story 2")
                }
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter=painterResource(R.drawable.image),
                        contentDescription = "Story 4",
                        modifier= Modifier.height(75.dp)
                            .width(75.dp)
                            .clip(CircleShape),
                        contentScale= ContentScale.Crop
                    )
                    Text("story 3")
                }
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter=painterResource(R.drawable.image),
                        contentDescription = "Story 5",
                        modifier= Modifier.height(75.dp)
                            .width(75.dp)
                            .clip(CircleShape),
                        contentScale= ContentScale.Crop
                    )
                    Text("story 4")
                }

            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AI37ATheme {
        ProfileBody()
    }
}