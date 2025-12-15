package com.example.ai37a

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Card

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login()
        }
    }
}

@Composable
fun Login(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }

    val context= LocalContext.current
    val activity= context as Activity

    val sharedPreferences=context.getSharedPreferences("User", Context.MODE_PRIVATE)

    val localEmail:String?=sharedPreferences.getString("email","")
    val localPassword:String?=sharedPreferences.getString("password","")

    Scaffold {pad->
        Column(modifier = Modifier
            .padding(pad)
            .fillMaxSize()) {
            Spacer(modifier=Modifier.height(60.dp))
            Row( modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){
                Text("Sign In",
                    style= TextStyle(
                        fontWeight = FontWeight.Bold,
                        color= Color.Blue,
                        fontSize = 30.sp
                    ))
            }
            Row( modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){
                Text("This is login UI and it is important classwork done in class ik it is imp thats why id do yoyoyoyoyoyoyoyo",
                    style= TextStyle(
                        fontWeight = FontWeight.Bold,
                        color= Color.Gray,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center
                    ))
                    }
            Spacer(modifier=Modifier.height(20.dp))
            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ){
                Card(modifier = Modifier
                    .height(50.dp)
                    .weight(1F)){
                    Row(modifier= Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically){
                        Image(
                            painter=painterResource(R.drawable.img_6),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text("    Facebook")
                    }
                }
                Spacer(modifier=Modifier.width(10.dp))

                Card(modifier = Modifier
                    .height(50.dp)
                    .weight(1F)){
                    Row(modifier= Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically){
                        Image(
                            painter=painterResource(R.drawable.img_9),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text("    Gmail")
                    }
                }
                }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
                ){
                HorizontalDivider(modifier = Modifier.weight(1F))
                Text("Or", modifier = Modifier.padding(horizontal = 10.dp))
                HorizontalDivider(modifier = Modifier.weight(1F))

                }

            OutlinedTextField(
                value = email,
                onValueChange ={ data ->
                    email=data
                }, placeholder = {Text("abc@gmail.com")},
                colors= TextFieldDefaults.colors(
                    unfocusedContainerColor =  Color.LightGray,
                    focusedContainerColor = Color.Gray,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp)

                )
            OutlinedTextField(
                value = password,
                onValueChange ={ data ->
                    password=data
                },
                colors= TextFieldDefaults.colors(
                    unfocusedContainerColor =  Color.LightGray,
                    focusedContainerColor = Color.Gray,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                trailingIcon = {
                    IconButton(onClick = {visibility=!visibility}) {
                        Icon(
                            painter = if (visibility)
                                        painterResource(R.drawable.outline_visibility_24)
                                      else
                                        painterResource(R.drawable.outline_visibility_off_24),
                            contentDescription = null
                        )
                        }
                    },
                visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(10.dp),
                placeholder = {Text("*********")},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
                )

            Text(
                "Forget password",
                style = TextStyle(
                    textAlign = TextAlign.End
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                    }
                    .padding(vertical = 15.dp, horizontal = 15.dp)
            )
            Button(
                onClick = {
                    if (localEmail==email && localPassword==password){
                        val intent=Intent(
                            context,
                            DashActivity::class.java
                        )
                        intent.putExtra("Email", email)
                        intent.putExtra("pass", password)

                        Toast.makeText(context,"Login successful!", Toast.LENGTH_SHORT).show()

                        context.startActivity(intent)
                        activity.finish()
                    }else{
                        Toast.makeText(context,"Username or password invalid", Toast.LENGTH_SHORT).show()

                    }




                },
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp

                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
                ) {
                Text("Log In")
            }
            Text(buildAnnotatedString {
                append("Don't have account")
                withStyle(SpanStyle(color = Color.Blue)){
                    append("Sign up")
                }
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 20.dp)
                    .clickable {
                        val intent = Intent(
                            context,
                            RegistrationActivity::class.java
                        )
                        context.startActivity(intent)

                    })



        }


//don't limit the cross
        }



            }






@Preview
@Composable
fun LoginPreview(){
    Login()
}