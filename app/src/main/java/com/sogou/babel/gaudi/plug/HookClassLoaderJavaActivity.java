package com.sogou.babel.gaudi.plug;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.sogou.babel.gaudi.R;
import com.sogou.babel.gaudi.plug.data.LoadSoClass;

public class HookClassLoaderJavaActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook_classs_loader);
        new LoadSoClass();
    }

    public void  loadSoLibrary(View view)  {
        try {
            System.loadLibrary("opencv_java3");
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
