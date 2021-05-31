package com.hyunday.greenery_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class IllustratedFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_illustrated, null)
        var illustratedView: RecyclerView = view.findViewById(R.id.recyclerview_main) as RecyclerView
        //var layoutManager = LinearLayoutManager(view.context)
        var layoutManager = GridLayoutManager(view.context, 2)
        illustratedView.layoutManager = layoutManager
        illustratedView.adapter = illustratedAdapter()

        return view
    }
}