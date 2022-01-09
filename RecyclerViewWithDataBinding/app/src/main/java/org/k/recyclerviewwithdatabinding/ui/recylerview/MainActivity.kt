package org.k.recyclerviewwithdatabinding.ui.recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.k.recyclerviewwithdatabinding.adapter.Adapter
import org.k.recyclerviewwithdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // view binding for the activity
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    // create reference to the adapter
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // create layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        // set Layout manager for recylcerview
        binding.list.setLayoutManager(layoutManager)
        val model: ViewModel by viewModels()
        model.getUsers().observe(this,{users->
            // initialize the adapter,
            adapter = Adapter(model.getUsers().value)
            // attach adapter to the recycler view
            binding.list.adapter = adapter
        })
    }

    // on destroy of view make the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
