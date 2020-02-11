package com.example.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinrecyclerview.model.PostData
import kotlinx.android.synthetic.main.item_view.view.*

class DataAdapter constructor  (val listener : ItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var arrayList :List<PostData> = ArrayList()

    interface ItemClickListener{

        fun onClickListened(position : Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is DataViewHolder -> {
                holder.bind(arrayList.get(position))
            }

        }
    }

    fun setData(list: List<PostData>){

        arrayList = list
    }

    inner class DataViewHolder constructor (itemView: View): RecyclerView.ViewHolder(itemView){

        val viewImage = itemView.imageView
        val titleText = itemView.title
        val authorText = itemView.author

        init{

            itemView.setOnClickListener{
                listener.onClickListened(adapterPosition)
            }

        }

        fun bind(post :PostData){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(post.image)
                .into(viewImage)
            titleText.setText(post.name)
            authorText.setText("photographed by " + post.auth)


        }


    }
}