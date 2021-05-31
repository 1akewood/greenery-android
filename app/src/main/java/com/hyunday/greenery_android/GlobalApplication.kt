package com.hyunday.greenery_android

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "6499bb3c7dc91692323d2879b955b89c")
    }
}