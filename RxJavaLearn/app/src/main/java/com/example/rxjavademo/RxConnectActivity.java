package com.example.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;

public class RxConnectActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mText;
    private Button mBtn;
    private Button bntNormal;
    private TextView mEdit;
    private Subscription mSubscription = null;
    private Integer [] integer = {1,2,3,4,5,6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        initView();
    }

    private void initView() {
        mText= (TextView) findViewById(R.id.text1);
        mEdit= (TextView) findViewById(R.id.edit1);
        mBtn= (Button) findViewById(R.id.button);
        bntNormal= (Button) findViewById(R.id.button_cancel);
        mBtn.setText("正常情况下");

        bntNormal.setText("connect模式");

        mEdit.setText("Observable发送事件1-6，两个观察者同时观察这个Observable \n要求：" +
                "每发出一个事件，观察者A和观察者B都会收到，而不是先把所有的时间发送A,然后再发送给B  \n\n" );
        mBtn.setOnClickListener(this);
        mText.setOnClickListener(this);
        mEdit.setOnClickListener(this);
        bntNormal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text1:
            case R.id.edit1:
                break;
            case R.id.button:
                mText.setText("");
                normal();
                break;
            case R.id.button_cancel:
                mText.setText("");
                start();
                break;
        }
    }

    private void normal() {
        Observable observable = Observable.from(integer);
        Action1 a1 = new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                mText.append("观察者A 收到：" + o + "\n");
            }
        };
        Action1 a2 = new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                mText.append("观察者B 收到：" + o + "\n");
            }
        };
        observable.subscribe(a1);
        observable.subscribe(a2);
    }

    private void start() {
        ConnectableObservable observable = Observable.from(integer).publish();
        Action1 a1 = new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                mText.append("观察者A 收到： " + o + "\n");
            }
        };

        Action1 a2 = new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                mText.append("观察者B 收到： " + o + "\n");
            }
        };

        observable.subscribe(a1);
        observable.subscribe(a2);
        observable.connect();
    }
}