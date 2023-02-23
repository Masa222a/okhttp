package com.example.okhttp.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.okhttp.Model.Entity.Embassy
import com.example.okhttp.R

class CountriesDetailEmbassyAdapter(var embassyList: MutableList<Embassy> = mutableListOf()): RecyclerView.Adapter<CountriesDetailEmbassyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.embassyTitle)
        val address: TextView = view.findViewById(R.id.embassyAddress)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.detail_embassies_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val embassy = embassyList[position]
        holder.title.text = embassy.title
        holder.address.text = embassy.address
    }

    override fun getItemCount(): Int = embassyList.size
}