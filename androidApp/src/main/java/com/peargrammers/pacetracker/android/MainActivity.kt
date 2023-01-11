package com.peargrammers.pacetracker.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.peargrammers.pacetracker.android.ui.screens.TrainingScreen
import com.peargrammers.pacetracker.android.ui.theme.PaceTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaceTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Column {
//                        CustomTextField("Phone number", modifier = Modifier.fillMaxWidth())
//                        RoundedIcon()
//                        InfoTextField("To jest mój tekst")
//                        InfoTextField("A to jest mój dłuższy tekst, który ma więcej wyrazów i dwie linijki ")
//                        InfoTextField("A to jest mój jeszcze dłuższy tekst, który ma jeszcze więcej wyrazów i aż trzy linijki, czyli o jedną więcej niż poprzedni")
//
                        TrainingScreen()
                    }
                }
            }
        }
    }
}
