package com.example.kotlinrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kotlinrecyclerview.model.PostData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DataAdapter.ItemClickListener , PostAdapter.Interaction{

    private lateinit var list: List<PostData>       // list for data set
    private lateinit  var dataAdapter: DataAdapter  // Adapter for recycler view
    private lateinit var postAdapter: PostAdapter   // Adapter for recycler with with DiffUtil & AsyncListDiff
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set init data set
        list = DataSet.getInitDataSet()

        /*
        // recyclerView with no DiffUtil
        recyclerView.apply {

            // Liner layout
            layoutManager = LinearLayoutManager(this@MainActivity)

            // Grid Layout
            //layoutManager = GridLayoutManager(this@MainActivity, 2)

            // Staggered Grid Layout
            //layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            dataAdapter = DataAdapter(this@MainActivity)
            dataAdapter.setData(list)
            adapter = dataAdapter
        }*/

        recyclerView.apply{

            layoutManager = LinearLayoutManager(this@MainActivity)
            postAdapter  = PostAdapter(this@MainActivity)
            postAdapter.submitList(list)
            adapter = postAdapter
        }


        button.setOnClickListener {
            list = DataSet.getDataSet()
            postAdapter.submitList(list)
        }

    }

    override fun onItemSelected(position: Int, item: PostData) {

        var result = list.get(position).name  + " / " + list.get(position).auth
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()

        var  intent =  Intent(this, Detail::class.java)
        intent.putExtra("title", list[position].name)
        intent.putExtra("auth", list[position].auth)
        intent.putExtra ("image", list[position].image)

        startActivity(intent)
    }
    override fun onClickListened(position: Int) {

         var result = list.get(position).name  + " / " + list.get(position).auth
         Toast.makeText(this, result, Toast.LENGTH_LONG).show()

         var  intent =  Intent(this, Detail::class.java)
        intent.putExtra("title", list[position].name)
        intent.putExtra("auth", list[position].auth)
        intent.putExtra ("image", list[position].image)

        startActivity(intent)
    }
}
