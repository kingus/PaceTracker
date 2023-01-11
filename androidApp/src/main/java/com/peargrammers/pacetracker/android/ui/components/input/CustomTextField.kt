package com.peargrammers.pacetracker.android.ui.components.input

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.theme.LightGrey
import com.peargrammers.pacetracker.android.ui.theme.Red
import com.peargrammers.pacetracker.android.ui.theme.spacing


@Composable
fun CustomTextField(labelText: String, modifier: Modifier) {

    val textValue = remember {
        mutableStateOf("")
    }

    val colorPrimary = Red
    val lightGrey = LightGrey

    OutlinedTextField(value = textValue.value,
        modifier = modifier
            .padding(MaterialTheme.spacing.small),
        shape = RoundedCornerShape(25.dp),
        maxLines = 1,
        onValueChange = {
            textValue.value = it
        }, label = {
            Text(text = labelText)
        }, colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = colorPrimary,
            focusedBorderColor = colorPrimary,
            unfocusedBorderColor = lightGrey,
            cursorColor = colorPrimary
        ), keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )

}