package org.itsk.widgetdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.itsk.dialog.Effectstype;
import org.itsk.dialog.ItskDialogBuilder;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
//        FragmentTabHost host=new FragmentTabHost(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.fadein:
                showDialog(Effectstype.Fadein);
                break;
            case R.id.fall:
                showDialog(Effectstype.Fall);
                break;
            case R.id.flipH:
                showDialog(Effectstype.Fliph);
                break;
            case R.id.flipV:
                showDialog(Effectstype.Flipv);
                break;
            case R.id.newsPaper:
                showDialog(Effectstype.Newspager);
                break;
            case R.id.rotateBottom:
                showDialog(Effectstype.RotateBottom);
                break;
            case R.id.rotateLeft:
                showDialog(Effectstype.RotateLeft);
                break;
            case R.id.shake:
                showDialog(Effectstype.Shake);
                break;
            case R.id.slideBottom:
                showDialog(Effectstype.SlideBottom);
                break;
            case R.id.slideFall:
                showDialog(Effectstype.Sidefill);
                break;
            case R.id.slideLeft:
                showDialog(Effectstype.Slideleft);
                break;
            case R.id.slideRight:
                showDialog(Effectstype.Slideright);
                break;
            case R.id.slideTop:
                showDialog(Effectstype.Slidetop);
                break;
            case R.id.slit:
                showDialog(Effectstype.Slit);
                break;
        }
    }
    private void showDialog(Effectstype effectstype){
        final ItskDialogBuilder builder=ItskDialogBuilder.getInstance(this);
        builder.withTitle("Modal Dialog")                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                .withDialogColor("#3F51B5")                               //def  | withDialogColor(int resid)
                .withIcon(R.mipmap.ic_launcher)
                .withDuration(700)                                          //def
                .withEffect(effectstype)                          //def Effectstype.Slidetop
                .withPositiveButtonText("确定")
                .withNeutralButtonText("忽略")
                .withNegativeButtonText("取消")
                .setPositiveClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this, "确定按钮点击事件", Toast.LENGTH_SHORT).show();
                        builder.dismiss();
                    }
                })
                .setNeutralClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this, "忽略按钮点击事件", Toast.LENGTH_SHORT).show();
                        builder.dismiss();
                    }
                })
                .setNegativeClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this, "取消按钮点击事件", Toast.LENGTH_SHORT).show();
                        builder.dismiss();
                    }
                })
                .isCancelable(true).isCancelableOnTouchOutside(true).show();
    }
}
