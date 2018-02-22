package uz.sesh.firebaseapp.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import uz.sesh.firebaseapp.ui.base.BaseActivity
import uz.sesh.firebaseapp.ui.profile.ProfileActivity
import uz.sesh.firebaseapp.ui.sign.SignActivity


/**
 * Created with love by xyarim on 21.02.18.
 */
class EntrySplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            startActivity(Intent(this, ProfileActivity::class.java))
        } else {
            startActivity(Intent(this, SignActivity::class.java))
        }
        finish()
    }

}