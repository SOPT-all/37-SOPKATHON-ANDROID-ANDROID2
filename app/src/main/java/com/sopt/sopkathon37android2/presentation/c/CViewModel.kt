package com.sopt.sopkathon37android2.presentation.c

import androidx.lifecycle.ViewModel
import com.sopt.sopkathon37android2.data.service.DummyService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CViewModel @Inject constructor(
    private val dummyService: DummyService
) : ViewModel() {

}
