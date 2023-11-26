import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserProfileViewModel : ViewModel() {
    var name: String = ""
    var email: String = ""
    var profileImageUri: String by mutableStateOf("")
    var city: String = ""
    var streetname: String = ""
    var housenumber: String = ""

    fun saveProfile() {
        // implement logic for saving profile

    }

    fun isProfileComplete(): Boolean {
        return name.isNotEmpty() && email.isNotEmpty() && profileImageUri.isNotEmpty()
    }
}
