package com.example.fmtpro

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fmtpro.authenticated.procurement.navigation.ProcurementScreenDrawer
import com.example.fmtpro.models.loadingState.LoadingState
import com.example.fmtpro.unAuthenticated.view.Unauthenticated

@Composable
fun RootNavigation(
    modifier: Modifier = Modifier,
    viewModel: RootViewModel= hiltViewModel(),
    navController: NavHostController = rememberNavController()) {

    val isLoggedInState = viewModel.isLoggedIn.collectAsState()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = RootScreens.Unauthenticated.route
    ) {
        composable(route = RootScreens.Unauthenticated.route) {
            when (val isLoggedIn = isLoggedInState.value) {
                is LoadingState.Loading -> {
                } // Do nothing, let the splash screen show
                is LoadingState.Success -> {
                    if (isLoggedIn.data) {
                        navController.navigate(RootScreens.Authenticated.route) {
                            popUpTo(RootScreens.Unauthenticated.route) { inclusive = true }
                        }
                    } else {
                        Unauthenticated()
                    }
                }
                is LoadingState.Error -> Text("Error while initializing data") /* Handle error state */
            }
        }
        composable(route = RootScreens.Authenticated.route) {
            ProcurementScreenDrawer()
        }
    }
}

sealed class RootScreens(val route: String) {
    object Splash : RootScreens("splash")
    object Unauthenticated : RootScreens("unauthenticated")
    object Authenticated : RootScreens("authenticated")
}