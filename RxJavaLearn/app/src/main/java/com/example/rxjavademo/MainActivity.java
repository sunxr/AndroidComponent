package com.example.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(MainActivity.this, NormalRxActivity.class);
                break;
            case R.id.button2:
                intent = new Intent(MainActivity.this,RxMapActivity.class);
                break;
            case R.id.button3:
                intent = new Intent(MainActivity.this,RxSchedulerActivity.class);
                break;
            case R.id.button4:
                intent = new Intent(MainActivity.this,RxFlatMapActivity.class);
                break;
            case R.id.button5:
                intent = new Intent(MainActivity.this,RxMergeActivity.class);
                break;
            case R.id.button6:
                intent = new Intent(MainActivity.this,RxBindingActivity.class);
                break;
            case R.id.button7:
                intent = new Intent(MainActivity.this,RxFilterActivity.class);
                break;
            case R.id.button8:
                intent = new Intent(MainActivity.this,RxTakeActivity.class);
                break;
            case R.id.button9:
                intent = new Intent(MainActivity.this,RxTimerActivity.class);
                break;
            case R.id.button10:
                intent = new Intent(MainActivity.this,RxSortActivity.class);
                break;
            case R.id.button11:
                intent = new Intent(MainActivity.this,RxConnectActivity.class);
                break;
        }
        startActivity(intent);
    }

    private void initView() {

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);

    }
}