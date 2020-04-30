package com.sogou.babel.gaudi.plug;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DexPathListInvocationHandler implements InvocationHandler {

    private Object originalDexPath;

    public DexPathListInvocationHandler(Object originalDexPath) {
        this.originalDexPath = originalDexPath;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.i("testPlug", "invoke method: " + method.getName());
        return method.invoke(originalDexPath, args);
    }

}
