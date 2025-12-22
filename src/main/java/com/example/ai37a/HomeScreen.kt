package com.example.ai37a

import android.app.Activity
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37a.model.ProductModel
import com.example.ai37a.repo.ProductRepoImpl
import com.example.ai37a.ui.theme.PurpleGrey80
import com.example.ai37a.viewmodel.ProductViewModel

@Composable
fun HomeScreen() {
//    var text by remember { mutableStateOf("") }
//    val images = listOf(
//        R.drawable.img,
//        R.drawable.img_9,
//        R.drawable.img_1,
//        R.drawable.img_4,
//        R.drawable.img_2,
//        R.drawable.img_6,
//        R.drawable.img_3,
//    )
//    val names = listOf(
//        "Facebook",
//        "Bettafish",
//        "Dog",
//        "Bird",
//        "Hamster",
//        "Goldfish",
//        "GuineaPig",
//    )
//    val prices = listOf(
//        "Rs101",
//        "Rs1020",
//        "Rs103",
//        "Rs104",
//        "Rs1050",
//        "Rs106",
//        "Rs107",
//    )
    var pName by remember { mutableStateOf("") }
    var pPrice by remember { mutableStateOf("") }
    var pDesc by remember { mutableStateOf("") }

    val context = LocalContext.current
    val activity = context as? Activity

    val productViewModel=remember { ProductViewModel(ProductRepoImpl()) }

    LaunchedEffect(Unit) {
        productViewModel.getAllProduct()
    }

    val allProducts=productViewModel.allProducts.observeAsState(initial=emptyList())

    var showDialog by remember {mutableStateOf(false)}


    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.White),

    ) {
        item {
            if (showDialog){
                AlertDialog(
                    onDismissRequest = {
                        showDialog=false
                    },
                    confirmButton = {
                        TextButton(onClick = {}) {Text("update") }
                    },
                    dismissButton = {
                        TextButton(onClick = {}) {Text("cancel") }
                    },
                    title = {Text("Update product")},
                    text={
                        Column{
                            Spacer(modifier = Modifier.height(15.dp))

                            OutlinedTextField(
                                value = pName,
                                onValueChange = { data ->
                                    pName = data
                                },
                                shape = RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product Price")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Color.Blue,
                                    unfocusedIndicatorColor = Color.Transparent
                                )

                            )
                            Spacer(modifier = Modifier.height(15.dp))

                            OutlinedTextField(
                                value = pPrice,
                                onValueChange = { data ->
                                    pPrice = data
                                },
                                shape = RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product Price")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Color.Blue,
                                    unfocusedIndicatorColor = Color.Transparent
                                )

                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value = pDesc,
                                onValueChange = { data ->
                                    pDesc = data
                                },
                                shape = RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product Description")
                                },
                                maxLines = 5,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Color.Blue,
                                    unfocusedIndicatorColor = Color.Transparent
                                )

                            )

                        }
                    }
                )
            }
        }


        items(allProducts.value!!.size){
            index ->
            var data=allProducts.value!![index]
            Card(modifier = Modifier.fillMaxWidth().padding(vertical=10.dp))
            {
             Column{
                 Text(data.name)
                 Text(data.price.toString())
                 Text(data.desc)
                 IconButton(onClick = {
                     showDialog=true
                 }){
                     Icon(Icons.Default.Edit,
                         contentDescription = null
                     )
                     }


                 IconButton(onClick = {
                     productViewModel.deleteProduct(data.productId){
                       success,msg ->
                         if (success){


                         }else{

                         }


                     }
                 }){
                     Icon(Icons.Default.Delete,
                         contentDescription = null
                     )
                     }
                 }

             }
            }
        }

    }



//    }
//}
@Preview
@Composable
fun PreviewHome(){
    HomeScreen()
}