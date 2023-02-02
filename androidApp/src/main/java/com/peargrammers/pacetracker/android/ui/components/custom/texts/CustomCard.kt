package com.peargrammers.pacetracker.android.ui.components.custom.texts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.theme.spacing

@Composable
fun CustomCard(onClickItem: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(MaterialTheme.spacing.small)
            .clickable {
                onClickItem()
            },
        shape = RoundedCornerShape(MaterialTheme.spacing.medium),
        backgroundColor = Color.White,
        elevation = 1.dp,
    ) {

    }
}