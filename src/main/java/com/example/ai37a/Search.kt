package com.example.ai37a


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchScreen()
{
        var text by remember { mutableStateOf("") }
        val images = listOf(
            R.drawable.img,
            R.drawable.img_9,
            R.drawable.img_1,
            R.drawable.img_4,
            R.drawable.img_2,
            R.drawable.img_6,
            R.drawable.img_3,
        )
        val names = listOf(
            "Facebook",
            "Bettafish",
            "Dog",
            "Bird",
            "Hamster",
            "Goldfish",
            "GuineaPig",
        )
        val prices = listOf(
            "Rs101",
            "Rs1020",
            "Rs103",
            "Rs104",
            "Rs1050",
            "Rs106",
            "Rs107",
        )


        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Color.White),

            ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().background(Color.White),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_keyboard_arrow_left_24),
                        contentDescription = null
                    )
                    TextField(
                        value = text,
                        onValueChange = { data ->
                            text = data
                        },
                        placeholder = { Text("Search here") },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.baseline_search_24),
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.outline_mic_none_24),
                                contentDescription = null
                            )
                        }
                    )
                    Icon(
                        painter = painterResource(R.drawable.outline_settings_24),
                        contentDescription = null
                    )
                        }
                }
            item{
                
            }

        }
    }


@Preview
@Composable
fun previewOfSearch(){
    SearchScreen()
}