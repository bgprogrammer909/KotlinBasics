package com.example.ai37a.repo

import com.example.ai37a.model.ProductModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductRepoImpl : ProductRepo{
    val database: FirebaseDatabase= FirebaseDatabase.getInstance()

    val ref: DatabaseReference=database.getReference("products")

    override fun addProduct(
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        val id=ref.push().key.toString()
        model.productId=id

        ref.child(id).setValue(model).addOnCompleteListener {
            if (it.isSuccessful){
                callback(true,"Product added successfully")
            }else{
                callback(false,"${it.exception?.message}")

            }
        }
    }

    override fun updateProduct(
        productId: String,
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {

    }

    override fun deleteProduct(
        productId: String,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(productId).removeValue().addOnCompleteListener {
            if (it.isSuccessful){
                callback(true,"Product deleted successfully")
            }else{
                callback(false,"${it.exception?.message}")
            }
        }
    }

    override fun getAllProduct(callback: (Boolean, String, List<ProductModel>?) -> Unit) {
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var allProducts=mutableListOf<ProductModel>()
                for (data in snapshot.children){
                    val products=data.getValue(ProductModel::class.java)
                    if (products != null){
                        allProducts.add(products)
                    }
                }
                callback(true,"product fetched successfully",allProducts)
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, error.message, emptyList())            }
        }
        )
    }

    override fun getProductById(
        productId: String,
        callback: (Boolean, String, ProductModel?) -> Unit
    ) {
        ref.child(productId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val products = snapshot.getValue(ProductModel::class.java)
                    if (products != null) {
                        callback(true, "Product fetched successfully", products)
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, error.message, null)
            }
        })
    }
}

