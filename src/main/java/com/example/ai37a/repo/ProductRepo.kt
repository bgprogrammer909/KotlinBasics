package com.example.ai37a.repo

import com.example.ai37a.model.ProductModel
import javax.security.auth.callback.Callback

interface ProductRepo {
    fun addProduct(model: ProductModel,callback:(Boolean, String)-> Unit)

    fun updateProduct(productId:String,model:ProductModel,callback: (Boolean, String) -> Unit)

    fun deleteProduct(productId:String,callback: (Boolean, String) -> Unit)

    fun getAllProduct(callback: (Boolean, String, List<ProductModel>?) -> Unit)

    fun getProductById(productId:String,callback: (Boolean, String, ProductModel?) -> Unit)
}