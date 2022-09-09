package asha.binar.challangechapter3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import asha.binar.challangechapter3.R.layout.item_list
import kotlinx.android.synthetic.main.item_list.view.*


class AdapterDataFirst(private val lisData : ArrayList<MyData>): RecyclerView.Adapter<AdapterDataFirst.ViewHolder>(){
    class ViewHolder (itemVIew: View): RecyclerView.ViewHolder(itemVIew){
        val abjad : TextView = itemVIew.findViewById(R.id.btn_abjad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(item_list, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = lisData[position]
        holder.abjad.text = currentItem.alphabet
    }

    override fun getItemCount(): Int {
        return lisData.size
    }

}