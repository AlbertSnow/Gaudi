package com.albert.snow.baselibrary

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Test
import java.util.concurrent.atomic.AtomicLong

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CoroutineUnitTest {

    suspend fun testPrint() {
        System.out.println("SuspendThread ${Thread.currentThread().name}")
    }

    @Test
    fun testCoroutine() {
        System.out.println("MainThread ${Thread.currentThread().name}")
        GlobalScope.launch {
            System.out.println("Hello Im prefix 1")
            delay(1000 * 30)
            testPrint()
        }
        GlobalScope.launch {
            System.out.println("Hello Im prefix 2")
            Thread.sleep(1000 * 30)
        }

        Thread.sleep(1000 * 100)
    }

    @Test
    fun testCreateCoroutine() {
        val c = AtomicLong()

        for (i in 1..10000) {
            println("test justTest")

            GlobalScope.launch {
                c.getAndSet(i.toLong())
            }
        }

        println(c.get())
    }
}
