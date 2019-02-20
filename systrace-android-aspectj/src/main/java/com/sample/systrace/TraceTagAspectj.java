package com.sample.systrace;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Trace;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class TraceTagAspectj {

    private static final String TAG = "TraceTagAspectj";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Before("execution(* **(..))")
    public void before(JoinPoint joinPoint) {
        Trace.beginSection(joinPoint.getSignature().toString());
    }

    /**
     * hook method when it's called out.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @After("execution(* **(..))")
    public void after() {
        Trace.endSection();
    }
}
