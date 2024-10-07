package com.p20241004_amardhade_nycschools.domain

import com.p20241004_amardhade_nycschools.domain.models.School
import com.p20241004_amardhade_nycschools.domain.repos.AppRepo

class FakeAppRepoImpl : AppRepo {
    override suspend fun getSchools(): ResponseWrapper<List<School>> {
        return ResponseWrapper.Success(listOf(School(schoolName = "Fake School")))
    }


}