package com.p20241004_amardhade_nycschools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.p20241004_amardhade_nycschools.presentation.schools.SchoolsScreenContainer
import com.p20241004_amardhade_nycschools.ui.theme._20241004AmarDhadeNYCSchoolsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _20241004AmarDhadeNYCSchoolsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        ActivityWrapper()
                    }
                }
            }
        }
    }
}

@Composable
fun ActivityWrapper() {
    NavigationManager(navController = rememberNavController())

}
