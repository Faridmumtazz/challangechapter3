package asha.binar.challangechapter3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import asha.binar.challangechapter3.R
import asha.binar.challangechapter3.data.DummyData
import asha.binar.challangechapter3.model.Word
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_add_word_bottom_sheet.*


class AddWordBottomSheetFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_word_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnAddWord.setOnClickListener{
            val word = etAddWord.text.toString()
            if(word.isNotBlank()){
                DummyData.listWordPreview.add(Word(word,R.drawable.ic_launcher_background))
                dismiss()
                Toast.makeText(context,"Word Added", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Invalid Input", Toast.LENGTH_SHORT).show()
            }
        }

    }

}