package com.androboy.themovies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androboy.themovies.R
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.views.holders.BaseViewHolder
import com.androboy.themovies.views.holders.MovieItemViewHolder

abstract class BaseAdapter<VH :BaseViewHolder<T> , T> : RecyclerView.Adapter<VH>() {


    protected var data : MutableList<T> = ArrayList()

    override fun getItemCount(): Int {

        return data.size

    }

    fun setNewData(movies : MutableList<T>)
    {
        this.data = movies
        notifyDataSetChanged()
    }

}