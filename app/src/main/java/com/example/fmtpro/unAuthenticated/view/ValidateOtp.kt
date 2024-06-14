package com.example.fmtpro.unAuthenticated.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValidateOTP(
    loading: Boolean,
    otp: String,
    onValueChange: (String) -> Unit,
    onClickValidateOTP:() -> Unit
)
{
    Column(
        modifier = Modifier
            .padding(horizontal = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = otp,
            onValueChange = onValueChange,
            label = { Text("Enter Otp") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            maxLines = 1,
            singleLine = true,
        )
        Button(
            onClick = onClickValidateOTP,
            shape = RoundedCornerShape(2.dp),
            enabled=!loading,
            modifier = Modifier.padding(top = 16.dp)
        ) {
                if (loading) {
                    CircularProgressIndicator()
                } else {
                    Text("Validate OTP")
                }
        }
    }
}

@Preview
@Composable
fun validateOtpComposable(){
    ValidateOTP(
        loading=false,
        otp="2345",
        onValueChange={
            println(it)
        },
        onClickValidateOTP = {}
    )
}