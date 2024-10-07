package com.p20241004_amardhade_nycschools.domain.repos

import com.p20241004_amardhade_nycschools.domain.ResponseWrapper
import com.p20241004_amardhade_nycschools.data.dtos.SchoolsDto
import com.p20241004_amardhade_nycschools.domain.models.School

interface AppRepo {

    suspend fun getSchools(): ResponseWrapper<List<School>>
}