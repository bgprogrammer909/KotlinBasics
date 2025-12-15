package com.example.ai37a

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PersonScreen(){
    Column (modifier = Modifier.fillMaxSize().background(Color.Green)){
        Text("Person Screen", color = Color.White)
    }
}