package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    placeholder: String = "",
    onFocusChanged: ((Boolean) -> Unit)? = null
){
    val scrollState = rememberScrollState()
    val focusState = remember { mutableStateOf(false) }
    val textFieldRequester = remember { BringIntoViewRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val lastLineBottom = remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(12.dp))
            .bringIntoViewRequester(textFieldRequester)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxSize()
                .height(275.dp)
                .verticalScroll(scrollState)
                .onFocusChanged { focusStateChanged ->
                    focusState.value = focusStateChanged.isFocused
                    onFocusChanged?.invoke(focusStateChanged.isFocused)
                },
            enabled = isEnabled,
//        textStyle = ByeBooTheme.typography.body3.copy(
//            color = ByeBooTheme.colors.white
//        ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            // cursorBrush = SolidColor(ByeBooTheme.colors.white),
            decorationBox = { innerTextField ->
                if (value.isEmpty() && !(focusState.value)) {
                    Text(
                        text = placeholder,
//                    color = ByeBooTheme.colors.gray300,
//                    style = ByeBooTheme.typography.body3
                    )
                }
                innerTextField()
            },
            onTextLayout = { layoutResult ->
                lastLineBottom.value =
                    layoutResult.getLineBottom(layoutResult.lineCount - 1).toInt()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldPreview() {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = "텍스트를 입력해주세요."
    )
}
