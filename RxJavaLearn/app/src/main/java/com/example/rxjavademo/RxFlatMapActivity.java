package com.example.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxFlatMapActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mText;
    private Button mBtn;
    private TextView mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        initView();
        initData();
    }

    private SchoolClass[] mSchoolClasses = new SchoolClass[2];

    public SchoolClass[] getSchoolClass(){
        return mSchoolClasses;
    }

    private void initData() {
        Student[] student = new Student[5];
        for(int i=0;i<5;i++){
            Student s = new Student("二狗"+i,"17");
            student[i] = s;
        }
        mSchoolClasses[0] = new SchoolClass(student);

        Student[] student2 = new Student[5];
        for(int i=0;i<5;i++){
            Student s = new Student("小明"+i,"27");
            student2[i] = s;
        }
        mSchoolClasses[1] = new SchoolClass(student2);
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text1);
        mEdit = (TextView) findViewById(R.id.edit1);
        mBtn = (Button) findViewById(R.id.button);

        mEdit.setText("打印一个学校所有班级所有学生姓名");
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
                if(mText.getText().toString().length() > 0){
                    mText.setText("");
                }
                start();
                break;
        }
    }

    private void start() {
        Observable.from(getSchoolClass())
                .flatMap(new Func1<SchoolClass, Observable<Student>>() {
                    @Override
                    public Observable<Student> call(SchoolClass schoolClass) {
                        return Observable.from(schoolClass.getStud());
                    }
                })
                .subscribe(new Action1<Student>() {
                    @Override
                    public void call(Student student) {
                        mText.append("打印单个学生信息：\n");
                        mText.append("name: " + student.name + "   age: " + student.age + "\n");
                    }
                });
    }
}

class SchoolClass {
    Student[] stud;

    public SchoolClass(Student[] stud) {
        this.stud = stud;
    }

    public Student[] getStud() {
        return stud;
    }
}

class Student {
    String name;
    String age;
    public Student(String name, String age) {
        this.age = age;
        this.name = name;
    }
}