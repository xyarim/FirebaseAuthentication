package uz.sesh.firebaseapp.ui.sign

import android.content.Context

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_sign.*
import kotlinx.android.synthetic.main.content_sign.*
import uz.sesh.firebaseapp.R
import uz.sesh.firebaseapp.ui.base.BaseActivity
import uz.sesh.firebaseapp.ui.profile.ProfileActivity

class SignActivity : BaseActivity(), View.OnClickListener, SignContract.View {

    private lateinit var mSignPresenter: SignPresenter

    override fun openProfileActivity() {
        finish()
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    override fun showLoading() {
        enableInput(false)
    }

    override fun hideLoading() {
        enableInput(true)
    }

    private fun enableInput(isEnabled: Boolean) {
        progressBarHorizontal.visibility = if (isEnabled) View.INVISIBLE else View.VISIBLE
        buttonLogin.isEnabled = isEnabled
        editTextEmail.isEnabled = isEnabled
        editTextPassword.isEnabled = isEnabled
    }

    override fun onError(message: String) {

    }

    override fun onError(resId: Int) {
    }

    override fun showMessage(message: String) {
        showSnackBar(message)
    }

    override fun showMessage(resId: Int) {
        showSnackBar(resId)
    }

    override fun hideKeyboard() {

    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, SignActivity::class.java)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            buttonLogin.id -> {
                login()
            }
        }
    }

    private fun login() {
        if (validateForms()) mSignPresenter.login(
                editTextEmail.text.toString(),
                editTextPassword.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        setSupportActionBar(toolbar)
        buttonLogin.setOnClickListener(this)
        mSignPresenter = SignPresenter(this)
        editTextPassword.setOnEditorActionListener({ textView, id, keyEvent ->
            if (id == EditorInfo.IME_ACTION_DONE) {
                login()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        })
    }

    private fun validateForms(): Boolean {
        if (editTextEmail.text.isEmpty()) {
            showSnackBar(R.string.message_invalid_email)
            editTextEmail.requestFocus()
            return false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(editTextEmail.text).matches()) {
            showSnackBar(R.string.message_invalid_email)
            editTextEmail.requestFocus()
            return false
        }
        if (editTextPassword.text.isEmpty()) {
            showSnackBar(R.string.empty_password_text)
            editTextPassword.requestFocus()
            return false
        }
        return true
    }
}
