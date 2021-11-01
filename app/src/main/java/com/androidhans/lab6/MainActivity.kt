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
        //建立要顯示在的列表上的字串,名稱為item
        val item = arrayOf("選項1", "選項2", "選項3", "選項4", "選項5")

        //Button 點擊事件
        btn_toast.setOnClickListener {
            showToast("預設 Toast") //執行 showToast 方法
        }
        
        //撰寫客制化Toast
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
        //撰寫按鈕式Snackbar,使用aetAction()加入回應按鈕
        btn_snackbar.setOnClickListener {
            //建立 Snackbar 物件
            Snackbar.make(it, "按鈕式 Sanckbar", Snackbar.LENGTH_INDEFINITE) //顯示時間長度_不限
                .setAction("按鈕") {
                    showToast("已回應") //按鈕觸發後的反應
                }
                .show()
        }
        
        //撰寫按鈕式AlertDialog,並使用三種按鈕
        btn_dialog1.setOnClickListener {
            //建立 AlertDialog 物件
            AlertDialog.Builder(this)
                .setTitle("按鈕式 AlertDialog")//設定標題
                .setMessage("AlertDialog 內容")//設定內容
                .setNeutralButton("左按鈕") {
                        dialog, which -> //按鍵被點擊後顯示左按鈕
                   showToast("你按下的是左按鈕")
                }
                .setNegativeButton("中按鈕") {
                        dialog, which -> //按鍵被點擊後顯示中按鈕
                    showToast("你按下的是中按鈕")
                }
                .setPositiveButton("右按鈕") {
                    dialog, which -> //按鍵被點擊後顯示右按鈕
                    showToast("你按下的是右按鈕")
                }.show()

        }
        //撰寫列表式AlertDialog,使用setlitems()加入清單列表
        btn_dialog2.setOnClickListener {
            //建立 AlertDialog 物件  
            AlertDialog.Builder(this)
                .setTitle("列表式AlertDialog")//設定標題
                .setItems(item) {dialogInterface, i ->//(item)對應最上面的陣列名稱為item
                    //顯示被點擊的項目
                    showToast("你選的是${item [i]}")}
                .show()
                    
                }

        //撰寫單選式AlertDialog,使用setSingleChoicelitems()
        btn_dialog3.setOnClickListener {
            var position = 0 //定義位置=0
            //建立 AlertDialog 物件
            AlertDialog.Builder(this)
                .setTitle("單選式AlertDialog")//設定標題
                .setSingleChoiceItems(item,0) { dialogInterface, i ->//(item)對應最上面的陣列名稱為item
                    //記錄被按下的位置
                    position = i
                }
                .setPositiveButton("確定") {dialog, which ->
                    //正向按鈕,顯示被點擊的項目
                    showToast("你選的是${item [position]}")}
                .show()
                }
        }

    //建立 showToast 方法顯示 Toast 訊息,上述各類型共用下面
    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
.show()

    }
}




