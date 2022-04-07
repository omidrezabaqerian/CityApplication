package com.omidrezabagherian.citiesapplication.ui.first

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.omidrezabagherian.citiesapplication.R
import com.omidrezabagherian.citiesapplication.databinding.ActivityMainBinding
import com.omidrezabagherian.citiesapplication.databinding.FragmentCityBinding
import com.omidrezabagherian.citiesapplication.model.CityModel
import com.omidrezabagherian.citiesapplication.ui.adapter.ItemClickListener
import com.omidrezabagherian.citiesapplication.ui.adapter.CityAdapter
import com.omidrezabagherian.citiesapplication.ui.second.SelectFragment
import com.omidrezabagherian.citiesapplication.ui.viewModel.MainViewModel

class CityFragment : Fragment(R.layout.fragment_city), ItemClickListener {

    private val mainViewModel: MainViewModel by activityViewModels()
    private val listCity = mutableListOf<CityModel>()
    private lateinit var cityBinding:FragmentCityBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityBinding = FragmentCityBinding.bind(view)

        cityBinding.buttonSaveSelect.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, SelectFragment())
                .addToBackStack("main").setReorderingAllowed(true).commit()
        }

        mainViewModel.listOfCityLiveData.value?.also {
            listCity.clear()
            listCity.addAll(it)
            cityBinding.recyclerViewCity.adapter = CityAdapter(listCity, this)
        }

    }

    override fun click(position: Int, isSelected: Boolean) {
        mainViewModel.select(position, isSelected)
        cityBinding.recyclerViewCity.adapter?.notifyItemChanged(position)
    }

}