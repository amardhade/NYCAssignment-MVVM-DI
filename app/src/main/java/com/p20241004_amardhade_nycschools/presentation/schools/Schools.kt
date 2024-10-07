package com.p20241004_amardhade_nycschools.presentation.schools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.p20241004_amardhade_nycschools.presentation.SchoolScreenEvent

@Composable
fun SchoolsScreen(
    uiState: SchoolsScreenUIState,
    onEvent: (SchoolScreenEvent) -> Unit,
    onSchoolSelected: (String) -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(40.dp)
            )
        } else {
            LazyColumn {
                items(
                    items = uiState.schools,
                    key = { school -> school.dbn!! },
                ) { school ->
                    SchoolItem(school = school, onSchoolSelected = {
                        println("Selected School dbn: $it")
                        onEvent(SchoolScreenEvent.SchoolSelected(it))
                        onSchoolSelected(it)
                    })
                }
            }


        }
    }
}