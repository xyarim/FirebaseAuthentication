package uz.sesh.firebaseapp.ui.sign

import com.google.firebase.auth.FirebaseAuth
import uz.sesh.firebaseapp.R

/**
 * Created with love by xyarim on 21.02.18.
 */
class SignPresenter(private var view: SignContract.View) : SignContract.Presenter {
    private var mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun login(email: String, password: String) {
        view.showMessage(R.string.message_authentication)
        view.showLoading()
        mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener({ task ->
            if (task.isSuccessful) {
                view.showMessage(R.string.message_authentication_success)
                view.openProfileActivity()
            } else {
                view.showMessage(R.string.message_authentication_failure)
                view.showMessage(task.exception?.message.toString())
            }
            view.hideLoading()
        })

    }
}