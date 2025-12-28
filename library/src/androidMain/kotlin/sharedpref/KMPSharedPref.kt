package sharedpref

import android.content.Context

object KMPSharedPref {
    lateinit var context: Context

    fun init(appContext: Context) {
        context = appContext
    }
}

