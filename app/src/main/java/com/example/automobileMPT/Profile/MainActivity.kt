package com.example.automobileMPT.Profile

import EditProfileScreen
import UserProfileViewModel
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.automobile.ui.theme.AutoMobileTheme
import com.example.automobile2.AppNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = UserProfileViewModel()
            EditProfileScreen(viewModel = viewModel)
        }
    }
}

@Composable
fun UserProfileApp(viewModel: UserProfileViewModel) {
    Column {
        if (viewModel.isProfileComplete()) {
            Text("Profiel is compleet")

        } else {
            EditProfileScreen(viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileAppPreview() {
    AutoMobileTheme {
        UserProfileApp(UserProfileViewModel())
    }
}