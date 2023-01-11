package com.peargrammers.pacetracker.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.theme.IntenseBlue
import com.peargrammers.pacetracker.android.ui.theme.IntenseOrange
import com.peargrammers.pacetracker.android.ui.theme.LightBlue
import com.peargrammers.pacetracker.android.ui.theme.LightOrange

@Composable
@Preview

fun RoundedIcon() {
    Row() {
        RoundImage(
            image = painterResource(R.drawable.ic_speed),
            modifier = Modifier.size(60.dp),
            LightOrange,
            IntenseOrange
        )

        RoundImage(
            image = painterResource(R.drawable.ic_walk),
            modifier = Modifier.size(60.dp),
            LightBlue,
            IntenseBlue
        )
    }
}


@Composable
fun RoundImage(
    image: Painter, modifier: Modifier = Modifier, backgroundColor: Color, iconColor: Color
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(50.dp))
            .background(backgroundColor)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            colorFilter = ColorFilter.tint(iconColor),
            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .padding(16.dp)
                .clip(CircleShape)
        )
    }
}
