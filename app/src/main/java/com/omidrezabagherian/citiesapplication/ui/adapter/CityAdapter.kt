package com.omidrezabagherian.citiesapplication.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.omidrezabagherian.citiesapplication.R
import com.omidrezabagherian.citiesapplication.model.CityModel

class CityAdapter(
    private val listOfCityModel: MutableList<CityModel>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<CityAdapter.FirstFragmentViewHolder>() {

    inner class FirstFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        private val cardViewCity: CardView = itemView.findViewById(R.id.cardViewCity)
        private val textViewCity: TextView = itemView.findViewById(R.id.textViewCity)

        fun bind(cityModel: CityModel) {
            textViewCity.text = cityModel.cityName
            if (cityModel.cityIsSelected) {
                cardViewCity.setCardBackgroundColor(Color.parseColor("#6200EE"))
            } else {
                cardViewCity.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

        override fun onClick(view: View?) {
            itemClickListener.click(
                bindingAdapterPosition,
                listOfCityModel[bindingAdapterPosition].cityIsSelected
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstFragmentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return FirstFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirstFragmentViewHolder, position: Int) {
        holder.bind(listOfCityModel[position])
    }

    override fun getItemCount(): Int {
        return listOfCityModel.size
    }
}