package com.peargrammers.pacetracker.android.ui.components.custom.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun CircleButton(
    onClick: () -> Unit, modifier: Modifier = Modifier, image: Painter
) {
    Button(
        onClick = onClick, modifier = modifier
            .shadow(10.dp, RoundedCornerShape(100.dp))
            .clip(RoundedCornerShape(100.dp))
    ) {
        Image(
            painter = image,
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
        )
    }
}