package com.example.deep_link_test_android

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PackageManagerCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.deep_link_test_android.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        // Define the intent URL
        val intentUrl = "intent://www.peacocktv.com/deeplink?deeplinkData=%7B%22pvid%22%3A%22032611c6-3124-39f1-95f7-be5d8c2d676d%22%2C%22type%22%3A%22PROGRAMME%22%2C%22action%22%3A%22PLAY%22%7D#Intent;scheme=https;action=android.intent.action.MAIN;category=android.intent.category.LAUNCHER;package=com.peacocktv.peacockandroid;component=com.peacocktv.peacockandroid/com.sky.clientlib.deeplink.DeeplinkActivity;end"
//        val intentUrl = "https://www.netflix.com/watch/80095340" 80189685

        // Create an intent from the URL
        val intent = Intent.parseUri(intentUrl, Intent.URI_INTENT_SCHEME)
        Log.d("test-link", intent.toUri(0))
//        val context = applicationContext
//        val pm : PackageManager = context.packageManager
//        val packageName = "com.amazon.amazonvideo.livingroom"
//        val appList = pm.getInstalledPackages(PackageManager.GET_SIGNATURES)
//
//        for (appInfo in appList) {
//            println("App name: ${appInfo.packageName}")
//        }
//        try {
//            println(PackageManager.GET_ACTIVITIES)
//            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
//            println("test-link: Found package?");
//            println(pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES))
//        } catch (e: Exception) {
//            println("test-link errrrr:")
//            println("test-link ${e.toString()}")
//        }
        // Start the activity
        startActivity(intent)
    }
}