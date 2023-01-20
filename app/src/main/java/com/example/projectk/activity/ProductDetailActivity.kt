package com.example.projectk.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.projectk.R
import com.example.projectk.databinding.ActivityProductDetailBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        
        getProductDetails(intent.getStringExtra("id"))
        
        setContentView(binding.root)
    }

    private fun getProductDetails(proId: String?) {

        Firebase.firestore.collection("products")
            .document(proId!!).get().addOnSuccessListener {
                val list = it.get("productImages") as ArrayList<String>
                binding.textView7.text = it.getString("productName")
                binding.textView8.text = it.getString("productSp")
                binding.textView9.text = it.getString("ProductDescription")

                val slidelist = ArrayList<SlideModel>()
                for (data in list){
                    slidelist.add(SlideModel(data, ScaleTypes.FIT))
                }
                binding.imageSlider.setImageList(slidelist)

            }.addOnFailureListener{
                Toast.makeText(this, "Something Went Wrong.!", Toast.LENGTH_SHORT).show()
            }

    }
}