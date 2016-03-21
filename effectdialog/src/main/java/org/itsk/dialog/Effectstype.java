package org.itsk.dialog;


import org.itsk.dialog.effects.BaseEffects;
import org.itsk.dialog.effects.FadeIn;
import org.itsk.dialog.effects.FlipH;
import org.itsk.dialog.effects.FlipV;
import org.itsk.dialog.effects.NewsPaper;
import org.itsk.dialog.effects.SideFall;
import org.itsk.dialog.effects.SlideLeft;
import org.itsk.dialog.effects.SlideRight;
import org.itsk.dialog.effects.SlideBottom;
import org.itsk.dialog.effects.SlideTop;
import org.itsk.dialog.effects.Fall;
import org.itsk.dialog.effects.RotateBottom;
import org.itsk.dialog.effects.RotateLeft;
import org.itsk.dialog.effects.Slit;
import org.itsk.dialog.effects.Shake;

public enum  Effectstype {

    Fadein(FadeIn.class),
    Slideleft(SlideLeft.class),
    Slidetop(SlideTop.class),
    SlideBottom(SlideBottom.class),
    Slideright(SlideRight.class),
    Fall(Fall.class),
    Newspager(NewsPaper.class),
    Fliph(FlipH.class),
    Flipv(FlipV.class),
    RotateBottom(RotateBottom.class),
    RotateLeft(RotateLeft.class),
    Slit(Slit.class),
    Shake(Shake.class),
    Sidefill(SideFall.class);
    private Class<? extends BaseEffects> effectsClazz;

    private Effectstype(Class<? extends BaseEffects> mclass) {
        effectsClazz = mclass;
    }

    public BaseEffects getAnimator() {
        BaseEffects bEffects=null;
	try {
		bEffects = effectsClazz.newInstance();
	} catch (ClassCastException e) {
		throw new Error("Can not init animatorClazz instance");
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		throw new Error("Can not init animatorClazz instance");
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		throw new Error("Can not init animatorClazz instance");
	}
	return bEffects;
    }
}
