package com.hyunday.greenery_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class ScanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
        initQRcodeScanner()
    }

    private fun initQRcodeScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setBeepEnabled(false)
        integrator.setOrientationLocked(true)
        integrator.setPrompt("QR코드를 인증해주세요.")
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result : IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        var toast = Toast(this)
        if (result != null) {
            if(result.contents == null) {
                // qr코드에 주소가 없거나, 뒤로가기 클릭
                Toast.makeText(applicationContext, "QR코드 인증이 취소되었습니다.", Toast.LENGTH_SHORT)
                //toast.drawCustomToast("QR코드 인증이 취소되었습니다.")
                finish()
            } else {
                //qr코드에 주소가 있을때 -> 주소에 관한 Toast 띄우는 함수 호출
                Toast.makeText(applicationContext, "인증되었습니다.", Toast.LENGTH_SHORT)
                //toast.initQrcodeToast(result.contents)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}