package com.nikita.kut.android.sfera_test_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nikita.kut.android.sfera_test_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.mainFragmentContainer.id, MainFragment())
                .commit()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}