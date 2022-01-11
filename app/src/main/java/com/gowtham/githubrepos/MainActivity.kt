package com.gowtham.githubrepos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gowtham.githubrepos.navigation.Screens
import com.gowtham.githubrepos.ui.theme.GithubReposTheme
import com.gowtham.usecases.RepoUseCases
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repoCases: RepoUseCases


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubReposTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AppNavigation(repoCases)
                }
            }
        }
    }

}


@Composable
fun AppNavigation(repoCases: RepoUseCases) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
        ){

        composable(Screens.HomeScreen.route) {
            Button(onClick = {

                CoroutineScope(Dispatchers.IO).launch {
                    repoCases.getRepos.execute()
                }
            }){
                Text(text = "Hit my ass!")
            }
        }
    }
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
fun DefaultPreview() {
   /* GithubReposTheme {
        AppNavigation(repoCases)
    }*/
}