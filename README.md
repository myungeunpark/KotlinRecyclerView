# RecyclerView Layout Type

![image](https://user-images.githubusercontent.com/53125879/74468394-9c4e9500-4e4f-11ea-873b-a9435cfa3c2b.png)v

image source : https://tutorial.eyehunts.com/


    // Liner layout 
    layoutManager = LinearLayoutManager(this@MainActivity)

    // Grid Layout
    //layoutManager = GridLayoutManager(this@MainActivity, 2)

    // Staggered Grid Layout
    //layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    


# KotlinRecyclerView Project 

source : myungeunpark/KotlinRecyclerView/app

## Application screenshots 

Implement recyclerview with LinearLayout 


![image](https://user-images.githubusercontent.com/53125879/74289570-47dad680-4ce4-11ea-99e2-1bf042be12a8.png)


After clicking the item of list


![image](https://user-images.githubusercontent.com/53125879/74289608-693bc280-4ce4-11ea-9354-4180ae8794ae.png)



## How to develop the recycler view 

 1. dependency (build.gradle)
 
<pre>
<code>
  // recycler view 
  implementation 'androidx.recyclerview:recyclerview:1.1.0'
</code>
</pre>
  
 2. Add the recyclerview component on the activity layout 

```
   <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```   
        
 3. Create recycler item layout     
  
```
  <?xml version="1.0" encoding="utf-8"?>
  <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="10dp">


    <androidx.cardview.widget.CardView
        app:cardBackgroundColor="@android:color/transparent"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardCornerRadius="5dp"
        app:cardElevation="5dp"
        app:cardPreventCornerOverlap="false">

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            >

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:src="@mipmap/ic_launcher"
                android:id="@+id/imageView"
                android:padding="0dp"
                android:layout_margin="0dp"
                android:adjustViewBounds="true"
                android:scaleType="fitXY"/>

            <TextView
                android:id="@+id/title"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_below="@+id/imageView"
                android:padding="10dp"
                android:text="Image Name"
                android:textColor="#000"
                android:textSize="20sp"
                android:textStyle="bold" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Image Name"
                android:id="@+id/author"
                android:layout_below="@+id/title"
                android:paddingLeft="10dp"
                android:paddingBottom="10dp"
                android:textColor="#000"/>

        </RelativeLayout>


    </androidx.cardview.widget.CardView>


</RelativeLayout>
```
  
  
4. Create Data class 
  
<pre>
<code>
  // DataSet.kt  
  data class PostData (var image: String, var name: String, var auth : String)
</code>
</pre> 
  
5. Create Adapter class for recyclerview
  
<pre>
<code>

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
</code>
</pre>


6. set the adapter to the recycler view on Activity class 

<pre>
<code>

private lateinit var list: List<PostData>       // list for data set
private lateinit  var dataAdapter: DataAdapter  // Adapter for recycler view

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
        }
</code>
</pre>



## Improve the performance of recyclerview with DiffUtil and Async

DiffUtil is a utility class that calculates the difference between two lists and outputs a list of update operations that converts the first list into the second one. 
It can be used to calculate updates for a RecyclerView Adapter. See ListAdapter and AsyncListDiffer which can simplify the use of DiffUtil on a background thread.

https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/DiffUtil

<pre>
<code>
 val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PostData>() {


        override fun areItemsTheSame(oldItem: PostData, newItem: PostData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PostData, newItem: PostData): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)
</code>
</pre>


## How to ListAdapter Template 

https://codingwithmitch.com/blog/kotlin-recyclerview-template/




