package com.drawer.musicplayer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drawer.musicplayer.R


class AllsongFragment : Fragment() {

    lateinit var recyclerAllsong:RecyclerView

    lateinit var layoutManager:RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_allsong, container, false)

        recyclerAllsong=view.findViewById(R.id.recyclerAllsong)

        layoutManager=LinearLayoutManager(activity)

        return view
    }


}