package com.example.modul5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5.network.ProductEntry
import com.example.modul5.staggeredgridlayout.StaggeredProductCardRecyclerViewAdapter

class ProductGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment with the ProductGrid theme
        val view = inflater.inflate(R.layout.shr_product_grid_fragment, container, false)

        val app_bar = view.findViewById<Toolbar>(R.id.app_bar)
        val recycler_view = view.findViewById<RecyclerView>(R.id.recycler_view)
        val recycler_view_2 = view.findViewById<RecyclerView>(R.id.recycler_view_2)
        val recycler_view_3 = view.findViewById<RecyclerView>(R.id.recycler_view_3)
        val product_grid = view.findViewById<NestedScrollView>(R.id.product_grid)

        // Set up the tool bar
        (activity as AppCompatActivity).setSupportActionBar(app_bar)
        app_bar.setNavigationOnClickListener(
            NavigationIconClickListener(
                requireActivity(),
                product_grid,
                AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(requireContext(), R.drawable.shr_branded_menu), // Menu open icon
                ContextCompat.getDrawable(requireContext(), R.drawable.shr_close_menu))
        ) // Menu close icon

        // Set up the first RecyclerView
        recycler_view.setHasFixedSize(true)
        val linearLayoutManager1 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler_view.layoutManager = linearLayoutManager1
        val adapter1 = StaggeredProductCardRecyclerViewAdapter(
            ProductEntry.initProductEntryList(resources))
        recycler_view.adapter = adapter1

        // Set up the second RecyclerView
        recycler_view_2.setHasFixedSize(true)
        val linearLayoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_2.layoutManager = linearLayoutManager2
        val adapter2 = StaggeredProductCardRecyclerViewAdapter(
            ProductEntry.initProductEntryList(resources))
        recycler_view_2.adapter = adapter2

        // Set up the third RecyclerView
        recycler_view_3.setHasFixedSize(true)
        val linearLayoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_3.layoutManager = linearLayoutManager3
        val adapter3 = StaggeredProductCardRecyclerViewAdapter(
            ProductEntry.initProductEntryList(resources))
        recycler_view_3.adapter = adapter3

        // Set cut corner background for API 23+
        product_grid.background = context?.getDrawable(R.drawable.shr_product_grid_background_shape)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }
}
