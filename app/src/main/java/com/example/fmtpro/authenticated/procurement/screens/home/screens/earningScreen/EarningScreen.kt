package com.example.fmtpro.authenticated.procurement.screens.home.screens.earningScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fmtpro.components.atoms.AppBar.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EarningScreen(
    title:String,
    toggleDrawer :() -> Unit) {
    Scaffold(
        topBar = {
            AppBar(
                title = title,
                onNavigationClick = toggleDrawer
            )
        }
    ) {paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)){
            Text(text = "Earning Screen")
        }
    }
}