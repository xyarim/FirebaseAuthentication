package uz.sesh.firebaseapp.ui.base

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup

/**
 * Created with love by xyarim on 21.02.18.
 */
open class BaseActivity : AppCompatActivity() {
    protected fun showSnackBar(@StringRes res: Int) {
        val rootView = getRootView()
        if (rootView != null)
            Snackbar.make(rootView, res, Snackbar.LENGTH_LONG).show()
    }

    protected fun showSnackBar(text: String) {
        val rootView = getRootView()
        if (rootView != null)
            Snackbar.make(rootView, text, Snackbar.LENGTH_LONG).show()
    }

    private fun getRootView(): View? {
        val contentViewGroup = findViewById<View>(android.R.id.content) as ViewGroup
        var rootView: View? = null

        if (contentViewGroup != null)
            rootView = contentViewGroup.getChildAt(0)

        if (rootView == null)
            rootView = window.decorView.rootView

        return rootView
    }
}