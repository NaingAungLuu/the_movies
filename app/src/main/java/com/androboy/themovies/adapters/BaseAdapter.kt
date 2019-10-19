package com.androboy.themovies.adapters

import androidx.recyclerview.widget.RecyclerView
import com.androboy.themovies.views.holders.BaseViewHolder

abstract class BaseAdapter<VH :BaseViewHolder<T> , T> : RecyclerView.Adapter<VH>() {


    protected var data : MutableList<T> = ArrayList()

    override fun getItemCount(): Int {

        return data.size

    }

    fun setNewData(movies : MutableList<T>)
    {
        this.data = movies
        println("Setting new data for similar movies")
        notifyDataSetChanged()
    }

}