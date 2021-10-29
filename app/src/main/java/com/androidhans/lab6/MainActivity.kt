package com.androidhans.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //將變數與 XML 元件綁定
        val btn_toast = findViewById<Button>(R.id.btn_toast)
        val btn_custom = findViewById<Button>(R.id.btn_custom)
        val btn_snackbar = findViewById<Button>(R.id.btn_snackbar)
        val btn_dialog1 = findViewById<Button>(R.id.btn_dialog1)
        val btn_dialog2 = findViewById<Button>(R.id.btn_dialog2)
        val btn_dialog3 = findViewById<Button>(R.id.btn_dialog3)
        //建立要顯示在的列表上的字串
        val item = arrayOf("選項1", "選項2", "選項3", "選項4", "選項5")
        //Button 點擊事件
        btn_toast.setOnClickListener {
            showToast("預設 Toast") //執行 showToast 方法
        }
        btn_custom.setOnClickListener {
            //宣告 Toast
            val toast = Toast(this)
            //Toast 在畫面中顯示位置
            toast.setGravity(Gravity.TOP, 0, 50)
            //Toast 在畫面中顯示的持續時間
            toast.duration = Toast.LENGTH_SHORT
            //放入自定義的畫面 custom_toast.xml
            toast.view =
                layoutInflater.inflate(R.layout.custom_toast, null)
            //顯示於螢幕
            toast.show()
        }
        btn_snackbar.setOnClickListener {
            //建立 Snackbar 物件
            Snackbar.make(it, "按鈕式 Sanckbar", Snackbar.LENGTH_INDEFINITE) //顯示時間長度_不限
                .setAction("按鈕") {
                    showToast("已回應") //按鈕觸發後的反應
                }
                .show()
        }
        btn_snackbar.setOnClickListener {
            //建立 AlertDialog 物件
            AlertDialog.Builder(this)
                .setTitle("按鈕式 AlertDialog")//設定標題
                .setMessage("AlertDialog 內容")//設定內容
                .setNeutralButton("左按鈕") {
                        dialog, which -> //按鍵被點擊後顯示左按鈕
                   showToast("左按鈕")
                }
                .setNegativeButton("中按鈕") {
                        dialog, which -> //按鍵被點擊後顯示中按鈕
                    showToast("中按鈕")
                }
                .setPositiveButton("右按鈕") {
                    dialog, which -> //按鍵被點擊後顯示右按鈕
                    showToast("右按鈕")
                }

        }
        btn_dialog1.setOnClickListener {  }
        btn_dialog2.setOnClickListener {  }
        btn_dialog3.setOnClickListener {  }

    }

    //建立 showToast 方法顯示 Toast 訊息
    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
}




