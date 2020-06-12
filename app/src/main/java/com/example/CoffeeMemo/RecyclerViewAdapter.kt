package com.example.CoffeeMemo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class RecyclerViewAdapter(private val context: Context):RecyclerView.Adapter<RecyclerViewAdapter.hogeHolder>() {
val items: MutableList<realmData> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hogeHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_hoge_data_cell,parent,false)
        return hogeHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: hogeHolder, position: Int) {
        val item = items[position]
        holder.hogeImage.load(item.RealmImageResorce){
            error(R.drawable.no_image)
        }
        holder.hogeNameTextView.text = item.RealmName
        holder.hogeDetailView.text = item.Realmmemo

        holder.container.setOnClickListener {
            val preview = Intent(context,PopupActivity::class.java)
            popup(item,preview)
        }
    }

    fun addall(items: List<realmData>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class hogeHolder(view: View) : RecyclerView.ViewHolder(view){
        val container: ConstraintLayout = view.findViewById(R.id.container)
        val hogeImage: ImageView = view.findViewById(R.id.imageView)
        val hogeNameTextView: TextView = view.findViewById(R.id.NameTextView)
        val hogeDetailView: TextView = view.findViewById(R.id.descriptionTextView)
    }

    fun popup(realmData: realmData,preview:Intent) {
        preview.putExtra("image",realmData.RealmImageResorce)
        preview.putExtra("Name",realmData.RealmName)
        preview.putExtra("flavor",realmData.RealmFlavor)
        preview.putExtra("acidity",realmData.RealmAcidity)
        preview.putExtra("body",realmData.RealmBody)
        preview.putExtra("region",realmData.RealmRegion)
        preview.putExtra("processing",realmData.RealmProcessing)
        preview.putExtra("memo",realmData.Realmmemo)
        context.startActivity(preview)
    }

}