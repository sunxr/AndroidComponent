package com.example.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxTakeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mText;
    private Button mBtn;
    private TextView mEdit;
    private Integer [] number = {1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        initView();
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text1);
        mEdit = (TextView) findViewById(R.id.edit1);
        mBtn = (Button) findViewById(R.id.button);

        mEdit.setText("输出[1,2,3,4,5,6,7,8,9,10]中第三个和第四个奇数，\n\ntake(i) 取前i个事件 \ntakeLast(i) 取后i个事件 \ndoOnNext(Action1) 每次观察者中的onNext调用之前调用");
        mBtn.setOnClickListener(this);
        mText.setOnClickListener(this);
        mEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text1:
            case R.id.edit1:
                break;
            case R.id.button:
                if(mText.getText().toString() != null || mText.getText().toString().length() > 0){
                    mText.setText("");
                }
                start();
                break;
        }
    }

    private void start() {
        Observable.from(number)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer % 2 != 0;
                    }
                })
                //取前4个
                .take(4)
                //取前4个中的后2个
                .takeLast(2)
                .doOnNext(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        mText.append("before onNext() \n");
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        mText.append("onNext()--->" + integer + "\n");
                    }
                });
    }
}