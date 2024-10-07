package com.p20241004_amardhade_nycschools.presentation.school

data class SchoolUIState(
    val schoolName: String = "",
    val sports: String? = "",
    val opportunities1: String? = "",
    val opportunities2: String? = "",
    val location: String? = "",
    val website: String? = ""
)