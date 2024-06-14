package com.example.fmtpro.authenticated.procurement.screens.home.screens.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fmtpro.authenticated.procurement.screens.home.navigation.BottomNavigationBar
import com.example.fmtpro.authenticated.procurement.screens.home.navigation.ProcurementHomeTabScreens
import com.example.fmtpro.authenticated.procurement.screens.home.screens.orderListScreen.OrderListScreen
import com.example.fmtpro.authenticated.procurement.screens.home.screens.retailerListScreen.RetailerListScreen
import com.example.fmtpro.authenticated.procurement.screens.home.screens.sampleListScreen.SampleListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(toggleDrawer: () -> Unit) {
    val navController = rememberNavController()
   Scaffold(
       bottomBar = {
           BottomAppBar(modifier = Modifier) {
               BottomNavigationBar(navController = navController)
           }
       }
   ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            NavHost(
                navController = navController,
                startDestination = ProcurementHomeTabScreens.RetailerList.route
            ){
                composable(ProcurementHomeTabScreens.RetailerList.route){
                    RetailerListScreen(ProcurementHomeTabScreens.RetailerList.route,toggleDrawer)
                }
                composable(ProcurementHomeTabScreens.SampleList.route){
                    SampleListScreen()
                }
                composable(ProcurementHomeTabScreens.OrderList.route){
                    OrderListScreen()
                }
            }
        }
   }
}
