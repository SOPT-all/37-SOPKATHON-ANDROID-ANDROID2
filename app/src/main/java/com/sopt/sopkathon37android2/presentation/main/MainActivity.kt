package com.sopt.sopkathon37android2.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.sopkathon37android2.ui.theme._37SOPKATHONANDROIDANDROID2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _37SOPKATHONANDROIDANDROID2Theme {
                MainScreen()
            }
        }
    }
}
