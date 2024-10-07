package com.p20241004_amardhade_nycschools

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.p20241004_amardhade_nycschools.presentation.SchoolViewModel
import com.p20241004_amardhade_nycschools.presentation.school.SchoolDetails
import com.p20241004_amardhade_nycschools.presentation.schools.SchoolsScreenContainer
import com.p20241004_amardhade_nycschools.utils.Routes.Companion.SchoolDetails
import com.p20241004_amardhade_nycschools.utils.Routes.Companion.Schools

@Composable
fun NavigationManager(
    navController: NavHostController,
    viewModel: SchoolViewModel = hiltViewModel() as SchoolViewModel
) {

    NavHost(navController = navController, startDestination = Schools) {

        composable(Schools) {
            SchoolsScreenContainer(
                viewModel = viewModel,
                onSchoolSelected = { dbn ->
                    navController.navigate("$SchoolDetails/$dbn")
//                navController.navigate(SchoolDetails)
                })
        }

        composable("$SchoolDetails/{dbn}") { navBackStackEntry ->
            /* Extracting the id from the route */
            val dbn = navBackStackEntry.arguments?.getString("dbn")
            dbn?.let { dbn ->
                SchoolDetails(schoolDbn = dbn, viewModel = viewModel)
            }
        }

//        composable(route = SchoolDetails) {
//            SchoolDetails(selectedSchoolState = viewModel.selectedSchoolUIState.collectAsState().value)
//        }


    }

}