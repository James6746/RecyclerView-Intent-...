package com.example.recyclerviewwithintent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MemberAdapterKotlin(
    var context: Context,
    var members: ArrayList<Member>,
    var onClick: OnClick
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_member, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MemberViewHolder) {
            holder.tv_name.text = members[position].name
            holder.tv_age.text = members[position].age.toString()
            holder.itemView.setOnClickListener { onClick.accomplish(holder.getAdapterPosition()) }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    inner class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_name: TextView
        var tv_age: TextView

        init {
            tv_name = itemView.findViewById(R.id.tv_name)
            tv_age = itemView.findViewById(R.id.tv_age)
        }
    }

    interface OnClick {
        fun accomplish(position: Int)
    }
}