package com.leotech.activity;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;

import com.blutest.ly.ExApplication;
import com.blutest.ly.R;
import com.blutest.ly.util.ExProperties;

import java.util.List;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    private TextView gpsData;
    private LocationManager locMgr;
    ExApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 检查配置文件
        Properties prop = ExProperties.loadConfig(this, "config.property");
//        if (prop == null) {
//            //配置文件不存在，转入到配置窗口
//            Intent intent = new Intent(this, VoltSetActivity.class);
//            startActivity(intent);
//            return;
//        }
//        app = (ExApplication) getApplication();
//        app.setProp(prop);
        //gpsData = (TextView) findViewById(R.id.te);
        locMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //List<String> providers = locMgr.getProviders()
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "onDestroy");
    }

    //打开一个数据视图，但是没有要求，系统会默认让你从多个中选择其中一个打开
    public void action(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        startActivity(intent);
    }

    //打开一个数据视图，有数据要求，系统帮你打开一个浏览器，并连接到相关的页面
    public void actionUri(View v) {
        Intent intent = new Intent();
        //设置Data数据
        intent.setData(Uri.parse("tel:13814236512"));
        //设置Action数据
        intent.setAction(Intent.ACTION_DIAL);
        //页面跳转
        startActivity(intent);
    }

    //使用显示跳转的方法跳转到第二个页面
    public void ToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    //这里只用自己定义的Action字符串来找到对应的页面
    public void MyAction(View v) {
        Intent intent = new Intent("HelloWorld");//Action字符串可以直接放在Intent的构造函数里面，也可以单独写
        // intent.setAction("HelloWorld");
        intent.addCategory("android.intent.category.DEFAULT");//可以没有
        //但是自定义的Action的xml文件里面必须要有category元素，否则会报错
        startActivity(intent);
    }

    //打开程序入口，特征是桌面
    public void actionMain(View v) {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "找不到目标页面", Toast.LENGTH_SHORT).show();
        }

    }
}
