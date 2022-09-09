package asha.binar.challangechapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import asha.binar.challangechapter3.view.AlphabetFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(frContainer.id, AlphabetFragment())
            commit()
        }
    }


}