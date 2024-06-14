package com.example.fmtpro.components.atoms.AppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onNavigationClick: () -> Unit,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = Color.White,
){
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Open drawer"
                )
            }
        },
        title = { Text(title) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = backgroundColor,
            scrolledContainerColor = backgroundColor,
            navigationIconContentColor = contentColor,
            titleContentColor = contentColor
        ),
    )
}