package com.peargrammers.pacetracker.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.theme.LightGrey
import com.peargrammers.pacetracker.android.ui.theme.spacing

@Composable
fun InfoTextField(
    infoText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(LightGrey)
            .wrapContentHeight(CenterVertically)
            .padding(MaterialTheme.spacing.small),
        verticalAlignment = CenterVertically,

        ) {
        Image(
            painter = painterResource(id = R.drawable.ic_info),
            "Info", modifier = Modifier.padding(MaterialTheme.spacing.small)
        )
        Text(text = infoText)
    }

}