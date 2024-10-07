package com.p20241004_amardhade_nycschools.presentation

import androidx.hilt.navigation.compose.hiltViewModel
import com.p20241004_amardhade_nycschools.data.repos.AppRepoImpl
import com.p20241004_amardhade_nycschools.domain.FakeAppRepoImpl
import com.p20241004_amardhade_nycschools.domain.repos.AppRepo
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SchoolViewModelTest {

    private lateinit var viewModel: SchoolViewModel
    private lateinit var appRepo: AppRepo

    @Before
    fun setUp() {
        appRepo = FakeAppRepoImpl()
        viewModel = SchoolViewModel(appRepo)
    }

    @Test
    fun testFetchSchools() {
        runBlocking {
        }

    }

}