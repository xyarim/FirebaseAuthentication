package uz.sesh.firebaseapp.ui.profile

import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.content_profile.*
import uz.sesh.firebaseapp.R
import uz.sesh.firebaseapp.ui.base.BaseActivity
import uz.sesh.firebaseapp.ui.sign.SignActivity

class ProfileActivity : BaseActivity() {
    private var mFirebaseAuth = FirebaseAuth.getInstance()!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = mFirebaseAuth.currentUser!!.email
        showSnackBar(mFirebaseAuth.currentUser!!.email!!)
        buttonLogout.setOnClickListener({
            showSnackBar(R.string.message_logout)
            mFirebaseAuth.signOut()
        })
        mFirebaseAuth.addAuthStateListener {it->
            if (it.currentUser==null){
                finish()
                startActivity(SignActivity.getStartIntent(this))
            }
        }
    }

}
