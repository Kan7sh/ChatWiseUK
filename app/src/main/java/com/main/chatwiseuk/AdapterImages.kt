package com.main.chatwiseuk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import retrofit2.Callback

class AdapterImages(
    val context: Context,
    val modelImagesList:ArrayList<ModelImages>):Adapter<AdapterImages.HolderImages>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderImages {
        val view =   LayoutInflater.from(context).inflate(R.layout.row_images,parent,false)
        return HolderImages(view)
    }

    override fun onBindViewHolder(holder: HolderImages, position: Int) {
        val modelImages = modelImagesList[position]
        holder.title.setText(modelImages.title)
        Glide.with(holder.itemView)
            .load(modelImages.url)
            .placeholder(R.drawable.image_placeholder)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return modelImagesList.size
    }

    inner class HolderImages(itemView: View):ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(R.id.imgV)
        var title = itemView.findViewById<TextView>(R.id.txt)
    }
}