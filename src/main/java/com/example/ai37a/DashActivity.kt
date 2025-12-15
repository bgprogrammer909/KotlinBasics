package com.example.ai37a

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai37a.ui.theme.AI37ATheme

class DashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashBody()
        }
    }
}

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBody(){
    val context= LocalContext.current
    val activity=context as Activity
    val email=activity.intent.getStringExtra("Email")
    val password=activity.intent.getStringExtra("pass")

    var selectedIndex by remember() { mutableStateOf(0) }

    data class NItems(val label:String,val Icon: Int)

    val listItems=listOf(
        NItems(label = "Home",Icon=R.drawable.baseline_home_24),
        NItems(label = "Search",Icon=R.drawable.baseline_search_24),
        NItems(label = "Notification",Icon=R.drawable.outline_notifications_24),
        NItems(label = "Profile",Icon=R.drawable.baseline_person_24)
    )

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar ={TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White,
                containerColor = Color.DarkGray
            ),
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_keyboard_arrow_left_24),
                        contentDescription = null
                    )
                }
            },
            title = {
                Text("top bar")
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.outline_settings_24),
                        contentDescription = null
                    )
                }
            }
        )},
        bottomBar = {
            NavigationBar {
                listItems.forEachIndexed { index, item->
                    NavigationBarItem(
                        icon = {Icon(
                            painter = painterResource(item.Icon),
                            contentDescription = null
                        )},
                        label ={
                            Text(item.label)
                        },
                        onClick = {
                            selectedIndex=index
                        },
                        selected = selectedIndex==index

                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()){
            when(selectedIndex){
                0->HomeScreen()
                1->SearchScreen()
                2->NotificationScreen()
                3->PersonScreen()
                else -> HomeScreen()
            }
        }

    }
}

@Composable
@Preview
fun PreviewDash(){
    DashBody()
}