package asha.binar.challangechapter3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import asha.binar.challangechapter3.R
import asha.binar.challangechapter3.model.Word
import kotlinx.android.synthetic.main.alphabet_word.view.*

class AlphabetWordAdapter(val listWord: ArrayList<Word>):
    RecyclerView.Adapter<AlphabetWordAdapter.ViewHolder>() {

    private lateinit var listener: OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick(word: String)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }
    class ViewHolder(itemView: View, listener: OnItemClickListener, wordList: ArrayList<Word>): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener{
                listener.onItemClick(wordList[position].word)
            }
        }
        val word: TextView = itemView.findViewById<TextView>(R.id.tvWord)
        val image: ImageView = itemView.ivWord
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_word, parent, false)
        return ViewHolder(view, listener, listWord)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.word.text = listWord[position].word
        holder.image.setImageResource(listWord[position].image)
    }

    override fun getItemCount(): Int {
        return listWord.size
    }
}