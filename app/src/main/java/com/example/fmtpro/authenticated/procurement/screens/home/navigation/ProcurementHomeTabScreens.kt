package com.example.fmtpro.authenticated.procurement.screens.home.navigation

import com.example.fmtpro.R

sealed class ProcurementHomeTabScreens(val route:String,val icon:Int,val name:String){
    object RetailerList:ProcurementHomeTabScreens("Retailers List",R.drawable.retailers,"Retailers")
    object SampleList:ProcurementHomeTabScreens("Samples List",R.drawable.samples,"Samples")
    object OrderList:ProcurementHomeTabScreens("Orders List",R.drawable.orders,"Orders")
}