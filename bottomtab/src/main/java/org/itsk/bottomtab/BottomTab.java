package org.itsk.bottomtab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Jour on 2015/12/25.
 */
public class BottomTab extends LinearLayout implements View.OnClickListener {
    /**
     * 全局的Context对象
     */
    private Context mContext;
    /**
     * 这是要显示的自View的个数
     */
    private ArrayList<ButtonView> mButtons = new ArrayList<>();
    /**
     * 是否画分割线
     */
    private boolean isDrawDivider;
    /**
     * 分割线
     */
    private View dividerView;
    /**
     * 分割线颜色
     */
    private int divideColor;
    /**
     * 当前选中项
     */
    private int currentItem = 0;
    /**默认选中项*/
    private int defItem=0;
    /**
     * 分割线高度
     */
    private int dividerHeight = 1;
    /**
     * 默认分割线颜色
     */
    private String defDividerColor = "#00000000";
    /**
     * 用来放Button的Layout
     */
    private LinearLayout buttonLayout;
    /**
     * 选中改变监听器
     */
    private OnCheckedChangeListener checkedChangeListener;

    public BottomTab(Context context) {
        this(context, null);
    }

    public BottomTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        //设置自身的方向
        setOrientation(VERTICAL);
        //创建分割线
        dividerView = new View(context);
        dividerView.setBackgroundColor(Color.parseColor(defDividerColor));
        LayoutParams dividerParams = new LayoutParams(LayoutParams.MATCH_PARENT, dividerHeight);
        addView(dividerView, dividerParams);
        //创建存放Button的布局
        buttonLayout = new LinearLayout(context);
        LayoutParams buttonLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(buttonLayout, buttonLayoutParams);
    }

    /**
     * 设置按钮
     *
     * @param buttons 传入HashMap集合,Key:按钮文本,value为二维数组,第一是图片的数组,第二是文本颜色数组
     */
    public void setButtons(LinkedHashMap<String, int[][]> buttons) {
        //取出按钮信息
        for (Iterator<Map.Entry<String,int[][]>> it=buttons.entrySet().iterator();it.hasNext();){
            Map.Entry<String,int[][]> entry=it.next();
            //按钮图片及文本颜色数组
            int[][] drawables = entry.getValue();
            Drawable[] drawable = new Drawable[2];
            drawable[0] = mContext.getResources().getDrawable(drawables[0][0]);
            drawable[1] = mContext.getResources().getDrawable(drawables[0][1]);
            ButtonView buttonView = new ButtonView(entry.getKey(), drawables[1], drawable);
            mButtons.add(buttonView);
            buttonLayout.addView(buttonView.getButtonView(),new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f));
        }
        mButtons.get(defItem).setChecked(true);
    }

    /**
     * 设置按钮
     * @param  text
     *          按钮文本
     * @param  colors
     *          按钮文本颜色
     * @param  imageRes
     *          图片资源数组
     */
    public void setButtons(String[] text,int[][] colors,int[][] imageRes) {
        for (int i=0;i<text.length;i++){
            Drawable[] drawable = new Drawable[2];
            drawable[0] = mContext.getResources().getDrawable(imageRes[i][0]);
            drawable[1] = mContext.getResources().getDrawable(imageRes[i][1]);
            ButtonView buttonView = new ButtonView(text[i], colors[i], drawable);
            mButtons.add(buttonView);
            buttonLayout.addView(buttonView.getButtonView(),new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f));
        }
        mButtons.get(defItem).setChecked(true);
    }

    /**
     * 设置按钮
     * @param  text
     *          按钮文本
     * @param  colors
     *          按钮文本颜色
     * @param  imageRes
     *          图片资源数组
     */
    public void setButtons(String[] text,int[] colors,int[][] imageRes) {
        for (int i=0;i<text.length;i++){
            Drawable[] drawable = new Drawable[2];
            drawable[0] = mContext.getResources().getDrawable(imageRes[i][0]);
            drawable[1] = mContext.getResources().getDrawable(imageRes[i][1]);
            ButtonView buttonView = new ButtonView(text[i], colors, drawable);
            mButtons.add(buttonView);
            buttonLayout.addView(buttonView.getButtonView(),new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f));
        }
        mButtons.get(defItem).setChecked(true);
    }

    /**
     * 设置按钮
     * @param  text
     *          按钮文本
     * @param  colors
     *          按钮文本颜色
     * @param  imageRes
     *          图片资源数组
     */
    public void setButtons(String[] text,int[] colors,int[] imageRes) {
        for (int i=0;i<text.length;i++){
            Drawable[] drawable = new Drawable[2];
            drawable[0] = mContext.getResources().getDrawable(imageRes[0]);
            drawable[1] = mContext.getResources().getDrawable(imageRes[1]);
            ButtonView buttonView = new ButtonView(text[i], colors, drawable);
            mButtons.add(buttonView);
            buttonLayout.addView(buttonView.getButtonView(),new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f));
        }
        mButtons.get(defItem).setChecked(true);
    }

    /**
     * 设置按钮
     * @param  text
     *          按钮文本
     * @param  colors
     *          按钮文本颜色
     * @param  bitMaps
     *          图片资源数组
     */
    public void setButtons(String[] text,int[][] colors,Bitmap[][] bitMaps) {
        for (int i=0;i<text.length;i++){
            Drawable[] drawables=new Drawable[2];
            drawables[0]=new BitmapDrawable(bitMaps[i][0]);
            drawables[1]=new BitmapDrawable(bitMaps[i][1]);
            ButtonView buttonView = new ButtonView(text[i], colors[i], drawables);
            mButtons.add(buttonView);
            buttonLayout.addView(buttonView.getButtonView(),new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f));
        }
        mButtons.get(defItem).setChecked(true);
    }
    /**
     * 设置默认的选中项
     * @param defItem 默认选中项
     * */
    public void setDefItem(int defItem) {
        this.defItem = defItem;
        currentItem=defItem;
        if (mButtons!=null && mButtons.size()>defItem){
            for (ButtonView buttonView:mButtons){
                if (mButtons.indexOf(buttonView)==defItem){
                    buttonView.setChecked(true);
                    if (checkedChangeListener!=null)
                        checkedChangeListener.OnCheckedChanged(buttonView,defItem);
                }else{
                    buttonView.setChecked(false);
                }
            }
        }
    }
    /**
     * 设置分割线的高度
     * @param dividerHeight 分割线高度
     * */
    public void setDividerHeight(int dividerHeight) {
        this.dividerHeight = dividerHeight;
        dividerView.getLayoutParams().height=dividerHeight;
    }
    /**
     * 设置分割线的颜色
     * @param divideColor 分割线颜色
     * */
    public void setDivideColor(int divideColor) {
        this.divideColor = divideColor;
        dividerView.setBackgroundColor(divideColor);
        if (divideColor == Color.parseColor("#00000000")) {
            setIsDrawDivider(false);
            dividerView.setVisibility(View.GONE);
        } else {
            setIsDrawDivider(true);
            dividerView.setVisibility(View.VISIBLE);
        }
    }
    /**
     * 设置是否显示分割线
     * @param  isDrawDivider 是否画分割线
     * */
    public void setIsDrawDivider(boolean isDrawDivider) {
        this.isDrawDivider = isDrawDivider;
        if (!isDrawDivider)
            dividerView.setVisibility(View.GONE);
        else
            dividerView.setVisibility(View.VISIBLE);
    }
    /**
     * 设置按钮的字体大小,单位是SP
     * @param textSize 文字大小
     * */
    public void setTextSize(float textSize){
        for (ButtonView buttonView:mButtons)
            buttonView.setTextSize(textSize);
    }
    @Override
    public void onClick(View view) {
        for (ButtonView buttonView:mButtons){
            if(buttonView.getButtonView().equals(view)){
                //已经选中
                currentItem=mButtons.indexOf(buttonView);
                buttonView.setChecked(true);
                if (checkedChangeListener!=null)
                    checkedChangeListener.OnCheckedChanged(buttonView,currentItem);
            }else{
                buttonView.setChecked(false);
            }
        }
    }
    /**
     * 设置选中项被改变的事件
     * @param checkedChangeListener 选中项被改变的监听器
     * */
    public void setOnCheckedChangeListener(OnCheckedChangeListener checkedChangeListener) {
        this.checkedChangeListener = checkedChangeListener;
        checkedChangeListener.OnCheckedChanged(mButtons.get(currentItem),currentItem);
    }

    public interface OnCheckedChangeListener{
        void OnCheckedChanged(ButtonView view, int index);
    }
    public class ButtonView {
        //文本颜色
        private int[] colors;
        //默认文本大小
        private float textSize = 15.0f;
        //图片数组
        private Drawable[] drawables;
        //显示按钮文本的TextVIew
        private TextView textView;
        //显示按钮图片的ImageView
        private ImageView image;
        //ButtonView
        private LinearLayout buttonView;

        public ButtonView(String text, int[] colors, Drawable[] drawables) {
            this.colors = colors;
            this.drawables = drawables;
            //创建ButtonView
            buttonView = new LinearLayout(mContext);
            //设置ButtonView 的方向
            buttonView.setOrientation(VERTICAL);
            buttonView.setGravity(Gravity.CENTER_HORIZONTAL);
            //创建TextView
            textView = new TextView(mContext);
            //创建ImageView
            image = new ImageView(mContext);
            //设置图片缩放模式
            image.setScaleType(ImageView.ScaleType.CENTER);
            //设置图片资源
            image.setImageDrawable(drawables[0]);
            //创建布局参数
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            //将图片添加到ButtonView
            buttonView.addView(image, params);
            //设置按钮文本
            textView.setText(text);
            //设置按钮文本颜色
            textView.setTextColor(colors[0]);
            //设置按钮文本大小
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            //将TextVIew添加到ButtonView
            buttonView.addView(textView, params);
            buttonView.setOnClickListener(BottomTab.this);
        }
        public int[] getColors() {
            return colors;
        }

        public void setColors(int[] colors) {
            this.colors = colors;
        }

        public float getTextSize() {
            return textSize;
        }

        public void setTextSize(float textSize) {
            this.textSize = textSize;
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        }

        public Drawable[] getDrawables() {
            return drawables;
        }

        public void setDrawables(Drawable[] drawables) {
            this.drawables = drawables;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public ImageView getImage() {
            return image;
        }

        public void setImage(ImageView image) {
            this.image = image;
        }

        public LinearLayout getButtonView() {
            return buttonView;
        }

        public void setButtonView(LinearLayout buttonView) {
            this.buttonView = buttonView;
        }
        public void setChecked(boolean isCheck){
            if (isCheck){
                image.setImageDrawable(drawables[1]);
                textView.setTextColor(colors[1]);
            }else{
                image.setImageDrawable(drawables[0]);
                textView.setTextColor(colors[0]);
            }
        }
    }
}
