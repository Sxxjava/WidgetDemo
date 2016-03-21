package org.itsk.dialog.effects;

//import android.animation.ObjectAnimator;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

public class FadeIn extends BaseEffects{

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().
                playTogether(ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration));
    }
}
