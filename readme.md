# WidgetDemo
一些自定义组件的演示项目

#ItskDialog对话框使用
1. 下载
        maven:

        <dependency>
          <groupId>org.itsk.widget</groupId>
          <artifactId>effectdialog</artifactId>
          <version>0.2</version>
          <type>pom</type>
        </dependency>

        Gradle:

        compile 'org.itsk.widget:effectdialog:0.2'


2. 代码
		
		final ItskDialogBuilder builder=ItskDialogBuilder.getInstance(this);
        builder.withTitle("Itsk Dialog")    					//设置对话框标题,如果不需要可以使用.withTitle(null)
                .withTitleColor("#FFFFFF")      				//设置对话框标题文本颜色
                .withDividerColor("#11000000")  				//设置对话框分割线颜色
                .withMessage("This is a modal Dialog.") 		//设置对话框提示信息,如果使用.withMessage(null)则没有标题
                .withMessageColor("#FFFFFFFF")          		//设置提示信息文本颜色或使用方法withMessageColor(int resid)
                .withDialogColor("#3F51B5")             		//设置对话框背景颜色或使用方法withDialogColor(int resid)
                .withIcon(R.mipmap.ic_launcher)					//设置对话框图标
                .withDuration(700)                      		//设置动画时长
                .withEffect(effectstype)                		//设置动画类型,例如:Effectstype.Slidetop
                .withPositiveButtonText("确定")					//设置左侧按钮文本
                .withNeutralButtonText("忽略")					//设置中间按钮文本
                .withNegativeButtonText("取消")					//设置右侧按钮文本
                .setPositiveClick(new View.OnClickListener() { 	//设置左侧按钮点击事件
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this, "确定按钮点击事件", Toast.LENGTH_SHORT).show();
                        builder.dismiss();
                    }
                })
                .setNeutralClick(new View.OnClickListener() {	//设置中间按钮点击事件
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this, "忽略按钮点击事件", Toast.LENGTH_SHORT).show();
                        builder.dismiss();
                    }
                })
                .setNegativeClick(new View.OnClickListener() {	//设置右侧按钮点击事件
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this, "取消按钮点击事件", Toast.LENGTH_SHORT).show();
                        builder.dismiss();
                    }
                })
                .isCancelable(true).isCancelableOnTouchOutside(true).show();

3. 效果图
	
	具体的请允许演示项目查看
	
#BottomTab使用
1. 下载
        maven:

        <dependency>
          <groupId>org.itsk.widget</groupId>
          <artifactId>bottomtab</artifactId>
          <version>0.2</version>
          <type>pom</type>
        </dependency>

        Gradle:

        compile 'org.itsk.widget:bottomtab:0.2'

2. layout布局文件

		<?xml version="1.0" encoding="utf-8"?>
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
		    android:layout_width="match_parent"
		    android:layout_height="match_parent">
		
		    <TextView
		        android:id="@+id/textView1"
		        android:layout_width="wrap_content"
		        android:layout_height="wrap_content"
		        android:text="bottomNaviView演示"
		        android:textSize="20sp"
		        android:layout_centerInParent="true"/>
		
		    <TextView
		        android:id="@+id/text2"
		        android:layout_width="wrap_content"
		        android:layout_height="wrap_content"
		        android:text="当前是第1个页面"
		        android:textSize="18sp"
		        android:layout_marginTop="20dp"
		        android:layout_below="@id/textView1"
		        android:layout_centerHorizontal="true"/>
		
		
		    <org.itsk.bottomtab.BottomTab
		        android:id="@+id/navi"
		        android:layout_width="match_parent"
		        android:layout_height="wrap_content"
		        android:layout_alignParentBottom="true">
		
		    </org.itsk.bottomtab.BottomTab>
		
		</RelativeLayout>

