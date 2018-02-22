package uz.sesh.firebaseapp.ui.base

import android.support.annotation.StringRes

/**
 * Created with love by xyarim on 21.02.18.
 */
interface MvpView {
    fun showLoading()
    fun hideLoading()
    fun onError(message: String)
    fun onError(@StringRes resId: Int)
    fun showMessage(message: String)
    fun showMessage(@StringRes resId: Int)
    fun hideKeyboard()
}