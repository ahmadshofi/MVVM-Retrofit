package com.ahmad.mvvm_retrofit.adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmad.mvvm_retrofit.R
import com.ahmad.mvvm_retrofit.model.DataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.wisata_item.view.*

class WisataAdapter (val data : List<DataItem>) : RecyclerView.Adapter<WisataAdapter.MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.wisata_item,parent,false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindView(data.get(position))
    }

    class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(get : DataItem){
            itemView.itemLokasi.text = get.lokasi
            itemView.itemName.text = get.namaTempat
            Picasso.get().load(get.gambar)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(itemView.itemImg)
        }

    }

}