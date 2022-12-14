package com.yousufjamil.inteclick

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class InternetProblemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_problem)

        val retryBtn = findViewById<Button>(R.id.retryBtn)
        val noInternetImg = findViewById<ImageView>(R.id.noInternetImg)

        retryBtn.setOnClickListener {
            val connectionManager: ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectionManager.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
            if (isConnected) {
                val finishLoadingIntent = Intent(this, WebViewActivity::class.java)
                startActivity(finishLoadingIntent)
                finish()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("No connection found")
                    .setMessage("Your device does not seem to be connected to internet. Please check your network connection")
                    .setPositiveButton("OK") { dialog, which ->
                        // Do nothing
                    }
                    .show()
            }
        }

    }
}