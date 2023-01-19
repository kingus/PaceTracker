package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.peargrammers.pacetracker.android.navigation.bottom.BottomBarScreen
import com.peargrammers.pacetracker.android.navigation.graphs.HomeNavGraph


@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(bottomBar = { BottomBar(navController = navController) }) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            HomeNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Profile,
        BottomBarScreen.Settings)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        Box(modifier = Modifier.fillMaxWidth()) {
            BottomNavigation(
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(0.dp, 10.dp)
                    .height(60.dp)
                    .fillMaxWidth(0.9f)
                    .graphicsLayer {
                        shape = RoundedCornerShape(
                            topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp
                        )
                        clip = true
                    }) {
                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen, currentDestination: NavDestination?, navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title, style = MaterialTheme.typography.h4)
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon), contentDescription = null
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
    )
}
