package com.omidrezabagherian.citiesapplication.ui.select

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.omidrezabagherian.citiesapplication.R
import com.omidrezabagherian.citiesapplication.databinding.FragmentSelectBinding
import com.omidrezabagherian.citiesapplication.ui.adapter.SelectAdapter
import com.omidrezabagherian.citiesapplication.ui.viewModel.MainViewModel

class SelectFragment : Fragment(R.layout.fragment_select) {

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var selectBinding: FragmentSelectBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectBinding = FragmentSelectBinding.bind(view)

        mainViewModel.listOfFavoriteLiveData.value?.also {
            selectBinding.recyclerViewSelect.adapter = SelectAdapter(it)
        }

        val swipeGesture = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == ItemTouchHelper.RIGHT) {
                    mainViewModel.removeItem(viewHolder.bindingAdapterPosition)
                }
                selectBinding.recyclerViewSelect.adapter?.notifyItemRemoved(viewHolder.bindingAdapterPosition)
            }
        }
        ItemTouchHelper(swipeGesture).attachToRecyclerView(selectBinding.recyclerViewSelect)
    }
}