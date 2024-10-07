package com.p20241004_amardhade_nycschools.presentation.schools

import com.p20241004_amardhade_nycschools.domain.models.School

data class SchoolsScreenUIState(

    val schools: List<School> = emptyList(),
    val isLoading: Boolean = false
)
