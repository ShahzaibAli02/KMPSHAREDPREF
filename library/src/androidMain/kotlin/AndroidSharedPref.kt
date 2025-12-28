import android.content.Context
import android.content.SharedPreferences
import sharedpref.KMPSharedPref

class AndroidSharedPref(
    context: Context,
    prefName: String = "KMPSharedPref"
) : LocalSharedPref {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    override fun saveString(key: String, value: String) = prefs.edit().putString(key, value).apply()
    override fun saveInt(key: String, value: Int) = prefs.edit().putInt(key, value).apply()
    override fun saveLong(key: String, value: Long) = prefs.edit().putLong(key, value).apply()
    override fun saveBool(key: String, value: Boolean) = prefs.edit().putBoolean(key, value).apply()


    override fun saveFloat(key: String, value: Float) = prefs.edit().putFloat(key, value).apply()

    override fun getFloat(key: String, defaultValue: Float): Float = prefs.getFloat(key, defaultValue)

    override fun getString(key: String, defaultValue: String): String =
        prefs.getString(key, defaultValue) ?: defaultValue

    override fun getInt(key: String, defaultValue: Int): Int =
        prefs.getInt(key, defaultValue)

    override fun getLong(key: String, defaultValue: Long): Long =
        prefs.getLong(key, defaultValue)

    override fun getBool(key: String, defaultValue: Boolean): Boolean =
        prefs.getBoolean(key, defaultValue)
}

// actual factory
actual fun createSharedPref(name: String): LocalSharedPref {
    return AndroidSharedPref(KMPSharedPref.context, name)
}
