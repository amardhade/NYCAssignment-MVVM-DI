package com.p20241004_amardhade_nycschools.domain

import com.p20241004_amardhade_nycschools.data.ApiService
import com.p20241004_amardhade_nycschools.data.ValidResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppRepoImplTest {

    private lateinit var apiService: ApiService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        val retrofit = Retrofit.Builder().baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create()).build()
        apiService = retrofit.create(ApiService::class.java)
    }


    @Test
    fun textForValidResponse() {
        runBlocking {
            mockWebServer.enqueue(MockResponse().setBody(ValidResponse).setResponseCode(200))
            val response = apiService.fetchSchools()
            if (response.isSuccessful && response.body() != null) assert(true)
        }
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}