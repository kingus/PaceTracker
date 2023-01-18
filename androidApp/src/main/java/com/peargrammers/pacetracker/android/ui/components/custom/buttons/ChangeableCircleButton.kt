package com.peargrammers.pacetracker.android.ui.components.custom.buttons

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.theme.IntenseOrange
import com.peargrammers.pacetracker.android.ui.theme.LightGrey

@Composable
fun ChangeableCircleButton(
    modifier: Modifier,
    onClick: () -> Unit,
    positiveStateImage: Painter,
    negativeStateImage: Painter
) {

    val state = remember {
        mutableStateOf(false)
    }

    val image = remember {
        mutableStateOf(positiveStateImage)
    }

    if (state.value) {
        image.value = negativeStateImage
    } else {
        image.value = positiveStateImage
    }

    Box(
        modifier = modifier
            .shadow(10.dp, RoundedCornerShape(50.dp))
            .size(100.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(IntenseOrange)
            .clickable {
                state.value = !state.value
                onClick()
            }
    ) {
        Image(
            painter = image.value,
            contentDescription = null,
            colorFilter = ColorFilter.tint(LightGrey),
            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .padding(16.dp)
        )
    }
}
