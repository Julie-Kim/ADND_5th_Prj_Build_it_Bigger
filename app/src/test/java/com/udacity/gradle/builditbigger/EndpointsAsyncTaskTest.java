package com.udacity.gradle.builditbigger;

import android.test.InstrumentationTestCase;
import android.text.TextUtils;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class EndpointsAsyncTaskTest extends InstrumentationTestCase {

    private String mResult = null;
    private Exception mError = null;
    private CountDownLatch mSignal = null;

    @Override
    protected void setUp() throws Exception {
        mSignal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        mSignal.countDown();
    }

    @Test
    public void testFetchJokeTask() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String result, Exception e) {
                mResult = result;
                mError = e;
                mSignal.countDown();
            }
        }).execute();
        mSignal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(mResult));
    }
}
