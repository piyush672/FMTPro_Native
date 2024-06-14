package com.example.fmtpro.authenticated.procurement.screens.home.screens.retailerListScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fmtpro.components.atoms.AppBar.AppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RetailerListScreen(
    headerTitle:String,
    toggleDrawer : () -> Unit){
    Scaffold(
        topBar = {
            AppBar(
                title = headerTitle,
                onNavigationClick = toggleDrawer
            )
        }
    ) { innerPadding ->
        Box (modifier = Modifier.padding(innerPadding)){
            Text(text = "Retailer List")
        }
    }
}