package com.example.teststartactivity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.teststartactivity.R;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private TextView tvMain;
    private Button btnStartActivity;
    private Button btnResultActivity;

    private void initView() {
        tvMain = (TextView) findViewById(R.id.tv_main);
        btnStartActivity = (Button) findViewById(R.id.btn_start_activity);
        btnResultActivity = (Button) findViewById(R.id.btn_result_activity);

        btnStartActivity.setOnClickListener(this);
        btnResultActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_activity:
//                startNextActivity();
                startNextActivity("MainActivity传递的数据");
                break;
            case R.id.btn_result_activity:
                startResultActivity();
                break;
            default:
                break;
        }
    }

    private void startNextActivity() {
        //显式intent
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    private void startNextActivity(String msg) {
        //显式intent
        Intent intent = new Intent(this, StartActivity.class);
        intent.putExtra("msg", msg);
        startActivity(intent);
    }

    //请求码
    private int requestCode = 0;

    private void startResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivityForResult(intent, requestCode);
    }

    //获取的结果会返回到onActivityResult方法中
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //根据发出的请求码分发事件
        switch (requestCode) {
            case 0:
                //如果请求码和结果码都相同，说明是刚刚发出的那次请求
                if (resultCode == RESULT_OK) {
                    String result = data.getStringExtra("result");
                    tvMain.setText(result);
                }
                break;
            default:
                break;
        }
    }
}
