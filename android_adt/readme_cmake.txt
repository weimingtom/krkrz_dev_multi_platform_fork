D:\work_krkrz\krkrz_dev_multi_platform\android_cdt\jni>ndk-build NDK_DEBUG=1 -j8

adb logcat -s "::"
adb logcat -s "jts::"

//throw new Exception("MessageLayer.tjs::function processCh(ch) 1");
Debug.message("MessageLayer.tjs::function processCh(ch) 1");

LOGI("tTVPApplication::mainLoop 1");

TVPAddLog(TJS_W("tTJSNI_Canvas::Construct: Android new tTVPOpenGLScreen"));


----
cmake -DCMAKE_TOOLCHAIN_FILE=/home/wmt/work_krkrz/android-ndk-r26d/build/cmake/android.toolchain.cmake ..

//search fseeko, __ANDROID_API__ >= 24
cmake -DCMAKE_TOOLCHAIN_FILE=/home/wmt/work_krkrz/android-ndk-r26d/build/cmake/android.toolchain.cmake -DANDROID_PLATFORM=android-24 ..

//for std::binary_function, <= 14
cmake -DCMAKE_TOOLCHAIN_FILE=/home/wmt/work_krkrz/android-ndk-r26d/build/cmake/android.toolchain.cmake -DANDROID_PLATFORM=android-24 -DCMAKE_CXX_STANDARD=14 ..


-------------


04-02 14:16:48.773  2214  2214 E AndroidRuntime: java.lang.UnsatisfiedLinkError: undefined symbol: __popcount_tab
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at java.lang.Runtime.loadLibrary(Runtime.java:373)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at java.lang.System.loadLibrary(System.java:1076)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at jp.kirikiri.krkrz.BaseMainActivity.initializeNative(BaseMainActivity.java:161)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at jp.kirikiri.krkrz.BaseMainActivity.onCreate(BaseMainActivity.java:148)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at jp.kirikiri.krkrz.MainActivity.onCreate(MainActivity.java:15)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.app.Activity.performCreate(Activity.java:6394)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1111)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2499)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2606)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.app.ActivityThread.-wrap11(ActivityThread.java)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1444)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.os.Handler.dispatchMessage(Handler.java:102)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.os.Looper.loop(Looper.java:148)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at android.app.ActivityThread.main(ActivityThread.java:5654)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at java.lang.reflect.Method.invoke(Native Method)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:782)
04-02 14:16:48.773  2214  2214 E AndroidRuntime:        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:672)



// Count the 1 bits.
#if defined(_MSC_VER) && (defined(_M_IX86) || defined(_M_X64))
#    define ANGLE_HAS_BITCOUNT_32
inline int BitCount(uint32_t bits)
{
    return static_cast<int>(__popcnt(bits));
}
#    if defined(_M_X64)
#        define ANGLE_HAS_BITCOUNT_64
inline int BitCount(uint64_t bits)
{
    return static_cast<int>(__popcnt64(bits));
}
#    endif  // defined(_M_X64)
#endif      // defined(_M_IX86) || defined(_M_X64)

#if defined(ANGLE_PLATFORM_POSIX)
#    define ANGLE_HAS_BITCOUNT_32
inline int BitCount(uint32_t bits)
{
    return __builtin_popcount(bits);
}

#    if defined(ANGLE_IS_64_BIT_CPU)
#        define ANGLE_HAS_BITCOUNT_64
inline int BitCount(uint64_t bits)
{
    return __builtin_popcountll(bits);
}
#    endif  // defined(ANGLE_IS_64_BIT_CPU)
#endif      // defined(ANGLE_PLATFORM_POSIX)


------------
krkrz\external\angle\src\common 
mathutil.h


cmake -DCMAKE_TOOLCHAIN_FILE=/home/wmt/work_krkrz/android-ndk-r26d/build/cmake/android.toolchain.cmake -DANDROID_PLATFORM=android-24 -DCMAKE_CXX_STANDARD=11 -DANDROID_ABI="arm64-v8a" ..

armeabi-v7a
cmake -DCMAKE_TOOLCHAIN_FILE=/home/wmt/work_krkrz/android-ndk-r26d/build/cmake/android.toolchain.cmake -DANDROID_PLATFORM=android-24 -DCMAKE_CXX_STANDARD=11 -DANDROID_ABI="armeabi-v7a" ..


-----------------

adb logcat -s krkrz

04-02 17:05:15.345   549   549 E krkrz   : 17:05:15 (info) Loading configuration file asset://config.cf failed (ignoring) : file not found.
04-02 17:05:15.349   549   549 E krkrz   : 17:05:15 (info) Data path : file://storage/emulated/0/android/data/jp.kirikiri.krkrz/files
04-02 17:05:15.360   549   549 E krkrz   : 17:05:15 Kirikiri Z Executable core /1.0.0.1 (Compiled on Apr  2 2025 15:14:41) TJS2/2.4.28 Copyright (C) 1997-2013 W.Dee and contributors All rights reserved.
04-02 17:05:15.360   549   549 E krkrz   : 17:05:15 The details of version information can be perused if -about is attached and started.
04-02 17:05:15.452   549   549 E krkrz   : 17:05:15 Program started on Android 12(API Level 31) Country CN : Language zh (Android)
04-02 17:05:15.453   549   549 I krkrz   : 17:05:15 (info) Rebuilding Auto Path Table ...
04-02 17:05:15.453   549   549 I krkrz   : 17:05:15 (info) Total 0 file(s) found, 0 file(s) activated. (1ms)
04-02 17:05:15.453   549   549 E krkrz   : 17:05:15 (info) Total physical memory : 1470565
04-02 17:05:15.454   549   549 E krkrz   : 17:05:15 (info) Selected project directory : asset://./
04-02 17:05:15.471   549   549 E krkrz   : 17:05:15 (info) Specified option(s) (earlier item has more priority) : (none)
04-02 17:05:15.481   549   549 I krkrz   : onStart()
04-02 17:05:15.489   549   549 I krkrz   : onResume()
04-02 17:05:15.564   549   549 I krkrz   : Got window 0xec5fe408
04-02 17:05:15.565   549   699 I krkrz   : 17:05:15 (info) Loading startup script : startup.tjs
04-02 17:05:15.567   549   699 I krkrz   : 17:05:15 Hello world!
04-02 17:05:15.567   549   699 I krkrz   : 17:05:15 (info) Startup script ended.
04-02 17:05:15.635   549   549 I krkrz   : onWindowFocusChanged()
04-02 17:05:15.646   549   549 I krkrz   : onPause()
04-02 17:05:15.667   549   549 I krkrz   : onWindowFocusChanged()
04-02 17:05:16.266   549   549 I krkrz   : Releasing window
04-02 17:05:16.503   549   549 I krkrz   : onStop()
04-02 17:05:16.508   549   549 I krkrz   : onDestroy()

-------------------------



