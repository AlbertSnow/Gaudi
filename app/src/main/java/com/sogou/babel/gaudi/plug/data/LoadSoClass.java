package com.sogou.babel.gaudi.plug.data;

public class LoadSoClass {

    static {
        try {
            System.loadLibrary("Test");
        } catch (Error e) {
            e.printStackTrace();
        }

    }

}
