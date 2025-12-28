# KmpSharedPref

Save primitive values effortlessly across Android & iOS!
One simple, unified API for SharedPreferences (Android) and UserDefaults (iOS).
Lightweight Kotlin Multiplatform library – write once, persist anywhere. 🚀

---

## Gradle Dependency

Make sure you have **Maven Central** in your repositories:

```kotlin
repositories {
    mavenCentral()
    // other repositories if needed
}
```

Add the dependency in your `commonMain` source set:

```kotlin
implementation("io.github.shahzaibali02:kmpsharedpref:1.0.3")
```

---

## Usage

### 1️⃣ Android Initialization

Before using the library on Android, initialize it with a context (usually in your `Application` class):

```kotlin
KMPSharedPref.init(context)
```

---

### 2️⃣ Create an instance

```kotlin
val sharedPref = createSharedPref("MyCustomPrefName")
```

---

### 3️⃣ Save values

```kotlin
sharedPref.saveString("username", "Shahzaib")
sharedPref.saveInt("age", 25)
sharedPref.saveBool("isPremium", true)
sharedPref.saveLong("salary", 1123123123121)
sharedPref.saveFloat("height", 5.9f)
```

---

### 4️⃣ Read values

```kotlin
val name = sharedPref.getString("username")
val age = sharedPref.getInt("age")
val isPremium = sharedPref.getBool("isPremium")
val salary = sharedPref.getLong("salary")
val height = sharedPref.getFloat("height")
```

---

### 5️⃣ Supported Methods

```kotlin
fun saveString(key: String, value: String)
fun saveInt(key: String, value: Int)
fun saveLong(key: String, value: Long)
fun saveBool(key: String, value: Boolean)
fun saveFloat(key: String, value: Float)

fun getString(key: String, defaultValue: String = ""): String
fun getInt(key: String, defaultValue: Int = 0): Int
fun getLong(key: String, defaultValue: Long = 0L): Long
fun getBool(key: String, defaultValue: Boolean = false): Boolean
fun getFloat(key: String, defaultValue: Float = 0.0f): Float
```

---

### 6️⃣ Screenshots

![App Screenshot ](ss2.png)


## Features

* ✅ Kotlin Multiplatform (Android + iOS)
* ✅ Simple interface for storing primitive types
* ✅ Supports custom preference names
* ✅ Fully multiplatform: no Android/iOS specific code needed in common module

---

##

## Example Project Using It
* https://github.com/ShahzaibAli02/KmpSharedPrefExampleProject

License
-------

This library is open source under the MIT License.
