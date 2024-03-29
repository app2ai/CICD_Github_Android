package com.example.jetsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetsample.scenes.BasicForm
import com.example.jetsample.ui.theme.JetSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetSampleTheme {
                // A surface container using the 'background' color from the theme
                val modifier = Modifier
                Surface(
                    modifier = modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicForm(modifier)
                }
            }
        }
    }
}
