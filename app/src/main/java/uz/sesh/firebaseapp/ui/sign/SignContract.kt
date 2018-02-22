package uz.sesh.firebaseapp.ui.sign

import uz.sesh.firebaseapp.ui.base.MvpView

/**
 * Created with love by xyarim on 21.02.18.
 */
interface SignContract {
    interface View : MvpView {
        fun openProfileActivity()
    }

    interface Presenter {
        fun login(email: String, password: String)
    }
}