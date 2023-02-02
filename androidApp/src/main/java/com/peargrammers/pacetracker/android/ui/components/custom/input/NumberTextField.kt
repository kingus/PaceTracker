package com.peargrammers.pacetracker.android.ui.components.custom.input

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.theme.*


@Composable
fun NumberTextField(value: String, unit: String) {

    val textValue = remember {
        mutableStateOf(value)
    }

    val colorPrimary = IntenseOrange

    OutlinedTextField(
        value = textValue.value,
        modifier = Modifier
            .width(90.dp)
            .height(60.dp)
            .padding(MaterialTheme.spacing.extraSmall),
        shape = RoundedCornerShape(25.dp),
        maxLines = 1,
        leadingIcon = {
            Text(
                text = unit,
                style = MaterialTheme.typography.body1,
                color = Color.White,
                modifier = Modifier.padding(start = 2.dp, end = 2.dp),

                )
        },
        onValueChange = {
            textValue.value = it
        }, colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            cursorColor = colorPrimary,
            backgroundColor = IntenseOrange,
            textColor = Color.White
        ), keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )

}