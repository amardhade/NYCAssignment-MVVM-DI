package com.p20241004_amardhade_nycschools.domain.models

data class School(
    val dbn: String? = "",
    val schoolName: String? = "",
    val phone: String? = "",
    val email: String? = "",
    val city: String? = "",
    val sports: String? = "",
    val opportunities1: String? = "",
    val opportunities2: String? = "",
    val location: String? = "",
    val website: String? = ""
)
