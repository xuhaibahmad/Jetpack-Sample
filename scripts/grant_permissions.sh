#!/usr/bin/env bash

PACKAGE_NAME="com.foxconn.slid"

adb shell pm grant $PACKAGE_NAME android.permission.SYSTEM_ALERT_WINDOW

adb shell pm grant $PACKAGE_NAME android.permission.READ_EXTERNAL_STORAGE

adb shell pm grant $PACKAGE_NAME android.permission.WRITE_EXTERNAL_STORAGE

adb shell pm grant $PACKAGE_NAME android.permission.ACCESS_COARSE_LOCATION

adb shell pm grant $PACKAGE_NAME android.permission.ACCESS_FINE_LOCATION