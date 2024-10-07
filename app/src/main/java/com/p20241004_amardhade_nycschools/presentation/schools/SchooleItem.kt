package com.p20241004_amardhade_nycschools.presentation.schools

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.p20241004_amardhade_nycschools.domain.models.School

@Composable
fun SchoolItem(
    school: School,
    onSchoolSelected: (id: String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSchoolSelected(school.dbn!!) },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = school.schoolName ?: "N/A", fontSize = 18.sp)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(10.dp)
        )
        Text(text = "Email: ${school.email} , Phone: ${school.phone}", fontSize = 18.sp)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(10.dp)
        )
        Text(text = school.city ?: "N/A", fontSize = 18.sp)

    }

    HorizontalDivider()
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .size(10.dp)
    )
}