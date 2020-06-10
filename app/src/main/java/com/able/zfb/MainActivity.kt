package com.able.zfb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import java.io.File
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread(Runnable {
            DownloadUtil.get().download("http://47.240.175.28/bookmate/temp/6.txt", filesDir.absolutePath,"6.txt",
                object :DownloadUtil.OnDownloadListener{
                    override fun onDownloading(progress: Int) {
                        Log.i("下载进度","$progress")

                    }

                    override fun onDownloadFailed(e: Exception?) {
                        Log.i("下载失败","${e?.message}")

                    }

                    override fun onDownloadSuccess(file: File?) {
                        Log.i("下载成功","${file?.absolutePath}")

                    }

                }
            )
        }).start()

    }


}