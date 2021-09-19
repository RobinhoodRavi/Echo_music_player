package com.drawer.musicplayer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drawer.musicplayer.R


class AllsongRecycleradapter :RecyclerView.Adapter<AllsongRecycleradapter.AllsongViewHolder>(){
    class AllsongViewHolder(view:View):RecyclerView.ViewHolder(view){

        val textView:TextView=view.findViewById(R.id.txtRecyclerRowItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllsongViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.recycler_allsong_single_row,parent,false)

        return AllsongViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllsongViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
