KMPSHAREDPREF
==============

Kotlin Multiplatform library to simplify using SharedPreferences (Android) / UserDefaults (iOS) in a multiplatform project.

---

Gradle Dependency
-----------------

Add the dependency in your `commonMain` source set:

implementation("io.github.shahzaibali02:kmpsharedpref:1.0.2")

---

Usage
-----

1) **Android Initialization**

Before using the library on Android, initialize it with a context:

KMPSharedPref.init(context)

2) Create an instance using the factory function:

// Android
val sharedPref = KMPSharedPref.create("MyCustomPrefName")

// iOS
val sharedPref = createSharedPref("MyCustomPrefName")

3) Save values:

sharedPref.saveString("username", "Shahzaib")
sharedPref.saveInt("age", 25)
sharedPref.saveBool("isPremium", true)

4) Read values:

val name = sharedPref.getString("username")
val age = sharedPref.getInt("age")
val isPremium = sharedPref.getBool("isPremium")

---

Features
--------

- Kotlin Multiplatform: works on Android + iOS
- Simple interface for storing primitive types
- Supports custom preference name
- Fully multiplatform, no Android/iOS specific code required in common module

---

License
-------

This library is open source under the MIT License.
