package com.wuziq.lottierobolectrictest;

import android.animation.Animator;

import com.airbnb.lottie.LottieAnimationView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ExampleUnitTest {

    private boolean started;
    private boolean repeated;

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;
    }

    @Test
    public void lottie_isAnimating() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        LottieAnimationView lottieAnimationView = (LottieAnimationView) activity.findViewById(R.id.lottieanimation);

        assertTrue(lottieAnimationView.isAnimating()); // fails here
    }

    @Test
    public void lottie_isAnimating_workaround() {
        ActivityController<MainActivity> activityController = Robolectric.buildActivity(MainActivity.class);

        LottieAnimationView lottieAnimationView = (LottieAnimationView) activityController.create().get().findViewById(R.id.lottieanimation);
        started = false;
        repeated = false;
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                started = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {}

            @Override
            public void onAnimationCancel(Animator animation) {}

            @Override
            public void onAnimationRepeat(Animator animation) {
                repeated = true;
            }
        });

        activityController.start().resume().visible();

        assertTrue(started);
        assertTrue(repeated);
    }
}