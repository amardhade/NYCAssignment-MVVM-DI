package com.p20241004_amardhade_nycschools.data.repos

import com.p20241004_amardhade_nycschools.data.ApiService
import com.p20241004_amardhade_nycschools.data.dtos.SchoolDto
import com.p20241004_amardhade_nycschools.data.dtos.SchoolsDto
import com.p20241004_amardhade_nycschools.domain.ResponseWrapper
import com.p20241004_amardhade_nycschools.domain.models.School
import com.p20241004_amardhade_nycschools.domain.repos.AppRepo
import javax.inject.Inject

class AppRepoImpl @Inject constructor(private val apiService: ApiService) : AppRepo {

    override suspend fun getSchools(): ResponseWrapper<List<School>> {

        var responseWrapper: ResponseWrapper<List<School>> = ResponseWrapper.Idle
        try {
            val response = apiService.fetchSchools()
            if (response.isSuccessful && response.body() != null) {
                val schools: List<School> = response.body()?.toSchools() ?: emptyList()
                responseWrapper = ResponseWrapper.Success(schools)
            } else {
                responseWrapper = ResponseWrapper.Error("No schools found")
            }
        } catch (e: Exception) {
            responseWrapper = ResponseWrapper.Error("Something went wrong. ${e.message}")
        }
        return responseWrapper
    }

    // mapper functions to convert DTO Classes to Models
    private fun SchoolsDto.toSchools(): List<School> {
        val listOfSchool: MutableList<School> = mutableListOf()
        this.forEach { it ->
            listOfSchool.add(it.toSchool())
        }
        return listOfSchool
    }

    private fun SchoolDto.toSchool(): School {
        return School(
            dbn = this.dbn ?: "",
            schoolName = this.school_name,
            phone = this.phone_number,
            email = this.school_email,
            city = this.city,
            sports = this.school_sports,
            opportunities1 = this.academicopportunities1,
            opportunities2 = this.academicopportunities2,
            location = this.location,
            website = this.website
        )
    }
}