package com.able.zfb

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val request: Request = Request.Builder().get().url("http://47.240.175.28/bookmate/server/home.php").build()
        val call: Call = OkHttpClient().newCall(request)
        call.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.i("请求", "Get 失败");

            }
            override fun onResponse(call: Call, response: Response) {
                val string = response.body?.string()
                runOnUiThread {
                    AlertDialog.Builder(this@MainActivity).setMessage(string).show()
                }
            }

        })

//        Thread(Runnable {
//            DownloadUtil.get().download("http://47.240.175.28/bookmate/temp/6.txt", filesDir.absolutePath,"6.txt",
//                object :DownloadUtil.OnDownloadListener{
//                    override fun onDownloading(progress: Int) {
//                        Log.i("下载进度","$progress")
//
//                    }
//
//                    override fun onDownloadFailed(e: Exception?) {
//                        Log.i("下载失败","${e?.message}")
//
//                    }
//
//                    override fun onDownloadSuccess(file: File?) {
//                        Log.i("下载成功","${file?.absolutePath}")
//
//                    }
//
//                }
//            )
//        }).start()

    }


}