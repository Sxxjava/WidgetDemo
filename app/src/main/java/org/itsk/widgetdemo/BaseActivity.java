package org.itsk.widgetdemo;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import org.itsk.xtoast.XToast;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 通过ID找到元素
     * @return 查找的元素是Button,返回的就是Button
     * */
    protected <T>T findViewByID(int resId){
        return (T) findViewById(resId);
    }

    /**
     * 通过ID找到元素
     * @param view 要查找的元素所在的view
     * @return 查找的元素是Button,返回的就是Button
     * */
    protected <T>T findViewByID(View view, int resId){
        return (T) view.findViewById(resId);
    }

    /**
     * 弹出Toast
     * @param text 显示的文本
     * @param animType 动画类型 {@link XToast.Animations}
     * @param duration 显示时长 {@link XToast.Duration}
     * @param background Toast的背景 {@link XToast.Background}
     * @param textSize 文字大小 sp
     * @param isShowIcon 是否显示图标
     * @param iconId 图标资源ID
     * @param iconPosition 图标显示的位置 {@link XToast.IconPosition}
     * */
    protected void showToast(String text, XToast.Animations animType, int duration, int background, int textSize,
                             boolean isShowIcon, int iconId, XToast.IconPosition iconPosition){
            XToast xToast = new XToast(this);
            xToast.setAnimations(animType);
            switch (duration) {
                case 0:
                    xToast.setDuration(XToast.Duration.SHORT);
                    break;
                case 1:
                    xToast.setDuration(XToast.Duration.MEDIUM);
                    break;
                case 2:
                    xToast.setDuration(XToast.Duration.LONG);
                    break;
            }

            switch (background) {
                case 0:
                    xToast.setBackground(XToast.Background.BLACK);
                    break;
                case 1:
                    xToast.setBackground(XToast.Background.GRAY);
                    break;
                case 2:
                    xToast.setBackground(XToast.Background.GREEN);
                    break;
                case 3:
                    xToast.setBackground(XToast.Background.BLUE);
                    break;
                case 4:
                    xToast.setBackground(XToast.Background.RED);
                    break;
                case 5:
                    xToast.setBackground(XToast.Background.PURPLE);
                    break;
                case 6:
                    xToast.setBackground(XToast.Background.ORANGE);
                    break;
            }

            switch (textSize) {
                case 0:
                    xToast.setTextSize(XToast.TextSize.SMALL);
                    break;
                case 1:
                    xToast.setTextSize(XToast.TextSize.MEDIUM);
                    break;
                case 2:
                    xToast.setTextSize(XToast.TextSize.LARGE);
                    break;
            }

            if(isShowIcon) {
                xToast.setIcon(iconId, iconPosition);
            }
            xToast.setText(text);
            xToast.show();
    }
//    /**
//     * 弹出Toast
//     * @param text
//     * @param animType 动画类型 {@link org.itsk.xtoast.XToast.Animations}
//     * @param duration 显示时长 {@link org.itsk.xtoast.XToast.Duration}
//     * @param background Toast的背景 {@link org.itsk.xtoast.XToast.Background}
//     * @param textSize 文字大小 sp
//     * @param isShowIcon 是否显示图标
//     * @param icon 图标资源Bitmap
//     * @param iconPosition 图标显示的位置 {@link org.itsk.xtoast.XToast.IconPosition}
//     * */
//    protected void showToast(String text,XToast.Animations animType, int duration, int background, int textSize,
//                             boolean isShowIcon, Bitmap icon, XToast.IconPosition iconPosition){
//            XToast superToast = new XToast(this);
//            superToast.setAnimations(animType);
//            switch (duration) {
//                case 0:
//                    superToast.setDuration(XToast.Duration.SHORT);
//                    break;
//                case 1:
//                    superToast.setDuration(XToast.Duration.MEDIUM);
//                    break;
//                case 2:
//                    superToast.setDuration(XToast.Duration.LONG);
//                    break;
//            }
//
//            switch (background) {
//                case 0:
//                    superToast.setBackground(XToast.Background.BLACK);
//                    break;
//                case 1:
//                    superToast.setBackground(XToast.Background.GRAY);
//                    break;
//                case 2:
//                    superToast.setBackground(XToast.Background.GREEN);
//                    break;
//                case 3:
//                    superToast.setBackground(XToast.Background.BLUE);
//                    break;
//                case 4:
//                    superToast.setBackground(XToast.Background.RED);
//                    break;
//                case 5:
//                    superToast.setBackground(XToast.Background.PURPLE);
//                    break;
//                case 6:
//                    superToast.setBackground(XToast.Background.ORANGE);
//                    break;
//            }
//
//            switch (textSize) {
//                case 0:
//                    superToast.setTextSize(XToast.TextSize.SMALL);
//                    break;
//                case 1:
//                    superToast.setTextSize(XToast.TextSize.MEDIUM);
//                    break;
//                case 2:
//                    superToast.setTextSize(XToast.TextSize.LARGE);
//                    break;
//            }
//
//            if(isShowIcon) {
//                superToast.setIcon(icon, iconPosition);
//            }
//            superToast.setText(text);
//            superToast.show();
//    }
    /**
     * 弹出Toast
     * @param text
     * @param animType 动画类型 {@link XToast.Animations}
     * @param duration 显示时长 {@link XToast.Duration}
     * @param background Toast的背景 {@link XToast.Background}
     * @param textSize 文字大小 sp
     * @param isShowIcon 是否显示图标
     * @param icon 图标资源Drawable
     * @param iconPosition 图标显示的位置 {@link XToast.IconPosition}
     * */
    protected void showToast(String text, XToast.Animations animType, int duration, int background, int textSize,
                             boolean isShowIcon, Drawable icon, XToast.IconPosition iconPosition){
            XToast xToast = new XToast(this);
            xToast.setAnimations(animType);
            switch (duration) {
                case 0:
                    xToast.setDuration(XToast.Duration.SHORT);
                    break;
                case 1:
                    xToast.setDuration(XToast.Duration.MEDIUM);
                    break;
                case 2:
                    xToast.setDuration(XToast.Duration.LONG);
                    break;
            }

            switch (background) {
                case 0:
                    xToast.setBackground(XToast.Background.BLACK);
                    break;
                case 1:
                    xToast.setBackground(XToast.Background.GRAY);
                    break;
                case 2:
                    xToast.setBackground(XToast.Background.GREEN);
                    break;
                case 3:
                    xToast.setBackground(XToast.Background.BLUE);
                    break;
                case 4:
                    xToast.setBackground(XToast.Background.RED);
                    break;
                case 5:
                    xToast.setBackground(XToast.Background.PURPLE);
                    break;
                case 6:
                    xToast.setBackground(XToast.Background.ORANGE);
                    break;
            }

            switch (textSize) {
                case 0:
                    xToast.setTextSize(XToast.TextSize.SMALL);
                    break;
                case 1:
                    xToast.setTextSize(XToast.TextSize.MEDIUM);
                    break;
                case 2:
                    xToast.setTextSize(XToast.TextSize.LARGE);
                    break;
            }

            if(isShowIcon) {
                xToast.setIcon(icon, iconPosition);
            }
            xToast.setText(text);
            xToast.show();
    }

    protected void showToast(String text){
        showToast(text, XToast.Animations.FLYIN, XToast.Duration.VERY_SHORT,3,15,false,null, XToast.IconPosition.LEFT);
    }
}
