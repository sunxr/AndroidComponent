package com.example.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxSortActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mText;
    private Button mBtn;
    private Button mBtnCancel;
    private TextView mEdit;
    private Subscription mSubscription=null;
    private Integer [] words= {1,3,5,2,34,7,5,86,23,43};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        initView();
    }

    private void initView() {
        mText= (TextView) findViewById(R.id.text1);
        mEdit= (TextView) findViewById(R.id.edit1);
        mBtn= (Button) findViewById(R.id.button);
        mBtn.setText("开始排序");
//        mBtnCancel= (Button) findViewById(R.id.button_cancel);
        mEdit.setText("为给定数据列表排序：1,3,5,2,34,7,5,86,23,43   \n\ntoSortedList() :为事件中的数据排序" );
        mBtn.setOnClickListener(this);
        mText.setOnClickListener(this);
        mEdit.setOnClickListener(this);
//        mBtnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text1:
            case R.id.edit1:
                break;
            case R.id.button:
                start();
                break;
        }
    }

    private void start() {
        Observable.from(words)
                .toSortedList()
                .flatMap(new Func1<List<Integer>, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(List<Integer> integers) {
                        return Observable.from(integers);
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        mText.append(integer + "\n");
                    }
                });
    }
}