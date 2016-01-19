package org.itsk.widgetdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.itsk.bottomtab.BottomTab;

import java.util.LinkedHashMap;

public class BottomTabActivity extends AppCompatActivity {

    private BottomTab nav;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomtab);
        textView= (TextView) findViewById(R.id.text2);
        nav= (BottomTab) findViewById(R.id.navi);
        LinkedHashMap<String,int[][]> map=new LinkedHashMap<String,int[][]>();
        map.put("主页", new int[][]{new int[]{R.mipmap.classify_tab, R.mipmap.classify_tab2}, new int[]{Color.parseColor("#24ACBD"), Color.parseColor("#00C12A")}});
        map.put("消息", new int[][]{new int[]{R.mipmap.msg_tab, R.mipmap.msg_tab2}, new int[]{Color.parseColor("#24ACBD"), Color.parseColor("#00C12A")}});
        map.put("医生", new int[][]{new int[]{R.mipmap.doctor, R.mipmap.doctor2}, new int[]{Color.parseColor("#24ACBD"), Color.parseColor("#00C12A")}});
        map.put("我的", new int[][]{new int[]{R.mipmap.person_tab3, R.mipmap.person_tab4}, new int[]{Color.parseColor("#24ACBD"), Color.parseColor("#00C12A")}});
        nav.setButtons(map);
        nav.setTextSize(15.0f);
        nav.setDivideColor(Color.parseColor("#5AA0FA"));
        nav.setDefItem(3);
        nav.setOnCheckedChangeListener(new BottomTab.OnCheckedChangeListener() {
            @Override
            public void OnCheckedChanged(BottomTab.ButtonView view, int index) {
                selectPage(index);
            }
        });
    }

    private void selectPage(int index) {
        textView.setText("当前是第"+(index+1)+"个页面");
    }
}
