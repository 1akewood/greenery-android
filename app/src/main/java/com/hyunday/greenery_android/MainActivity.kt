package com.hyunday.greenery_android

import LoginFragment
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.common.util.Utility


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash) // 7lSr+NEVIw7m5Nbi7ey2LesfR70=

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, IllustratedFragment())
            .commit()

        /*
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, MainFragment())
            .commit()
         */

        /* supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, InfoFragment())
            .commit()
         */
    }
}