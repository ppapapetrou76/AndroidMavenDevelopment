package com.packt.androidMaven.tests;

import android.app.Application;
import android.app.KeyguardManager;
import android.os.PowerManager;
import android.test.InstrumentationTestRunner;

import static android.content.Context.KEYGUARD_SERVICE;
import static android.content.Context.POWER_SERVICE;
import static android.os.PowerManager.ACQUIRE_CAUSES_WAKEUP;
import static android.os.PowerManager.FULL_WAKE_LOCK;
import static android.os.PowerManager.ON_AFTER_RELEASE;

public class SpoonInstrumentationTestRunner extends InstrumentationTestRunner {

    @Override
    public void onStart() {
        runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Application app = (Application) getTargetContext().getApplicationContext();
                String simpleName = SpoonInstrumentationTestRunner.class.getSimpleName();
                ((KeyguardManager) app.getSystemService(KEYGUARD_SERVICE)) //
                        .newKeyguardLock(simpleName) //
                        .disableKeyguard();
                ((PowerManager) app.getSystemService(POWER_SERVICE)) //
                        .newWakeLock(FULL_WAKE_LOCK | ACQUIRE_CAUSES_WAKEUP | ON_AFTER_RELEASE, simpleName) //
                        .acquire();
            }
        });

        super.onStart();
    }
}
