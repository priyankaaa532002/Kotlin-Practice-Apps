package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Step 2 : Adapter Class                                                                           //extends recycler view <view holder>
class NewsListAdapter(private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>(){
                                                            //Step 11 contd.
    //Step 5: Implement members (red squiggle)

    private val items: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        //Step 7: XML to View using Layout inflater
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        //Step 12
        val viewHolder= NewsViewHolder(view)

        //Step 10 onClick handling
        view.setOnClickListener {
            //12 contd
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    //Step 8
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.id.text = currentItem._id
        holder.desc.text = currentItem.desc
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }
    //Step 6 (items ka size)
    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNews(updatedNews : ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

//Step 3: Making the Holder --> Step 4: make the individual item
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView : TextView = itemView.findViewById(R.id.title)
    val image : ImageView = itemView.findViewById(R.id.image)
    val desc : TextView = itemView.findViewById(R.id.desc)
    val id : TextView = itemView.findViewById(R.id.id)
}

//Step 11 making interface for onclick
interface NewsItemClicked{
    fun onItemClicked(item: News)
}