package jp.kirikiri.krkrz;

import android.os.Bundle;
import android.view.SurfaceHolder;

public class MainActivity extends BaseMainActivity {
    boolean mIsStartScript;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsStartScript = false;
    }
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        super.surfaceChanged( holder, format, w, h );
        if( mIsStartScript == false ) {
            nativeStartScript();
            mIsStartScript = true;
        }
    }
}
