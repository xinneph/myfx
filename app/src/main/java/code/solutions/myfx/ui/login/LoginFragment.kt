package code.solutions.myfx.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import code.solutions.myfx.R

class LoginFragment : Fragment() {
    val viewModel: LoginViewModel by viewModels()
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        val loginView = root.findViewById<EditText>(R.id.loginEditText)
        val passwordView = root.findViewById<EditText>(R.id.passwordEditText)
        val okButton = root.findViewById<Button>(R.id.loginButton)
        
        okButton.setOnClickListener {
            val login = loginView.text.toString()
            val password = passwordView.text.toString()
            viewModel.onClickedLoginButton(login, password)
        }
        return root
    }
}