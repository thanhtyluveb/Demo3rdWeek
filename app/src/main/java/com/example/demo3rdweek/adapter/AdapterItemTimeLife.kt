package com.example.demo3rdweek.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3rdweek.R
import com.example.demo3rdweek.fragment.InBoxFragment
import com.example.demo3rdweek.model.TimeLifeModel
import kotlinx.android.synthetic.main.item_time_life.view.*

class AdapterItemTimeLife(private val iInterface: ITranferData?) :
    RecyclerView.Adapter<AdapterItemTimeLife.ViewHolder>() {
    var listTimeLife: ArrayList<TimeLifeModel> = ArrayList()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_time_life, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTimeLife.size
    }

    fun setListData(list: ArrayList<TimeLifeModel>) {
        this.listTimeLife = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val itemData = listTimeLife[i]
        viewHolder.itemView.imgAvatarTimeLife.setImageResource(itemData.resourceImage)
        viewHolder.itemView.tvNameLifeTime.text = itemData.name
        viewHolder.itemView.tvTimeTimeLife.text = itemData.time
        viewHolder.itemView.tvContentTimeLife.text = itemData.content
        viewHolder.itemView.setOnClickListener {
            iInterface?.sendData(itemData.name)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

interface ITranferData {
    fun sendData(name: String)
}