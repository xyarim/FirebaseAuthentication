package uz.sesh.firebaseapp

import android.app.Application

/**
 * Created with love by xyarim on 21.02.18.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //TODO: ENABLE NETWORK LOGGING
        }
    }
}