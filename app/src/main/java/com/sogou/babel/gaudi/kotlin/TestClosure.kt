package com.sogou.babel.gaudi.kotlin

class TestClosure {

    private fun methodHello(): String {
        return "Hello"
    }


    fun testClosure() {
        val runResult = "hello".run {
            methodHello()
            println(length)
            "world"
        } == "world"

        "hello".also {

        }

        "hello".apply {

        }

        "hello".let {

        }

    }

}