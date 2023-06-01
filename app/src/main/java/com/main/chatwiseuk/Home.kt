package com.main.chatwiseuk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response


class Home : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var imagesmodelList:ArrayList<ModelImages>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.imagesRV)
        imagesmodelList = ArrayList()
        val call = ImagesService.newsInstance.getImages()

        call.enqueue(object :retrofit2.Callback<List<ModelImages>>{
            override fun onResponse(call: Call<List<ModelImages>>, response: Response<List<ModelImages>>) {

                if (response.isSuccessful) {
                    val imageList = response.body()
                    val adapterImages = AdapterImages(this@Home,imagesmodelList)
                    recyclerView.adapter = adapterImages
                    if(imageList!=null){
                        imagesmodelList.addAll(imageList)
                        for(i in imageList){
                        imagesmodelList.add(i)
                        adapterImages.notifyItemInserted(imagesmodelList.size)
                        }
                    }
                } else {
                    // Handle the API error
                }
            }

            override fun onFailure(call: Call<List<ModelImages>>, t: Throwable) {
                Log.d("ERROR", "onFailure: $t")

            }

        }
)
    }
}
