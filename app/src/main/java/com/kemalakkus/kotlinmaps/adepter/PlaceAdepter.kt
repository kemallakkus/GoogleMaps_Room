package com.kemalakkus.kotlinmaps.adepter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.kemalakkus.kotlinmaps.databinding.RecyclerRowBinding
import com.kemalakkus.kotlinmaps.model.Place
import com.kemalakkus.kotlinmaps.view.MapsActivity

class PlaceAdepter(val placeList: List<Place>) : RecyclerView.Adapter<PlaceAdepter.PlaceHolder>() {

    class PlaceHolder(val recyclerRowBinding: RecyclerRowBinding) : RecyclerView.ViewHolder(recyclerRowBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlaceHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.recyclerRowBinding.recyclerViewTextView.text = placeList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,MapsActivity::class.java)
            intent.putExtra("selectedPlace",placeList.get(position))
            intent.putExtra("info","old")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }


}