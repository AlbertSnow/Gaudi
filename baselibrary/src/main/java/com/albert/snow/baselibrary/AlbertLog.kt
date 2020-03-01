package com.albert.snow.baselibrary

import android.util.Log

var isDebug = false
const val TAG_DEFAULT = "AlbertLog"
object AlbertLog {

    fun d(tag: String = TAG_DEFAULT, msg: String) {
        if (isDebug) {
            return
        }
        Log.d(tag, handleMsg(msg))
    }

    fun i(tag: String = TAG_DEFAULT, msg: String) {
        if (isDebug) {
            return
        }
        Log.i(tag, handleMsg(msg))
    }

    fun e(tag: String = TAG_DEFAULT, msg: String) {
        if (isDebug) {
            return
        }
        Log.e(tag, handleMsg(msg))
    }

    private fun handleMsg(msg: String): String {
        return msg
    }

}