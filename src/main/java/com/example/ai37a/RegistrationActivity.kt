package com.example.ai37a


import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import com.example.ai37a.model.UserModel
import com.example.ai37a.repo.UserRepoImpl
import com.example.ai37a.ui.theme.AI37ATheme
import com.example.ai37a.viewmodel.UserViewModel
import java.util.Calendar

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Register()

        }
    }
}

@Composable
fun Register() {

    var userViewModel=remember{ UserViewModel(UserRepoImpl()) }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }
    var terms by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }
    val context= LocalContext.current
    val activity=context as Activity

//    case sensitive it make a file in the phone like table in database
//    imp for saving data
//    val sharedPreferences=context.getSharedPreferences("User", Context.MODE_PRIVATE)
//    val editor=sharedPreferences.edit()

    var calender= Calendar.getInstance()
    var year=calender.get(Calendar.YEAR)
    var month=calender.get(Calendar.MONTH)
    var day=calender.get(Calendar.DAY_OF_MONTH)

    var datePicker= DatePickerDialog(
        context, { _, y, m, d ->
            selectedDate = "$y/${m + 1},$d"
        }, year, month, day
    )

    Scaffold { pad ->
        Column(modifier = Modifier.padding(pad).fillMaxSize()) {
            Spacer(modifier = Modifier.height(60.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Sign Up",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        fontSize = 30.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            OutlinedTextField(
                value = email,
                onValueChange = { data ->
                    email = data
                }, placeholder = { Text("abc@gmail.com") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.LightGray,
                    focusedContainerColor = Color.Gray,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp)

            )
            OutlinedTextField(
                value = password,
                onValueChange = { data ->
                    password = data
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.LightGray,
                    focusedContainerColor = Color.Gray,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                trailingIcon = {
                    IconButton(onClick = { visibility = !visibility }) {
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
                placeholder = { Text("*********") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )
            OutlinedTextField(
                value = selectedDate,
                onValueChange = { data ->
                    email = data
                }, enabled = false,
                placeholder = { Text("dd/mm/yyyy") },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color.LightGray,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Blue,
                    focusedContainerColor = Color.Gray,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp).clickable{
                    datePicker.show()
                }

            )
                Row(modifier = Modifier.fillMaxWidth().padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically){
                    Checkbox(
                        checked=terms,
                        onCheckedChange = {data ->
                            terms=data
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Green,
                            uncheckedColor = Color.Black
                        )
                    )
                    Text("I agree to terms and conditions")
                }
            Button(
                onClick = {
                    if (!terms){
                        Toast.makeText(context,"please agree to terms",Toast.LENGTH_SHORT).show()
                    }else{
                        userViewModel.register(email,password){
                            success,msg,userId ->
                            if (success){
                                val model= UserModel(
                                    userId=userId,
                                    email=email,
                                    firstName = "default",
                                    lastName = "default",
                                    dob = selectedDate
                                )
                                userViewModel.addUserToDatabase(userId,model){
                                    success,msg ->
                                    if (success){
                                        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()

                                    }
                                }
                            }else{
                                Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()

                            }
                        }
                    }




//                    val localEmail:String?=sharedPreferences.getString("email","")
//                    val localPassword:String?=sharedPreferences.getString("password","")
//                    if (!terms){
//                        Toast.makeText(context,"please agree to terms",Toast.LENGTH_SHORT).show()
//                    }
//                    else if (localEmail==email){
//                        Toast.makeText(context,"User already exists",Toast.LENGTH_SHORT).show()


//                    }
//                    else{
//                        editor.putString("email",email)
//                        editor.putString("password",password)
//                        editor.putString("date",selectedDate)
//
//                        editor.apply()
//                        activity.finish()
//                        Toast.makeText(context,"Registation success",Toast.LENGTH_SHORT).show()

//                    }


                },
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp

                ),
                modifier = Modifier
                    .fillMaxWidth().height(60.dp)
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text("Sign In")
            }
            Text(
                buildAnnotatedString {
                    append("Already have an account?")
                    withStyle(SpanStyle(color = Color.Blue)) {
                        append("Sign in")
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 20.dp)
            )


        }


//don't limit the cross
    }
}


@Preview
@Composable
fun PreviewReg(){
    Register()
}