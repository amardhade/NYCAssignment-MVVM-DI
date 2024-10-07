package com.p20241004_amardhade_nycschools.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.p20241004_amardhade_nycschools.domain.ResponseWrapper
import com.p20241004_amardhade_nycschools.domain.models.School
import com.p20241004_amardhade_nycschools.domain.repos.AppRepo
import com.p20241004_amardhade_nycschools.presentation.SchoolScreenEvent.SchoolSelected
import com.p20241004_amardhade_nycschools.presentation.school.SchoolUIState
import com.p20241004_amardhade_nycschools.presentation.schools.SchoolsScreenUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(private val appRepo: AppRepo) : ViewModel() {


    private val _uiState = MutableStateFlow(SchoolsScreenUIState())
    val uiState = _uiState.asStateFlow()

    private val _selectedSchoolUIState = MutableStateFlow(SchoolUIState())
    val selectedSchoolUIState = _selectedSchoolUIState.asStateFlow()

    lateinit var selectedSchool: School
    private lateinit var schools: List<School>


    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val responseWrapper = appRepo.getSchools()
            when (responseWrapper) {
                is ResponseWrapper.Idle, ResponseWrapper.Loading -> {
                    _uiState.value = _uiState.value.copy(isLoading = true)
                }

                is ResponseWrapper.Error -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, schools = emptyList())
                    println("API Error: $responseWrapper.message")
                }

                is ResponseWrapper.Success -> {
                    schools = responseWrapper.data
                    _uiState.value =
                        _uiState.value.copy(isLoading = false, schools = responseWrapper.data)
                    println("API Success: ${responseWrapper.data.size}")
                }
            }
        }
    }


    fun onScreenEvent(schoolScreenEvent: SchoolScreenEvent) {
        when (schoolScreenEvent) {
            is SchoolSelected -> {
                viewModelScope.launch {
                    selectedSchool =
                        filterSelectedSchool(schoolScreenEvent.schoolDbn) ?: School()
                    _selectedSchoolUIState.update { schoolUiState ->
                        schoolUiState.copy(
                            schoolName = selectedSchool.schoolName ?: "",
                            sports = selectedSchool.sports ?: "",
                            opportunities1 = selectedSchool.opportunities1 ?: "",
                            opportunities2 = selectedSchool.opportunities2 ?: "",
                            location = selectedSchool.location ?: "",
                        )
                    }
                }
            }

            else -> {}
        }
    }

    private fun filterSelectedSchool(schoolDbn: String): School? {
        return schools.find { school -> school.dbn.equals(schoolDbn, false) }
    }
}