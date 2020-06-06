package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context):RecyclerView.Adapter<RecyclerViewAdapter.hogeHolder>() {
val items: MutableList<hogeData> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hogeHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_hoge_data_cell,parent,false)
        return hogeHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: hogeHolder, position: Int) {
        val item = items[position]
        holder.hogeImage.setImageResource(item.hogeImageResorce)
        holder.hogeNameTextView.text = item.hogeName
        holder.hogeDetailView.text = item.description

        holder.hogeImage.setOnClickListener {
            val preview = Intent(context,PopupActivity::class.java)
            popup(item,preview)
        }
    }

    fun addall(items: List<hogeData>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class hogeHolder(view: View) : RecyclerView.ViewHolder(view){
        val hogeImage: ImageView = view.findViewById(R.id.imageView)
        val hogeNameTextView: TextView = view.findViewById(R.id.NameTextView)
        val hogeDetailView: TextView = view.findViewById(R.id.descriptionTextView)
    }

    fun popup(hogeData: hogeData,preview:Intent) {
        preview.putExtra("image",hogeData.hogeImageResorce)
        preview.putExtra("Name",hogeData.hogeName)
        preview.putExtra("description",hogeData.description)
        context.startActivity(preview)
    }

}