package org.itsk.widgetdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.dialogDemo:
                startActivity(new Intent(this,DialogActivity.class));
                showToast("对话框效果预览");
                break;
            case R.id.naviViewDemo:
                startActivity(new Intent(this,BottomTabActivity.class));
                showToast("底部Tab演示");
                break;
        }
    }
}
