package com.zuhaibahmad.jetpacksample.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import androidx.core.content.ContextCompat
import timber.log.Timber
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.Calendar

fun Context.hasPermissions(vararg permissions: String): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        permissions
            .filter {
                ContextCompat.checkSelfPermission(
                    this,
                    it
                ) != PackageManager.PERMISSION_GRANTED
            }
            .forEach {
                Timber.v("Permission Not Granted: $it")
                return false
            }
    }
    return true
}

fun Context.appendLog(text: String, filename: String) {
    val dir = File(Environment.getExternalStorageDirectory(), "Logs")
    if (!dir.exists()) {
        dir.mkdirs()
    }

    val logFile = File(dir, filename)
    if (!logFile.exists()) {
        try {
            logFile.createNewFile()
        } catch (ignored: IOException) {
        }
    }
    try {
        //BufferedWriter for performance, true to set append to file flag
        val buf = BufferedWriter(FileWriter(logFile, true))
        buf.newLine()
        buf.append(Calendar.getInstance().time.toString()).append(" -> ").append(text)
        buf.newLine()
        buf.newLine()
        buf.close()
    } catch (ignored: IOException) {
    }
}
