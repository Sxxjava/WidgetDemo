package org.itsk.dialog.effects;

import com.nineoldandroids.animation.ObjectAnimator;
import android.view.View;

public class FlipH  extends BaseEffects{

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "rotationY", -90, 0).setDuration(mDuration)

        );
    }
}
