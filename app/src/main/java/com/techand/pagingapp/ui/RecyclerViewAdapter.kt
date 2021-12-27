package com.techand.pagingapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techand.pagingapp.R
import com.techand.pagingapp.data.model.CharResult

class RecyclerViewAdapter : PagingDataAdapter<CharResult, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.raw_item, parent, false)
        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageview)
        val tvName: TextView = view.findViewById(R.id.textview_name)
        val tvDesc: TextView = view.findViewById(R.id.textview_desc)

        fun bind(data: CharResult) {
            tvName.text = data.name
            tvDesc.text = data.species

            Glide.with(imageView)
                .load(data.image)
                .circleCrop()
                .into(imageView)
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<CharResult>() {
        override fun areItemsTheSame(oldItem: CharResult, newItem: CharResult): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CharResult, newItem: CharResult): Boolean {
            return oldItem.name == newItem.name && oldItem.species == newItem.species
        }

    }



}
