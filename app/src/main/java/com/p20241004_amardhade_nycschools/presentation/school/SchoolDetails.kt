package com.p20241004_amardhade_nycschools.presentation.school

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.p20241004_amardhade_nycschools.domain.models.School
import com.p20241004_amardhade_nycschools.presentation.SchoolViewModel

@Composable
fun SchoolDetails(
    schoolDbn: String, viewModel: SchoolViewModel
) {


    val selectedSchoolState = viewModel.selectedSchoolUIState.collectAsState()
    println("Selected School: ${selectedSchoolState.value.schoolName}")

    Text(text = selectedSchoolState.value.schoolName)


}