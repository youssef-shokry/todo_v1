package com.route.todoappc42

import android.app.Application
import com.route.todoappc42.database.MyDatabase

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MyDatabase.init(this)
    }
}