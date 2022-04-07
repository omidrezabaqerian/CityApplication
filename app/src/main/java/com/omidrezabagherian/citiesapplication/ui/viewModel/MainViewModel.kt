package com.omidrezabagherian.citiesapplication.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omidrezabagherian.citiesapplication.model.CityModel

class MainViewModel : ViewModel() {

    private var list = mutableListOf(
        CityModel("Tehran", false),
        CityModel("Qazvin", false),
        CityModel("Gilan", false),
        CityModel("Mazandaran", false),
        CityModel("Bandar-Abbas", false),
        CityModel("Kerman-shah", false),
        CityModel("Mashhad", false)
    )

    private val listOfFavorite = mutableListOf<CityModel>()

    var listOfFavoriteLiveData = MutableLiveData<MutableList<CityModel>>(mutableListOf())

    val listOfCityLiveData = MutableLiveData(list)

    fun select(position: Int, isSelected: Boolean) {

        if (isSelected) {
            listOfFavorite.remove(list[position])
            listOfFavoriteLiveData.value = listOfFavorite
        } else {
            listOfFavorite.add(list[position])
            listOfFavoriteLiveData.value = listOfFavorite
        }

        list[position].cityIsSelected = list[position].cityIsSelected.not()
        listOfCityLiveData.value?.get(position)?.cityIsSelected = list[position].cityIsSelected

    }

    fun removeItem(position: Int) {
        listOfFavorite.removeAt(position)
        listOfFavoriteLiveData.value = listOfFavorite

        list[position].cityIsSelected = list[position].cityIsSelected.not()
        listOfCityLiveData.value = list
    }

}