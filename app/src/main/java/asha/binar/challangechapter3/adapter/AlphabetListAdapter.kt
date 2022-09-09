package asha.binar.challangechapter3.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.alphabet_list.*

import androidx.recyclerview.widget.RecyclerView
import asha.binar.challangechapter3.R
import asha.binar.challangechapter3.data.DummyData
import asha.binar.challangechapter3.model.Word
import kotlinx.android.synthetic.main.alphabet_list.view.*

class AlphabetListAdapter (private val listAlphabet: ArrayList<String>) :
    RecyclerView.Adapter<AlphabetListAdapter.ViewHolder>(){

    private lateinit var listener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(word: String)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        this.listener = listener
    }

    class ViewHolder(itemView: View, listener: onItemClickListener, listAlphabet: ArrayList<String>): RecyclerView.ViewHolder(itemView) {
        val character: TextView = itemView.tvChar
        val wordPreview = itemView.rvWordPreview



        fun bind(wordPreviewList: ArrayList<Word>){
            val wordPreviewAdapter = AlphabetWordPreviewAdapter(wordPreviewList)
            wordPreview.layoutManager = LinearLayoutManager(itemView.context,
                LinearLayoutManager.HORIZONTAL,false)
            wordPreview.adapter = wordPreviewAdapter
            wordPreviewAdapter.setOnClickListener(object : AlphabetWordPreviewAdapter.OnItemClickListener{
                override fun onItemClick(word: String) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setData(Uri.parse("https://www.google.com/search?q=$word"))
                    itemView.context.startActivity(intent)
                }
            })
        }

        init {
            itemView.tvViewAll.setOnClickListener{
                listener.onItemClick(listAlphabet[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_list, parent, false)
        return ViewHolder(view, listener, listAlphabet)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.character.text = listAlphabet[position]
        holder.bind(DummyData.listWordPreview)
    }

    override fun getItemCount(): Int = listAlphabet.size
}
