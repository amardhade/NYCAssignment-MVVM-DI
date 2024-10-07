package com.p20241004_amardhade_nycschools.data

import com.p20241004_amardhade_nycschools.data.dtos.SchoolsDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("resource/s3k6-pzi2.json")
    suspend fun fetchSchools(): Response<SchoolsDto>
}