package code.solutions.myfx.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import code.solutions.fxmodel.Myfx

class LoginViewModel : ViewModel() {
    fun onClickedLoginButton(login: String, password: String) {
        Log.v("LOGIN", "onClickedLoginButton($login, $password)")
        val myfx = Myfx()
        myfx.login(login, password)
    }
}