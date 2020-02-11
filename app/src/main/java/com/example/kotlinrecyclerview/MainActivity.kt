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

class MainActivity : AppCompatActivity(), DataAdapter.ItemClickListener {

    private lateinit var list: List<PostData>
    private lateinit  var dataAdapter: DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = DataSet.getDataSet()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            //layoutManager = GridLayoutManager(this@MainActivity, 2)
            //layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            dataAdapter = DataAdapter(this@MainActivity)
            dataAdapter.setData(list)
            adapter = dataAdapter
        }

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
