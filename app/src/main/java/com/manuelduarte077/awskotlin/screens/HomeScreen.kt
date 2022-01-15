package com.manuelduarte077.awskotlin.screens

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.manuelduarte077.awskotlin.R
import com.manuelduarte077.awskotlin.components.buttons.BottomBarApp
import com.manuelduarte077.awskotlin.components.buttons.TopBarApp
import com.manuelduarte077.awskotlin.fragment.ProfileFragment
import com.manuelduarte077.awskotlin.fragment.UserFragment

@Composable
fun HomeScreen(naveController: NavController) {
  val navItems = Section.values().toList()
  val section = remember { mutableStateOf(Section.Users) }
  val currentTheme = isSystemInDarkTheme()

  val toggleTheme: () -> Unit = {
    if (currentTheme) setDayTheme() else setDarkTheme()
  }
  Scaffold(
    backgroundColor = MaterialTheme.colors.background,
    modifier = Modifier.padding(15.dp),
    topBar = {
      Crossfade(targetState = section.value) { section ->
        when (section) {
          Section.Users ->
            TopBarApp(
              "Usuarios",
              "Listado de Usuarios",
              R.drawable.ic_baseline_highlight_24,
              onIconClick = { toggleTheme() })
          Section.Profile ->
            TopBarApp(
              "Perfil",
              "Datos personales",
              R.drawable.ic_baseline_logout_24,
              onIconClick = {})
        }
      }
    },

    bottomBar = {
      BottomBarApp(
        items = navItems,
        currentSection = section.value,
        onSectionSelected = { section.value = it }
      )

    }) { innerPadding ->
    Crossfade(
      modifier = Modifier.padding(innerPadding),
      targetState = section.value
    ) { section ->
      when (section) {
        Section.Users -> UserFragment(naveController)
        Section.Profile -> ProfileFragment(naveController)
      }
    }

  }

}

private fun setDayTheme() {
  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
}

private fun setDarkTheme() {
  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

}

enum class Section(val icon: Int) {
  Users(R.drawable.ic_baseline_home_24),
  Profile(R.drawable.ic_baseline_person_24)
}
