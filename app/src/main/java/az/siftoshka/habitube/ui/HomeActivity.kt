package az.siftoshka.habitube.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import az.siftoshka.habitube.R
import az.siftoshka.habitube.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * TODO add class description
 */
@AndroidEntryPoint
class HomeActivity: AppCompatActivity(R.layout.activity_main) {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)
    }

}