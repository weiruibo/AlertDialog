package cn.edu.gdmec.w07150837.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog dialog;
    AlertDialog.Builder builder;
    TextView tv1;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        tv1 = (TextView) findViewById(R.id.textView1);
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        bt5 = (Button) findViewById(R.id.button5);
        bt6 = (Button) findViewById(R.id.button6);
        bt7 = (Button) findViewById(R.id.button7);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };

        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
        bt6.setOnClickListener(listener);
        bt7.setOnClickListener(listener);

    }

    public void dialog1() {

        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确认退出吗");
        dialog.setIcon(android.R.drawable.sym_def_app_icon);
        builder=new AlertDialog.Builder(this);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    finish();
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", listener);


        dialog.show();
    }

    public void dialog2() {

        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setIcon(android.R.drawable.alert_dark_frame);
        dialog.setMessage("你平时忙吗？");

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String str = "";

                switch (which) {

                    case DialogInterface.BUTTON_POSITIVE:
                        str = "平时很忙";
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "平时很闲";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "平时一般";
                        break;

                }
                tv1.setText(str);
            }
        };

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "很忙", listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "很闲", listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "一般", listener);
        dialog.show();

    }

    public void dialog3() {

        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.btn_default);
        final EditText et = new EditText(this);
        dialog.setView(et);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText(et.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", listener);
        dialog.show();
    }

    public void dialog4() {

        final String cityName[] = new String[]{"北京", "上海", "广州"};
        final boolean bselect[] = new boolean[cityName.length];

        DialogInterface.OnMultiChoiceClickListener mlistener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bselect[which] = isChecked;
                if(isChecked){
                    Toast.makeText(MainActivity.this,"你选择了"+cityName[which],Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"你取消了"+cityName[which],Toast.LENGTH_SHORT).show();
                }
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(cityName, null, mlistener);

        dialog = builder.create();
        dialog.setTitle("多选");

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:";
                for (int i = 0; i < bselect.length; i++) {
                    if (bselect[i]) {
                        str = str + "\n" + cityName[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", listener);
        dialog.show();

    }

    public void dialog5() {

        final String items[] = new String[]{"北京", "上海", "广州"};

        final boolean bSelect[] = new boolean[items.length];

        //监听单选列表
        DialogInterface.OnClickListener slistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                bSelect[which] = true;

            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(items, -1, slistener);

        builder.setTitle("单选按钮");

        //dialog = builder.create();

        //监听提示框的按钮
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:";
                for (int i = 0; i < bSelect.length; i++) {
                    if (bSelect[i]) {
                        str = str + "\n" + items[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", listener);
        dialog.show();
        //builder.setPositiveButton("确定",listener);
       // builder.create();
       // builder.show();

    }

    public void dialog6() {

        final String items[] = new String[]{"北京", "上海", "广州"};


        DialogInterface.OnClickListener slistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:" + items[which];
                tv1.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);

        builder.setItems(items, slistener);

        dialog = builder.create();
        dialog.setTitle("列表框");

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", listener);
        dialog.show();
    }

    public void dialog7() {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.diydialog, null);
        final EditText et = (EditText) layout.findViewById(R.id.editText1);
        dialog = new AlertDialog.Builder(this).create();

        dialog.setTitle("自定义布局");
        dialog.setView(layout);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是:" + et.getText().toString());

            }
        };

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", listener);
        dialog.show();

    }
}
