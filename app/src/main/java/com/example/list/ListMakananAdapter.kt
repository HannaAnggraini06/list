package com.example.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListMakananAdapter(private val listMakanan: ArrayList<Makanan>) : RecyclerView.Adapter<ListMakananAdapter.ListViewHolder>() {
    private  lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.img_item)
        val name: TextView = itemView.findViewById(R.id.item_name)
        val desc: TextView = itemView.findViewById(R.id.item_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMakanan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listMakanan[position]
        holder.image.setImageResource(photo)
        holder.name.text = name
        holder.desc.text = desc
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listMakanan[holder.adapterPosition])
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listMakanan[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Makanan)
    }
}