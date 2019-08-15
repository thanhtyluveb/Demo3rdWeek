package com.example.demo3rdweek.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3rdweek.R
import com.example.demo3rdweek.model.InBoxModel
import kotlinx.android.synthetic.main.item_inbox_list.view.*

class AdapterInbox : RecyclerView.Adapter<AdapterInbox.ViewHolder>() {
    var listInBox: ArrayList<InBoxModel> = ArrayList()
    fun setListData(list: ArrayList<InBoxModel>) {
        this.listInBox = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_inbox_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listInBox.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = listInBox[position]
        holder.itemView.apply {
            tvNameInbox.text = itemData.name
            tvMessageInbox.text = itemData.messContent
            tvTimeInBox.text = itemData.time
            if (itemData.numberMess == 0) {
                cvNumberMess.visibility = View.GONE
            } else {
                cvNumberMess.visibility = View.VISIBLE
                tvNumberMess.text = itemData.numberMess.toString()
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}