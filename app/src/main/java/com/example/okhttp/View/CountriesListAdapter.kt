package com.example.okhttp.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.okhttp.Model.Flag
import com.example.okhttp.R
import com.squareup.picasso.Picasso

class CountriesListAdapter(var flagList: MutableList<Flag>): RecyclerView.Adapter<CountriesListAdapter.ViewHolder>() {
    private lateinit var listener: OnCountryCellClickListener

    interface OnCountryCellClickListener {
        fun onItemClick(flag: Flag)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.flag_imageview)
        val countryName: TextView = view.findViewById(R.id.country_name)
        val population: TextView = view.findViewById(R.id.population_textview)
        val language: TextView = view.findViewById(R.id.language_textview)
        val capital: TextView = view.findViewById(R.id.capital_name)
        val currency: TextView = view.findViewById(R.id.currency_textview)
        val button: Button = view.findViewById(R.id.to_detail_button)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_items, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val flag = flagList[position]
        Picasso.get().load(flag.pictureId).resize(120, 80).into(viewHolder.image)
        viewHolder.countryName.text = flag.name
        viewHolder.population.text = flag.population
        viewHolder.language.text = flag.language
        viewHolder.capital.text = flag.capital
        viewHolder.currency.text = flag.currency
        viewHolder.button.setOnClickListener {
            listener.onItemClick(flag)
        }
    }

    override fun getItemCount(): Int = flagList.size

    fun setOnCountryClickListener(listener: OnCountryCellClickListener) {
        this.listener = listener
    }
}