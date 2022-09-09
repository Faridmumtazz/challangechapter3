package asha.binar.challangechapter3.data

import asha.binar.challangechapter3.R
import asha.binar.challangechapter3.model.Word

class DummyData {
    companion object{
        val listAlphabet  = arrayListOf<String>(
            "A","B","C","D","E","F","G","H","I","J",
            "K","L","M","N","O","P","R","S","T","U",
            "V","W","X","Y","Z"
        )
        val word = arrayListOf<String>(
            "Anu", "Ngadan", "Kalo", "Miso", "Andar"
        )
        val listWordPreview = arrayListOf<Word>(
            Word("Anda", R.drawable.ic_launcher_background),
            Word("Misuh", R.drawable.ic_launcher_background),
            Word("Laut", R.drawable.ic_launcher_background),
            Word("Udara", R.drawable.ic_launcher_background),
            Word("Api", R.drawable.ic_launcher_background),
        )
    }
}