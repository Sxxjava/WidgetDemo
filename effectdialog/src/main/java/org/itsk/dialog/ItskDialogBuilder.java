package org.itsk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.itsk.dialog.effects.BaseEffects;


/*
 * Copyright 2015 Jour
 * https://github.com/sd6352051/NiftyDialogEffects
 */
public class ItskDialogBuilder extends Dialog implements DialogInterface {
    /**默认字体颜色*/
    private final String defTextColor="#FFFFFFFF";
    /**默认分割线颜色*/
    private final String defDividerColor="#11000000";
    /**默认信息文本颜色*/
    private final String defMsgColor="#FFFFFFFF";
    /**默认对话框颜色*/
    private final String defDialogColor="#FFE74C3C";
    /**对话框上下文对象*/
    private static Context tmpContext;
    /**对话框显示效果*/
    private Effectstype type=null;
    /**顶层RelativeLayout*/
    private RelativeLayout mRelativeLayoutView;
    /**对话框主布局容器*/
    private LinearLayout mLinearLayoutView;
    /**对话框顶部布局容器*/
    private RelativeLayout mTitleLayout;
    /**对话框顶部布局容器*/
    private LinearLayout mLinearLayoutTopView;
    /**对话框提示信息布局容器*/
    private LinearLayout mLinearLayoutMsgView;
    /**对话框自定义布局容器*/
    private FrameLayout mFrameLayoutCustomView;
    /**对话框按钮布局容器*/
    private LinearLayout mButtonLayout;
//    /***/
//    private View mDialogView;
    /**标题和内容的分割线*/
    private View mDivider;
    /**对话框标题*/
    private TextView mTitle;
    /**对话框提示信息*/
    private TextView mMessage;
    /**对话框标题上的图标*/
    private ImageView mIcon;
    /**确定按钮*/
    private Button mPositiveButton;
    /**取消按钮*/
    private Button mNegativeButton;
    /**中间的按钮*/
    private Button mNeutralButton;

    private int mDuration = -1;

    private static  int mOrientation=1;

    private boolean isCancelable=true;

    private static ItskDialogBuilder instance;

