package com.zuhaibahmad.jetpacksample.utils

import android.Manifest
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.zuhaibahmad.jetpacksample.BuildConfig
import com.zuhaibahmad.jetpacksample.application.AppConstants
import timber.log.Timber

class FileLogsTree(val context: Context) : Timber.Tree() {

    companion object {
        const val PERMISSION_ERROR_MSG = "Please provide write permission for logging"
    }

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        if (!BuildConfig.DEBUG) {
            return false
        }

        return priority > Log.WARN
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) = context.run {
        val hasPermission = hasPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (hasPermission) appendLog(Log.getStackTraceString(t), AppConstants.LOG_FILE_NAME)
        else Toast.makeText(this, PERMISSION_ERROR_MSG, Toast.LENGTH_SHORT).show()
    }
}
