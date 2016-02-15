package com.example.teststartactivity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teststartactivity.R;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initView();
    }

    private EditText etResult;
    private Button btnResult;

    private void initView() {
        etResult = (EditText) findViewById(R.id.et_result);
        btnResult = (Button) findViewById(R.id.btn_result);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", etResult.getText().toString());
                //设置结果，RESULT_OK为结果码
                setResult(RESULT_OK,intent);
                //必须结束当前Activity
                finish();
            }
        });
    }

}
