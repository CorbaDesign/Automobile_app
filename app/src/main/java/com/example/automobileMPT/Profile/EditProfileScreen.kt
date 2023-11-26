import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import coil.compose.rememberImagePainter
import com.example.automobileMPT.Profile.ImagePicker

@Composable
fun EditProfileScreen(viewModel: UserProfileViewModel) {
    var name by remember { mutableStateOf(viewModel.name) }
    var email by remember { mutableStateOf(viewModel.email) }
    var city by remember { mutableStateOf(viewModel.city) }
    var streetname by remember { mutableStateOf(viewModel.streetname) }
    var housenumber by remember { mutableStateOf(viewModel.housenumber) }


    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Naam") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value  = city, onValueChange = { city = it }, label = {Text("city")} )
        TextField(value  = streetname, onValueChange = { streetname = it }, label = {Text("streetname")} )
        TextField(value  = housenumber, onValueChange = { housenumber = it }, label = {Text("housenumber")} )

        ImagePicker(onImagePicked = { imageUri ->
            viewModel.profileImageUri = imageUri
        })

        if (viewModel.profileImageUri.isNotEmpty()) {
            Image(
                painter = rememberImagePainter(data = viewModel.profileImageUri),
                contentDescription = "Profile Image"
            )
        }



        Button(onClick = {
            viewModel.name = name
            viewModel.email = email
            viewModel.saveProfile()
        }) {
            Text("Save changes")
        }
    }
}


