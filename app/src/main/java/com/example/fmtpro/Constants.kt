package com.example.fmtpro

import android.content.Context
import com.example.fmtpro.BuildConfig

object ApiUrlProvider {
    fun getApiBaseUrl(context: Context): String {
        val apiBaseUrlResId = getApiBaseUrlResId(context)
        return context.resources.getString(apiBaseUrlResId)
    }

    private fun getApiBaseUrlResId(context: Context): Int {
        // Check active flavor
        return when (BuildConfig.FLAVOR) {
            "dev" -> R.string.api_base_url_dev
            "stage" -> R.string.api_base_url_stage
            else -> R.string.api_base_url_prod
        }
    }
}
