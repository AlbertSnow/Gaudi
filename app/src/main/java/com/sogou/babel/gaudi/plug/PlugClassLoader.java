package com.sogou.babel.gaudi.plug;

import android.util.Log;

import dalvik.system.PathClassLoader;

/***
 * 加载任意后缀的zip格式的classLoader，主要用来加载.p后缀的apk文件
 */
public class PlugClassLoader extends PathClassLoader {

    public ClassLoader originalClassLoader;


    public PlugClassLoader(String dexPath, ClassLoader parent) {
        super(dexPath, parent);
        originalClassLoader = parent;
    }

    public ClassLoader getOriginalClassLoader() {
        return originalClassLoader;
    }
}

