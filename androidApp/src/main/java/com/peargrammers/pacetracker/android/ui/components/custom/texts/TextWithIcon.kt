package com.peargrammers.pacetracker.android.ui.components.custom.texts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.theme.IntenseOrange
import com.peargrammers.pacetracker.android.ui.theme.spacing

@Composable
fun TextWithIcon(label: String, icon: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            "Info",
            modifier = Modifier
                .padding(MaterialTheme.spacing.small)
                .size(16.dp),
            colorFilter = ColorFilter.tint(IntenseOrange)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.align(CenterVertically),
            color = IntenseOrange
        )
    }
}