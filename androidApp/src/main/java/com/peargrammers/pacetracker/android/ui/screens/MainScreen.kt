package com.peargrammers.pacetracker.android.ui.screens

import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.peargrammers.pacetracker.android.navigation.Screen
import com.peargrammers.pacetracker.android.permissions.PermissionsValidator

@Composable
fun MainScreen(navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
    ) {
        val launcherForLocation = permissionsLauncher()
        val context = LocalContext.current

        val lifecycleOwner = LocalLifecycleOwner.current
        DisposableEffect(key1 = lifecycleOwner, effect = {
            val observer = LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_START) {
                    launcherForLocation.launch(
                        PermissionsValidator.locationPermissions().toTypedArray()
                    )
                }
                if (event == Lifecycle.Event.ON_RESUME) {
                    if (PermissionsValidator.isPermissionGranted(
                            context,
                            PermissionsValidator.locationPermissions()
                        )
                    ) {
                        navController.navigate(Screen.TrainingFormScreen.route)
                    }
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)

            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        })
    }
}

@Composable
fun permissionsLauncher(): ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>> {
    return rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { }
}