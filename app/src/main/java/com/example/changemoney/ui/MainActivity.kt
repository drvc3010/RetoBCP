package com.example.changemoney.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.changemoney.R
import com.example.changemoney.data.DBHelper
import  kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {

         val handler = Handler()
        var i = 0
        i = progress_Bar!!.progress
        Thread(Runnable {
            while (i < 5000) {
                i += 1
                // Update the progress bar and display the current value
                handler.post(Runnable {
                    progress_Bar!!.progress = i
                    //txtView!!.text = i.toString() + "/" + progressBar!!.max
                })
                try {
                    Thread.sleep(5000)
                    val intent = Intent(this, CountryMoneyActivity::class.java)
                    startActivity(intent)

                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }).start()


    }


}
