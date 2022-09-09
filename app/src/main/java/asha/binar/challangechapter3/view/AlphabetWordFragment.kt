package asha.binar.challangechapter3.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import asha.binar.challangechapter3.R
import asha.binar.challangechapter3.adapter.AlphabetWordAdapter
import asha.binar.challangechapter3.data.DummyData
import asha.binar.challangechapter3.model.Word
import kotlinx.android.synthetic.main.fragment_alphabet_word.*


class AlphabetWordFragment(private val keyWord :String) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabet_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = AlphabetWordAdapter(DummyData.listWordPreview.filter {
            it.word.first().toString().uppercase() == keyWord
        } as ArrayList<Word>)
        rvAlphabetWord.layoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)
        rvAlphabetWord.adapter = adapter
        adapter.setOnItemClickListener(object : AlphabetWordAdapter.OnItemClickListener{
            override fun onItemClick(word: String) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com/search?q=$word")
                startActivity(intent)
            }
        })
    }

}