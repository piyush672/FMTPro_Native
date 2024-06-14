package com.example.fmtpro.authenticated.procurement.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fmtpro.R
import com.example.fmtpro.authenticated.procurement.screens.home.screens.homeScreen.HomeScreen
import com.example.fmtpro.authenticated.procurement.screens.home.screens.earningScreen.EarningScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProcurementScreenDrawer (){
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()

    val items= listOf(
        ProcurementDrawerScreens.HomeScreen,
        ProcurementDrawerScreens.EarningScreen
    )

    val selectedItem = remember {
        mutableStateOf(items[0].route)
    }

    fun toggleDrawer(){
        scope.launch {
            if (drawerState.isClosed) drawerState.open() else drawerState.close()
        }
    }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.drawerlogo), contentDescription = "Drawer Logo" )
                }
                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(painterResource(id = item.icon), contentDescription = null) },
                        label = { Text(item.route) },
                        selected = item.route == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item.route
                            navController.navigate(item.route)
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        shape = RoundedCornerShape(4.dp)
                    )
                }
                Button(
                    onClick = {
                        // Handle button click action
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .align(Alignment.End)
                        .padding(bottom = 10.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Logout")
                }
            }
        },
        drawerState = drawerState
    ) {
        NavHost(
            navController = navController,
            startDestination = ProcurementDrawerScreens.HomeScreen.route
        ){
            composable(ProcurementDrawerScreens.HomeScreen.route){
                HomeScreen(::toggleDrawer)
            }
            composable(ProcurementDrawerScreens.EarningScreen.route){
                EarningScreen(ProcurementDrawerScreens.EarningScreen.route,::toggleDrawer)
            }
        }
    }
}