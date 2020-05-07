package com.sogou.babel.gaudi

import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.atomic.AtomicInteger

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testMethod() {
        val var1 = AtomicInteger(1)
        val isSuccess = var1.compareAndSet(1, 2)
    }

    @Test
    fun testLoop() {
        val arrays = arrayOf(1, 2, 3, 4, 5, 6)
        run breaking@ {
            arrays.forEach {
                if (it == 3) {
                    return@breaking
                }
                print("item: $it")
            }
        }


        print ("is OVer")
    }

}
