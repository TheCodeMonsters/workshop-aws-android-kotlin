package com.manuelduarte077.awskotlin.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextClick(text: String, onClick: () -> Unit) {
  Text(
    text = text,
    modifier = Modifier.clickable(
      onClick = {
        onClick()
      }
    )
  )
}