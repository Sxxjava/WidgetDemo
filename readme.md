# WidgetDemo
一些自定义组件的演示项目

#ItskDialog对话框使用
1. 代码
		
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

2. 效果图
	
	具体的请允许演示项目查看
	
#BottomTab使用
1. layout布局文件

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

2. Activity中的代码

		
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

3. 效果图

	![](http://i.imgur.com/nqVNUlz.png)
    