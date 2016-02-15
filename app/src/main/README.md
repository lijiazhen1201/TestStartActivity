# TestStartActivity

## Activity之间的跳转

1. startActivity


	    private void startNextActivity() {
	        //显式intent
	        Intent intent = new Intent(this, StartActivity.class);
	        startActivity(intent);
	    }
	    
携带数据跳转

	    private void startNextActivity(String msg) {
	        //显式intent
	        Intent intent = new Intent(this, StartActivity.class);
	        intent.putExtra("msg", msg);
	        startActivity(intent);
	    }
	    
接受数据

			Intent intent = getIntent();
	        String msg = intent.getStringExtra("msg");
	        if (!TextUtils.isEmpty(msg)) {
	            tvStart.setText(msg);
	        }
	        
Intent的隐式用法

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


2. startActivityForResult

	    //请求码
	    private int requestCode = 0;
	
	    private void startResultActivity() {
	        Intent intent = new Intent(this, ResultActivity.class);
	        startActivityForResult(intent, requestCode);
	    }

在要获得结果的Activity中设置结果

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
        
返回之前的Activity重写onActivityResult方法用来接收结果

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
