package com.example.teststartactivity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.teststartactivity.R;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
    }

    private TextView tvStart;
    private Button btnStart;

    private void initView() {
        tvStart = (TextView) findViewById(R.id.tv_start);
        btnStart = (Button) findViewById(R.id.btn_start);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        if (!TextUtils.isEmpty(msg)) {
            tvStart.setText(msg);
        }

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式intent
                Intent intent = new Intent();
                intent.setAction("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                startActivity(intent);
            }
        });
    }

}