3. Activity中的代码

		
		textView= (TextView) findViewById(R.id.text2);
		nav= (BottomTab) findViewById(R.id.navi);
		//创建导航条上的按钮
		LinkedHashMap<String,int[][]> map=new LinkedHashMap<String,int[][]>();
		map.put("主页", new int[][]{new int[]{R.mipmap.classify_tab, R.mipmap.classify_tab2}, new int[]{Color.parseColor("#24ACBD"), Color.parseColor("#00C12A")}});
		map.put("消息", new int[][]{new int[]{R.mipmap.msg_tab, R.mipmap.msg_tab2}, new int[]{Color.parseColor("#24ACBD"), Color.parseColor("#00C12A")}});
		map.put("医生", new int[][]{new int[]{R.mipmap.doctor, R.mipmap.doctor2}, new int[]{Color.parseColor("#24ACBD"), Color.parseColor("#00C12A")}});
		map.put("我的", new int[][]{new int[]{R.mipmap.person_tab3, R.mipmap.person_tab4}, new int[]{Color.parseColor("#24ACBD"), Color.parseColor("#00C12A")}});
		//把LinkedHashMap设置到BottomTab中
		nav.setButtons(map);
		//设置导航按钮的文本大小
		nav.setTextSize(15.0f);
		//设置导航条上方的分割线颜色
		nav.setDivideColor(Color.parseColor("#5AA0FA"));
		//设置默认选中第几个按钮
		nav.setDefItem(3);
		//设置选中被改变的监听器
		nav.setOnCheckedChangeListener(new BottomTab.OnCheckedChangeListener() {
		     @Override
		     public void OnCheckedChanged(BottomTab.ButtonView view, int index) {
		        selectPage(index);
		     }
		});

4. 效果图

	![](http://i.imgur.com/nqVNUlz.png)


#XToast使用
1. 下载
        maven:

        <dependency>
          <groupId>org.itsk.widget</groupId>
          <artifactId>xtoast</artifactId>
          <version>0.2</version>
          <type>pom</type>
        </dependency>

        Gradle:

        compile 'org.itsk.widget:xtoast:0.2'


2. Activity代码

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
            
            /**
                 * 弹出Toast
                 * @param text
                 * @param animType 动画类型 {@link org.itsk.xtoast.XToast.Animations}
                 * @param duration 显示时长 {@link org.itsk.xtoast.XToast.Duration}
                 * @param background Toast的背景 {@link org.itsk.xtoast.XToast.Background}
                 * @param textSize 文字大小 sp
                 * @param isShowIcon 是否显示图标
                 * @param icon 图标资源Bitmap
                 * @param iconPosition 图标显示的位置 {@link org.itsk.xtoast.XToast.IconPosition}
                 * */
                protected void showToast(String text,XToast.Animations animType, int duration, int background, int textSize,
                                         boolean isShowIcon, Bitmap icon, XToast.IconPosition iconPosition){
                        XToast superToast = new XToast(this);
                        superToast.setAnimations(animType);
                        switch (duration) {
                            case 0:
                                superToast.setDuration(XToast.Duration.SHORT);
                                break;
                            case 1:
                                superToast.setDuration(XToast.Duration.MEDIUM);
                                break;
                            case 2:
                                superToast.setDuration(XToast.Duration.LONG);
                                break;
                        }
            
                        switch (background) {
                            case 0:
                                superToast.setBackground(XToast.Background.BLACK);
                                break;
                            case 1:
                                superToast.setBackground(XToast.Background.GRAY);
                                break;
                            case 2:
                                superToast.setBackground(XToast.Background.GREEN);
                                break;
                            case 3:
                                superToast.setBackground(XToast.Background.BLUE);
                                break;
                            case 4:
                                superToast.setBackground(XToast.Background.RED);
                                break;
                            case 5:
                                superToast.setBackground(XToast.Background.PURPLE);
                                break;
                            case 6:
                                superToast.setBackground(XToast.Background.ORANGE);
                                break;
                        }
            
                        switch (textSize) {
                            case 0:
                                superToast.setTextSize(XToast.TextSize.SMALL);
                                break;
                            case 1:
                                superToast.setTextSize(XToast.TextSize.MEDIUM);
                                break;
                            case 2:
                                superToast.setTextSize(XToast.TextSize.LARGE);
                                break;
                        }
            
                        if(isShowIcon) {
                            superToast.setIcon(icon, iconPosition);
                        }
                        superToast.setText(text);
                        superToast.show();
                }
            protected void showToast(String text){
                    showToast(text, XToast.Animations.FLYIN, XToast.Duration.VERY_SHORT,3,15,false,null, XToast.IconPosition.LEFT);
                }

3. 效果图
    效果图请看演示项目