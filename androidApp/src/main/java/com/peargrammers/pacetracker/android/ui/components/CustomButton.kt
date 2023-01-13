package com.peargrammers.pacetracker.android.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.theme.IntenseOrange
import com.peargrammers.pacetracker.android.ui.theme.spacing

@Composable
fun CustomButton(onClick: () -> Unit, label: String = "Click me") {
    Button(
        onClick = onClick, modifier =
        Modifier
            .width(350.dp)
            .height(70.dp)
            .padding(MaterialTheme.spacing.small),
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = IntenseOrange)

    ) {
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
