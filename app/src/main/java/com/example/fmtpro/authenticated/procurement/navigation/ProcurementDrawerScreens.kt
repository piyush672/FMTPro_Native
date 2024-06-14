package com.example.fmtpro.authenticated.procurement.navigation

import com.example.fmtpro.R

sealed class ProcurementDrawerScreens (val route: String,val icon:Int){
    object HomeScreen : ProcurementDrawerScreens("Home",R.drawable.home)
    object EarningScreen : ProcurementDrawerScreens("Earning",R.drawable.rupeenew)
}