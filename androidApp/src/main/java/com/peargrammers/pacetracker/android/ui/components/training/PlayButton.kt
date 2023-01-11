package com.peargrammers.pacetracker.android.ui.components.training

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.theme.LightGrey
import com.peargrammers.pacetracker.android.ui.theme.Red

@Composable
fun PlayButton(modifier: Modifier) {

    val state = remember {
        mutableStateOf(false)
    }

    val image = remember {
        mutableStateOf(R.drawable.ic_play_arrow)
    }

    if (state.value) {
        image.value = R.drawable.ic_stop
    } else {
        image.value = R.drawable.ic_play_arrow
    }

    Box(
        modifier = modifier
            .shadow(10.dp, RoundedCornerShape(50.dp))
            .size(100.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(Red)
            .clickable {
                state.value = !state.value
            }
    ) {
        Image(
            painter = painterResource(image.value),
            contentDescription = null,
            colorFilter = ColorFilter.tint(LightGrey),
            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .padding(16.dp)

        )
    }
}
