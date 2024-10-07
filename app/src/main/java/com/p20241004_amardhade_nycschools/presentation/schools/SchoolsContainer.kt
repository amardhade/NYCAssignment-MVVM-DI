package com.p20241004_amardhade_nycschools.presentation.schools

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.p20241004_amardhade_nycschools.presentation.SchoolViewModel

@Composable
fun SchoolsScreenContainer(viewModel: SchoolViewModel, onSchoolSelected: (String) -> Unit) {


    SchoolsScreen(
        uiState = viewModel.uiState.collectAsState().value,
        onEvent = viewModel::onScreenEvent,
        onSchoolSelected = onSchoolSelected
    )
}