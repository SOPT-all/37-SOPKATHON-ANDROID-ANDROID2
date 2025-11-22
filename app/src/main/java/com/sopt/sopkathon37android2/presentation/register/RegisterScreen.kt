package com.sopt.sopkathon37android2.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.register.component.BodyTextField
import com.sopt.sopkathon37android2.presentation.register.component.DateRangePickerField
import com.sopt.sopkathon37android2.presentation.register.component.ImagePickerRow
import com.sopt.sopkathon37android2.presentation.register.component.RegisterButton
import com.sopt.sopkathon37android2.presentation.register.component.SelectableChipRow
import com.sopt.sopkathon37android2.presentation.register.component.TextFieldSemiTitle
import com.sopt.sopkathon37android2.presentation.register.component.TextFieldTitle
import com.sopt.sopkathon37android2.presentation.register.component.TitleTextField
import com.sopt.sopkathon37android2.presentation.register.component.TopBar

@Composable
fun RegisterRoute(
    paddingValues: PaddingValues,
    onNavigateToHome: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel(),
) {

    RegisterScreen(
        paddingValues = paddingValues,
        onNavigateToHome = onNavigateToHome,
    )
}

@Composable
private fun RegisterScreen(
    paddingValues: PaddingValues,
    onNavigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedIndex by remember { mutableIntStateOf(-1) }
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(SopkathonTheme.colors.gray01)
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        TopBar(
            title = "안건 등록하기",
            onBackClick = {}
        )

        Spacer(Modifier.height(10.dp))

        TextFieldTitle(
            text = "제목"
        )

        Spacer(Modifier.height(8.dp))

        TitleTextField(
            value = title,
            onValueChange = { title = it },
            placeholder = "제목을 입력하세요"
        )

        Spacer(Modifier.height(32.dp))

        TextFieldTitle(
            text = "안건 설명"
        )

        Spacer(Modifier.height(8.dp))

        BodyTextField(
            value = body,
            onValueChange = { body = it },
            placeholder = "안건에 대해 설명해주세요\n" +
                    "투표 대상 : 투표에 참여할 수 있는 대상을 입력해주세요\n" +
                    "한줄 요약: 안건에 대해 한 줄로 요약해주세요\n" +
                    "상세 설명: 안건에 대해 상세히 설명해주세요 (제의 배경, 안건 내용, 근거 등)"
        )

        Spacer(Modifier.height(8.dp))

        ImagePickerRow()

        Spacer(Modifier.height(32.dp))

        TextFieldTitle(
            text = "투표 대상"
        )

        Spacer(Modifier.height(8.dp))

        SelectableChipRow(
            chips = listOf("학교 전체", "단과대", "학과"),
            selectedIndex = selectedIndex,
            onSelect = { index -> selectedIndex = index }
        )

        Spacer(Modifier.height(32.dp))

        TextFieldTitle(
            text = "추천 기간"
        )
        TextFieldSemiTitle(
            text = "투표 기간은 등록일로부터 3주입니다"
        )

        Spacer(Modifier.height(8.dp))

        DateRangePickerField()

        Spacer(Modifier.weight(1f))

        RegisterButton(
            text = "안건 등록하기",
            enabled = title.isNotBlank()
                    && body.isNotBlank()
                    && selectedIndex != -1,
            onClick = {}
        )
    }
}


@Preview(
    showBackground = true,
)
@Composable
private fun HomeScreenPreview() {
    SopkathonTheme() {
        RegisterScreen(
            paddingValues = PaddingValues(),
            onNavigateToHome = {}
        )
    }
}
