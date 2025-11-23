/*
 * Course: MAD204
 * Description: RecyclerView with Swipe, Undo, Click, and Sorting.
 */
package com.example.assignment2_darshilkumar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import java.util.*

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvEmpty: TextView // Added
    private lateinit var adapter: CountryAdapter
    private val countryList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        tvEmpty = findViewById(R.id.tvEmpty) // Initialize
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val countries = listOf("Canada", "USA", "Brazil", "France", "Germany", "Japan", "India", "China", "Australia", "Mexico")
        countryList.addAll(countries)

        // Pass a Long Click Listener to the adapter (the second lambda)
        adapter = CountryAdapter(countryList,
            onClick = { selectedItem ->
                Toast.makeText(this, "You selected: $selectedItem", Toast.LENGTH_SHORT).show()
            },
            onLongClick = { position ->
                deleteItem(position)
            }
        )
        recyclerView.adapter = adapter
        checkEmptyState() // Check initially

        // Keep the swipe logic (it's a bonus!) but make sure it calls checkEmptyState()
        // ... (inside onSwiped)
        // countryList.removeAt(position)
        // adapter.notifyItemRemoved(position)
        // checkEmptyState()
    }

    private fun deleteItem(position: Int) {
        val deletedItem = countryList[position]
        countryList.removeAt(position)
        adapter.notifyItemRemoved(position)
        checkEmptyState()

        Snackbar.make(recyclerView, "$deletedItem deleted", Snackbar.LENGTH_LONG)
            .setAction("UNDO") {
                countryList.add(position, deletedItem)
                adapter.notifyItemInserted(position)
                checkEmptyState()
            }.show()
    }

    private fun checkEmptyState() {
        if (countryList.isEmpty()) {
            tvEmpty.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            tvEmpty.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }

    // ... Option Menu code remains the same
}