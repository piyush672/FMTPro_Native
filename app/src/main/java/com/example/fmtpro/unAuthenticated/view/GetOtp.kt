package com.example.fmtpro.unAuthenticated.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetOtp(
    onChangeMobile:(value:String)->Unit,
    mobile:String,
    loading:Boolean,
    onClickGetOTP:()->Unit
){

    Column(
        modifier = Modifier
            .padding(horizontal = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = mobile,
            onValueChange = onChangeMobile,
            label = { Text("Enter Mobile number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            maxLines = 1,
            singleLine = true
        )
        Button(
            onClick = onClickGetOTP ,
            enabled=!loading,
            shape = RoundedCornerShape(2.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            if (loading) {
                CircularProgressIndicator()
            } else {
                Text("Get OTP")
            }
        }
    }
}

@Preview
@Composable
fun GetOtpPreview(){
    GetOtp(onChangeMobile = {}, mobile = "", loading = false, onClickGetOTP = {})
}