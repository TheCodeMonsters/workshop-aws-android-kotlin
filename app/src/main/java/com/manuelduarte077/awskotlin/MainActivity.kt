package com.manuelduarte077.awskotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.manuelduarte077.awskotlin.navigation.Navigation
import com.manuelduarte077.awskotlin.ui.theme.AwsKotlinTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      rememberSystemUiController().setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = !isSystemInDarkTheme()
      )
      AwsKotlinTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          Navigation()
        }
      }
    }
  }

}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  AwsKotlinTheme {
    Greeting("Android")
  }
}