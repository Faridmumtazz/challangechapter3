package asha.binar.challangechapter3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import asha.binar.challangechapter3.R
import asha.binar.challangechapter3.adapter.AlphabetListAdapter
import asha.binar.challangechapter3.data.DummyData
import kotlinx.android.synthetic.main.fragment_alphabet.*


class AlphabetFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabAddWord.setOnClickListener{
            val addWordBottomSheetFragment = AddWordBottomSheetFragment()
            addWordBottomSheetFragment.show(parentFragmentManager.beginTransaction(),addWordBottomSheetFragment.tag)
        }

        val alphabetListAdapter = AlphabetListAdapter(DummyData.listAlphabet)
        rvAlphabetList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvAlphabetList.adapter = alphabetListAdapter
        alphabetListAdapter.setOnItemClickListener(object : AlphabetListAdapter.onItemClickListener{
            override fun onItemClick(word: String) {
                loadFragment(AlphabetWordFragment(word))
            }
        })
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.frContainer, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}