    /**
     * 构造函数
     * @param context
     *          上下文对象
     * */
    public ItskDialogBuilder(Context context) {
        super(context);
        init(context);

    }
    /**
     * 构造函数
     * @param context
     *          上下文对象
     * @param theme
     *          style资源id
     * */
    public ItskDialogBuilder(Context context, int theme) {
        super(context, theme);
        init(context);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window=getWindow();
        WindowManager.LayoutParams params = window.getAttributes();

        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width  = ViewGroup.LayoutParams.MATCH_PARENT;
        params.gravity=Gravity.CENTER;
        window.setAttributes((WindowManager.LayoutParams) params);
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));

    }

    /**
     * 获取实例对象
     * @param context
     *           上下文对象
     * @return ItskDialogBuilder
     *           自身builder对象
     * */
    public static ItskDialogBuilder getInstance(Context context) {

        if (instance == null || !tmpContext.equals(context)) {
            synchronized (ItskDialogBuilder.class) {
                if (instance == null || !tmpContext.equals(context)) {
                    instance = new ItskDialogBuilder(context);
                }
            }
        }
        tmpContext = context;
        return instance;
    }
    /**
     * 获取实例对象
     * @param context
     *          上下文对象
     * @param theme
     *          要使用的风格配置
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public static ItskDialogBuilder getInstance(Context context,int theme) {

        if (instance == null || !tmpContext.equals(context)) {
            synchronized (ItskDialogBuilder.class) {
                if (instance == null || !tmpContext.equals(context)) {
                    instance = new ItskDialogBuilder(context);
                }
            }
        }
        tmpContext = context;
        return instance;
    }

    private void init(Context context) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //mDialogView = View.inflate(context, R.layout.dialog_layout, null);
        //mRelativeLayoutView=(RelativeLayout)mDialogView.findViewById(R.id.main);
        /**创建对话框View*/
        {
            //创建对话框主View
            mRelativeLayoutView = new RelativeLayout(context);
            mRelativeLayoutView.setPadding(25, 0, 25, 0);
            mRelativeLayoutView.setBackgroundColor(Color.parseColor("#00000000"));

        }
        //mLinearLayoutView=(LinearLayout)mDialogView.findViewById(R.id.parentPanel);
        /**创建对话框顶层容器*/
        {
            /*创建LinearLayout*/
            mLinearLayoutView=new LinearLayout(context);
            /*设置自身属性*/
            mLinearLayoutView.setOrientation(LinearLayout.VERTICAL);
            mLinearLayoutView.setClickable(false);
            mLinearLayoutView.setVisibility(LinearLayout.VISIBLE);
            /*创建Shape*/
            GradientDrawable gradientDrawable=new GradientDrawable();
            gradientDrawable.setCornerRadius(2);
            gradientDrawable.setColor(Color.parseColor("#ffe74c3c"));
            /*设置Shape背景*/
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                mLinearLayoutView.setBackground(gradientDrawable);
            }else{
                mLinearLayoutView.setBackgroundDrawable(gradientDrawable);
            }
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            params.setMargins(25,0,25,0);
            mRelativeLayoutView.addView(mLinearLayoutView, params);
        }
        //mLinearLayoutTopView=(LinearLayout)mDialogView.findViewById(R.id.topPanel);
        /**创建对话框顶部面板*/
        {
            mLinearLayoutTopView=new LinearLayout(context);
            mLinearLayoutTopView.setOrientation(LinearLayout.VERTICAL);
            mLinearLayoutTopView.setBackgroundColor(Color.parseColor("#22000000"));

            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            mLinearLayoutView.addView(mLinearLayoutTopView,params);
        }
        /**获取ActionBarSize*/
        int actionBarSize=48;
        TypedValue tv=new TypedValue();
        if(context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)){
            actionBarSize=TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        /**创建对话框标题View*/
        {
            mTitleLayout=new RelativeLayout(context);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,actionBarSize);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                params.setMarginEnd(actionBarSize / 3);
                params.setMarginStart(actionBarSize / 3);
            }else{
                params.setMargins(actionBarSize/3,actionBarSize/3,0,0);
            }
            mLinearLayoutTopView.addView(mTitleLayout,params);
        }
        //mLinearLayoutMsgView=(LinearLayout)mDialogView.findViewById(R.id.contentPanel);
        /**创建对话框内容面板*/
        {
            mLinearLayoutMsgView=new LinearLayout(context);
            mLinearLayoutMsgView.setOrientation(LinearLayout.VERTICAL);
            mLinearLayoutMsgView.setMinimumHeight(32);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,1.0f);
            mLinearLayoutView.addView(mLinearLayoutMsgView,params);
        }
        //mFrameLayoutCustomView=(FrameLayout)mDialogView.findViewById(R.id.customPanel);
        /**创建对话框自定义视图面板*/
        {
            mFrameLayoutCustomView=new FrameLayout(context);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,1.0f);
            mLinearLayoutView.addView(mFrameLayoutCustomView,params);
        }
        /**创建对话框底部按钮面板*/
        {
            mButtonLayout = new LinearLayout(context);
            mButtonLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            mLinearLayoutView.addView(mButtonLayout,params);
        }
        //mIcon = (ImageView) mDialogView.findViewById(R.id.icon);
        /**创建对话框标题图标*/
        {
            mIcon=new ImageView(context);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);//(int)(actionBarSize/1.5)
            //params.addRule(RelativeLayout.CENTER_IN_PARENT);
            params.setMargins(8, 8, 8, 8);
            mIcon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            mTitleLayout.addView(mIcon,params);
        }
        //mTitle = (TextView) mDialogView.findViewById(R.id.alertTitle);
        /**创建对话框标题TextView*/
        {
            mTitle=new TextView(context);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            params.setMargins(8, 0, 0, 0);
            mTitle.setGravity(Gravity.CENTER);
            mTitle.setEllipsize(TextUtils.TruncateAt.END);
            mTitle.setSingleLine();
            mTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22.0f);
            mTitle.setTextColor(Color.parseColor(defTextColor));
            mTitleLayout.addView(mTitle,params);
        }
        //mDivider = mDialogView.findViewById(R.id.titleDivider);
        /**创建标题和内容的分割线*/
        {
            mDivider = new View(context);
            mDivider.setBackgroundColor(Color.parseColor(defDividerColor));
            mDivider.setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,1);
            mLinearLayoutTopView.addView(mDivider,params);
        }
        //mMessage = (TextView) mDialogView.findViewById(R.id.message);
        /**创建提示内容View*/
        {
            mMessage=new TextView(context);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,actionBarSize);
            params.setMargins(20,15,15,0);
            mMessage.setPadding(16, 8, 16, 8);
            mMessage.setMinHeight(32);
            mMessage.setTextColor(Color.parseColor(defMsgColor));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                mMessage.setTextIsSelectable(true);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mMessage.setTextAppearance(android.R.attr.textAppearanceMedium);
            }else{
                mMessage.setTextAppearance(context,android.R.attr.textAppearanceMedium);
            }
            mLinearLayoutMsgView.addView(mMessage,params);
        }

        //mButton1=(Button)mDialogView.findViewById(R.id.button1);
        //mButton2=(Button)mDialogView.findViewById(R.id.button2);

        {
            mPositiveButton=new Button(context);
            mPositiveButton.setMinHeight(36);
            mPositiveButton.setGravity(Gravity.CENTER);
            mPositiveButton.setTextColor(Color.parseColor(defTextColor));
            mPositiveButton.setText("OK");


            mNegativeButton=new Button(context);
            mNegativeButton.setMinHeight(36);
            mNegativeButton.setGravity(Gravity.CENTER);
            mNegativeButton.setTextColor(Color.parseColor(defTextColor));
            mNegativeButton.setText("Cancel");


            mNeutralButton=new Button(context);
            mNeutralButton.setMinHeight(36);
            mNeutralButton.setGravity(Gravity.CENTER);
            mNeutralButton.setTextColor(Color.parseColor(defTextColor));
            mNeutralButton.setText("Ignore");

            GradientDrawable unPressedDrawable=new GradientDrawable();
            unPressedDrawable.setCornerRadius(2);
            unPressedDrawable.setColor(Color.parseColor("#22000000"));

            GradientDrawable pressedDeawable=new GradientDrawable();
            pressedDeawable.setCornerRadius(2);
            pressedDeawable.setColor(Color.parseColor("#66000000"));

            StateListDrawable positiveButtonDrawable=new StateListDrawable();
            positiveButtonDrawable.addState(new int[]{-android.R.attr.state_pressed}, unPressedDrawable);
            positiveButtonDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDeawable);

            StateListDrawable neutralButtonDrawable=new StateListDrawable();
            neutralButtonDrawable.addState(new int[]{-android.R.attr.state_pressed}, unPressedDrawable);
            neutralButtonDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDeawable);

            StateListDrawable negativeButtonDrawable=new StateListDrawable();
            negativeButtonDrawable.addState(new int[]{-android.R.attr.state_pressed}, unPressedDrawable);
            negativeButtonDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDeawable);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                mPositiveButton.setBackground(positiveButtonDrawable);
                mNeutralButton.setBackground(neutralButtonDrawable);
                mNegativeButton.setBackground(negativeButtonDrawable);

            }else{
                mPositiveButton.setBackgroundDrawable(positiveButtonDrawable);
                mNeutralButton.setBackgroundDrawable(neutralButtonDrawable);
                mNegativeButton.setBackgroundDrawable(negativeButtonDrawable);

            }

            mNeutralButton.setVisibility(Button.GONE);
            mNegativeButton.setVisibility(Button.GONE);
            mPositiveButton.setVisibility(Button.GONE);

            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
            params.setMargins(10, 10, 5, 20);
            mButtonLayout.addView(mPositiveButton, params);
            params.setMargins(5, 10, 5, 20);
            mButtonLayout.addView(mNeutralButton, params);
            params.setMargins(5, 10, 10, 20);
            mButtonLayout.addView(mNegativeButton, params);


        }
        //setContentView(mDialogView);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        params.setMargins(25,0,25,0);
        setContentView(mRelativeLayoutView, params);
        
        this.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                
                mLinearLayoutView.setVisibility(View.VISIBLE);
                if(type==null){
                    type=Effectstype.Slidetop;
                }
                start(type);
                
                
            }
        });
        mRelativeLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCancelable)dismiss();
            }
        });
    }
    /**
     * 使用默认属性
     * */
    public void toDefault(){
        mTitle.setTextColor(Color.parseColor(defTextColor));
        mDivider.setBackgroundColor(Color.parseColor(defDividerColor));
        mMessage.setTextColor(Color.parseColor(defMsgColor));
        mLinearLayoutView.setBackgroundColor(Color.parseColor(defDialogColor));
    }
    /**
     * 设置标题栏和内容区的分割线颜色
     * @param colorString
     *          颜色字符串,例如"#ff255458"
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withDividerColor(String colorString) {
        mDivider.setBackgroundColor(Color.parseColor(colorString));
        return this;
    }
    /**
     * 设置标题栏和内容区的分割线颜色
     * @param color
     *          颜色值
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withDividerColor(int color) {
        mDivider.setBackgroundColor(color);
        return this;
    }
    /**
     * 设置对话框的标题
     * @param title
     *          对话框标题
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withTitle(CharSequence title) {
        toggleView(mLinearLayoutTopView,title);
        mTitle.setText(title);
        return this;
    }
    /**
     * 设置对话框的标题颜色
     * @param colorString
     *          对话框标题的文本颜色字符串,例如"#ff255458"
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withTitleColor(String colorString) {
        mTitle.setTextColor(Color.parseColor(colorString));
        return this;
    }
    /**
     * 设置对话框的标题颜色
     * @param color
     *          对话框标题颜色值
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withTitleColor(int color) {
        mTitle.setTextColor(color);
        return this;
    }
    /**
     * 设置对话框的提示信息
     * @param textResId
     *          字符串资源id
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withMessage(int textResId) {
        toggleView(mLinearLayoutMsgView,textResId);
        mMessage.setText(textResId);
        return this;
    }
    /**
     * 设置对话框的提示信息
     * @param msg
     *          提示的字符串内容
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withMessage(CharSequence msg) {
        toggleView(mLinearLayoutMsgView,msg);
        mMessage.setText(msg);
        return this;
    }
    /**
     * 设置对话框的提示信息文本颜色
     * @param colorString
     *          提示的文本颜色字符串,例如:"#ff225485"
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withMessageColor(String colorString) {
        mMessage.setTextColor(Color.parseColor(colorString));
        return this;
    }
    /**
     * 设置对话框的提示信息文本颜色
     * @param color
     *          提示的文本颜色值
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withMessageColor(int color) {
        mMessage.setTextColor(color);
        return this;
    }

    /**
     * 设置对话框的背景颜色
     * @param colorString
     *          提示的文本颜色字符串,例如:"#ff225485"
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withDialogColor(String colorString) {
        mLinearLayoutView.getBackground().setColorFilter(ColorUtils.getColorFilter(Color.parseColor(colorString)));
        return this;
    }
    /**
     * 设置对话框的背景颜色
     * @param color
     *          提示的文本颜色值
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withDialogColor(int color) {
        mLinearLayoutView.getBackground().setColorFilter(ColorUtils.getColorFilter(color));
        return this;
    }
    /**
     * 设置对话框的图标
     * @param drawableResId
     *          drawable资源id
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withIcon(int drawableResId) {
        mIcon.setImageResource(drawableResId);
        return this;
    }
    /**
     * 设置对话框的图标
     * @param icon
     *          drawable对象
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withIcon(Drawable icon) {
        mIcon.setImageDrawable(icon);
        return this;
    }
    /**
     * 设置对话框动画事件
     * @param duration
     *          动画时长
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withDuration(int duration) {
        this.mDuration=duration;
        return this;
    }
    /**
     * 设置对话框动画效果
     * @param type
     *          效果对象
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withEffect(Effectstype type) {
        this.type=type;
        return this;
    }
    /**
     * 设置对话框按钮的背景
     * @param resid
     *          资源id
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withButtonDrawable(int resid) {
        mPositiveButton.setBackgroundResource(resid);
        mNeutralButton.setBackgroundResource(resid);
        mNegativeButton.setBackgroundResource(resid);
        return this;
    }
    /**
     * 设置对话框左边按钮的文本内容
     * @param text
     *          字符串
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withPositiveButtonText(CharSequence text) {
        mPositiveButton.setVisibility(View.VISIBLE);
        mPositiveButton.setText(text);
        return this;
    }
    /**
     * 设置对话框中间按钮的文本内容
     * @param text
     *          字符串
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withNeutralButtonText(CharSequence text) {
        mNeutralButton.setVisibility(View.VISIBLE);
        mNeutralButton.setText(text);
        return this;
    }
    /**
     * 设置对话框右侧按钮的文本内容
     * @param text
     *          字符串
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder withNegativeButtonText(CharSequence text) {
        mNegativeButton.setVisibility(View.VISIBLE);
        mNegativeButton.setText(text);
        return this;
    }
    /**
     * 设置对话框左侧按钮的点击事件
     * @param click
     *          点击事件对象
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder setPositiveClick(View.OnClickListener click) {
        mPositiveButton.setOnClickListener(click);
        return this;
    }
    /**
     * 设置对话框中间按钮的点击事件
     * @param click
     *          点击事件对象
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder setNeutralClick(View.OnClickListener click) {
        mNeutralButton.setOnClickListener(click);
        return this;
    }
    /**
     * 设置对话框右侧按钮的点击事件
     * @param click
     *          点击事件对象
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder setNegativeClick(View.OnClickListener click) {
        mNegativeButton.setOnClickListener(click);
        return this;
    }

    /**
     * 设置对话框自定义内容
     * @param resId
     *          布局资源ID
     * @param context
     *          上下文对象
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder setCustomView(int resId, Context context) {
        View customView = View.inflate(context, resId, null);
        if (mFrameLayoutCustomView.getChildCount()>0){
            mFrameLayoutCustomView.removeAllViews();
        }
        mFrameLayoutCustomView.addView(customView);
        return this;
    }
    /**
     * 设置对话框自定义内容
     * @param view
     *          View对象
     * @param context
     *          上下文对象
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder setCustomView(View view, Context context) {
        if (mFrameLayoutCustomView.getChildCount()>0){
            mFrameLayoutCustomView.removeAllViews();
        }
        mFrameLayoutCustomView.addView(view);
        
        return this;
    }
    /**
     * 设置在对话框外边点击可否消失
     * @param cancelable
     *          是否消失
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder isCancelableOnTouchOutside(boolean cancelable) {
        this.isCancelable=cancelable;
        this.setCanceledOnTouchOutside(cancelable);
        return this;
    }
    /**
     * 设置在对话框外边可否取消
     * @param cancelable
     *          是否可以取消
     * @return ItskDialogBuilder
     *          自身builder对象
     * */
    public ItskDialogBuilder isCancelable(boolean cancelable) {
        this.isCancelable=cancelable;
        this.setCancelable(cancelable);
        return this;
    }
    
    private void toggleView(View view,Object obj){
        if (obj==null){
            view.setVisibility(View.GONE);
        }else {
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void show() {
        super.show();
    }
    
    private void start(Effectstype type){
        BaseEffects animator = type.getAnimator();
        if(mDuration != -1){
            animator.setDuration(Math.abs(mDuration));
        }
        animator.start(mRelativeLayoutView);
    }
    
    @Override
    public void dismiss() {
        super.dismiss();
        mPositiveButton.setVisibility(View.GONE);
        mNeutralButton.setVisibility(View.GONE);
        mNegativeButton.setVisibility(View.GONE);
    }
}
