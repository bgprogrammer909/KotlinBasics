package com.example.ai37a


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37a.ui.theme.AI37ATheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainBody()
                }
            }
        }
@Composable
fun MainBody(){
    //UI component
    Column (
     horizontalAlignment =    Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    modifier= Modifier
        .fillMaxSize().background(color= colorResource(R.color.pink))

//        .height(100.dp)
//        .width(100.dp)


    ) {
        Text("Hello",style= TextStyle(
            fontSize = 100.sp,
            color=Color.White,
            fontStyle= FontStyle.Italic,
            textDecoration= TextDecoration.Underline,
            fontWeight= FontWeight.ExtraBold


        ))
        Text("Bello")
        Image(
            painter = painterResource(R.drawable.image),
            contentDescription=null,
            modifier= Modifier.size(400.dp)
        )
    }
}

fun login(){
//    login
}

@Preview
@Composable
fun PreviewBody(){
    MainBody()
}
