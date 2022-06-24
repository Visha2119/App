package com.example.contact

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import okhttp3.HttpUrl
import retrofit2.Callback

class ItemAdapter (private  var itemList:List<ResultList>, private var context: Context): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
//     private var itemList = ArrayList<ResultList>()
//
//    fun setItemList(itemList:ArrayList<ResultList>){
//        this.itemList=itemList
//        notifyDataSetChanged()
//    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val cardView: CardView = itemView.findViewById(R.id.cv_user)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.each_item), parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemsViewModel = itemList.get(position)


        Log.d("Recycler view ", itemList[position].toString())
        Log.d("Size of List", itemsViewModel.toString())

        holder.textView.text = itemsViewModel.results.get(position).name.first
            Glide.with(holder.itemView.getContext())
                .load(itemsViewModel.results.get(position).picture.medium)
                .into(holder.imageView)

        //holder.imageView.setImageResource(itemList[position])

        holder.cardView.get(position).setOnClickListener {
            val intend= Intent(context, User::class.java )
            intend.putExtra("name", itemsViewModel.results.get(position).name.title+" "+ itemsViewModel.results.get(position).name.first+" "+itemsViewModel.results.get(position).name.last)
            intend.putExtra("gender", itemsViewModel.results.get(position).gender)
            intend.putExtra("country",itemsViewModel.results.get(position).location.country)
            context.startActivity(intend)

        }
        }

    override fun getItemCount(): Int {
        return itemList.size
    }
}


