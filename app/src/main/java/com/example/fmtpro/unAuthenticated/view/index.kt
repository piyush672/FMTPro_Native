package com.example.fmtpro.unAuthenticated.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fmtpro.R
import com.example.fmtpro.unAuthenticated.unauthenticatedViewmodel.UnauthenticatedViewmodel

@Composable
fun Unauthenticated(
    viewModel: UnauthenticatedViewmodel = hiltViewModel()
){
    return Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)){

           Image(
               painter = painterResource(id = R.drawable.loginimage),
               contentDescription = "Login Image",
               modifier = Modifier
                   .weight(1f)
                   .fillMaxWidth()
           )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            if(viewModel.isValidated.value){
                ValidateOTP(
                    otp = viewModel.otp.value,
                    onValueChange = viewModel::onChangeOTP,
                    loading = viewModel.isLoading.value,
                    onClickValidateOTP=viewModel::validateOtp
                )
            }else{
                GetOtp(
                    mobile = viewModel.mobile.value,
                    onChangeMobile = viewModel::onChangeMobile,
                    loading = viewModel.isLoading.value,
                    onClickGetOTP = viewModel::onGetOtp
                )
            }
        }
    }
}

