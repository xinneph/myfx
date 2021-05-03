package code.solutions.myfx.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import code.solutions.fxmodel.Myfx
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    fun onClickedLoginButton(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.v("LOGIN", "onClickedLoginButton($login, $password)")
            val myfx = Myfx()
            myfx.login(login, password)
        }
    }
}