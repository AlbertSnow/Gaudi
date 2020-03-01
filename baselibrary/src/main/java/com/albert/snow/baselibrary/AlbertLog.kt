package com.albert.snow.baselibrary

import android.util.Log

var isForbiddenLog = false
const val TAG_DEFAULT = "AlbertLog"
object AlbertLog {

    fun d(msg: String, tag: String = TAG_DEFAULT) {
        if (isForbiddenLog) {
            return
        }
        Log.d(tag, handleMsg(msg))
    }

    fun i(msg: String, tag: String = TAG_DEFAULT) {
        if (isForbiddenLog) {
            return
        }
        Log.i(tag, handleMsg(msg))
    }

    fun e(msg: String, tag: String = TAG_DEFAULT) {
        if (isForbiddenLog) {
            return
        }
        Log.e(tag, handleMsg(msg))
    }

    private fun handleMsg(msg: String): String {
        return msg
    }

}