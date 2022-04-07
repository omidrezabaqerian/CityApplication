package com.omidrezabagherian.citiesapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.omidrezabagherian.citiesapplication.R
import com.omidrezabagherian.citiesapplication.model.CityModel

class SelectAdapter(private val listOfCityModel: MutableList<CityModel>) :
    RecyclerView.Adapter<SelectAdapter.SecondFragmentViewHolder>() {

    class SecondFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView: TextView = itemView.findViewById(R.id.textViewCity)

        fun bind(cityModel: CityModel) {
            textView.text = cityModel.cityName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondFragmentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return SecondFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondFragmentViewHolder, position: Int) {
        holder.bind(listOfCityModel[position])
    }

    override fun getItemCount(): Int {
        return listOfCityModel.size
    }

}