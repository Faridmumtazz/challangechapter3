package asha.binar.challangechapter3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import asha.binar.challangechapter3.R.id.rvList
import kotlinx.android.synthetic.main.fragment_first_list.*


class FirstListFragment : Fragment() {

    private lateinit var adapter: AdapterDataFirst
    private lateinit var recyclerVIew: RecyclerView
    private lateinit var abjadArrayList: ArrayList<MyData>

    lateinit var abjad : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerVIew = view.findViewById(R.id.rvList)
        recyclerVIew.layoutManager = layoutManager
        recyclerVIew.setHasFixedSize(true)
        adapter = AdapterDataFirst(abjadArrayList)
        recyclerVIew.adapter = adapter
    }

    private fun dataInitialize(){

        abjadArrayList = arrayListOf<MyData>()

        abjad = arrayOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",

        )

        for( i in abjad.indices){
            val data = MyData(abjad[i])
            abjadArrayList.add(data)
        }
    }

}