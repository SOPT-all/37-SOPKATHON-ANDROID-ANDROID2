package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun TitleTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    modifier: Modifier = Modifier
) {
    val isFocused = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .border(1.dp, SopkathonTheme.colors.gray02, RoundedCornerShape(4.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .onFocusChanged { isFocused.value = it.isFocused },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
            focusManager.clearFocus()
        }),
        decorationBox = { innerTextField ->
            if (value.isEmpty() && !isFocused.value) {
                Text(
                    text = placeholder,
                    style= SopkathonTheme.typography.body.m_13,
                    color = SopkathonTheme.colors.gray03
                )
            }
            innerTextField()
        }
    )
}

@Composable
fun BodyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    modifier: Modifier = Modifier
) {
    val isFocused = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 130.dp, max = 300.dp) 
            .clip(RoundedCornerShape(4.dp))
            .border(1.dp, SopkathonTheme.colors.gray02, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .onFocusChanged { isFocused.value = it.isFocused },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Default
            ),
            decorationBox = { innerTextField ->
                if (value.isEmpty() && !isFocused.value) {
                    Text(
                        text = placeholder,
                        style = SopkathonTheme.typography.body.m_13,
                        color = SopkathonTheme.colors.gray03
                    )
                }
                innerTextField()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        TitleTextField(
            value = "",
            onValueChange = {},
            placeholder = "제목을 입력해주세요."
        )

        Column(modifier = Modifier.height(20.dp)) {}

        BodyTextField(
            value = "",
            onValueChange = {},
            placeholder = "안건에 대해 설명해주세요\n" +
                    "투표 대상 : 투표에 참여할 수 있는 대상을 입력해주세요\n" +
                    "한줄 요약: 안건에 대해 한 줄로 요약해주세요\n" +
                    "상세 설명: 안건에 대해 상세히 설명해주세요 (제의 배경, 안건 내용, 근거 등)"
        )
    }
}