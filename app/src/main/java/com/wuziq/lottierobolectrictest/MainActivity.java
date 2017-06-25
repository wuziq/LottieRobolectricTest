package com.wuziq.lottierobolectrictest;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottieanimation);
        lottieAnimationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d(TAG, "onAnimationUpdate():  lottieAnimationView.isAnimating() = " + lottieAnimationView.isAnimating());
            }
        });
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(TAG, "onAnimationStart():  lottieAnimationView.isAnimating() = " + lottieAnimationView.isAnimating());
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(TAG, "onAnimationEnd():  lottieAnimationView.isAnimating() = " + lottieAnimationView.isAnimating());
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d(TAG, "onAnimationCancel():  lottieAnimationView.isAnimating() = " + lottieAnimationView.isAnimating());
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d(TAG, "onAnimationRepeat():  lottieAnimationView.isAnimating() = " + lottieAnimationView.isAnimating());
            }
        });

        lottieAnimationView.setAnimation("lottiesample.json");
        lottieAnimationView.setProgress(0);
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }
}
