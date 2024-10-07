package com.p20241004_amardhade_nycschools.presentation

sealed class SchoolScreenEvent {

    data class SchoolSelected(val schoolDbn: String): SchoolScreenEvent()
}