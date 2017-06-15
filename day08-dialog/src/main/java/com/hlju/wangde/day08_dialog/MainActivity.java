package com.hlju.wangde.day08_dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("警告对话框");
        builder.setMessage("警告警告警告");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("点击确定按钮");
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("点击取消按钮");
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog ad = builder.create();
        ad.show();
    }

    public void click2(View view) {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_dialer);
        builder.setTitle("单选对话框");
        final String[] items = new String[]{
                "地球", "火星", "土星", "木星"
        };
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void click3(View view) {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_dialer);
        builder.setTitle("选择需要的武器");
        final String[] items = new String[]{
                "搬砖", "板凳", "AK47", "沙漠之鹰", "爱国者导弹"
        };
        final boolean[] checkedItems = new boolean[]{
                false, false, false, false, false, false
        };
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //记录用户的选择
                checkedItems[which] = isChecked;

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = "";
                for (int i = 0; i < checkedItems.length; i++) {
                    text += checkedItems[i] ? items[i] + "," : "";
                }
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void click4(View view) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setIcon(android.R.drawable.ic_input_add);
        dialog.setTitle("读取中");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(100);
//        dialog.setProgress(50);
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    dialog.setProgress(i);
                    try {
                        sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
                super.run();
            }
        };
        thread.start();
        dialog.show();
    }
}
