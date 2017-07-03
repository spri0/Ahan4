package edu.gsu.httpcs.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.testproject.audio.BaseBean;

/**
 * Created by spri0 on 6/21/17.
 */

public class ActivityA extends BaseActivity{

    @BindView(R.id.letterViewA)
    TextView letterViewA;

    @OnClick(R.id.a_button_a)
    public void a_to_a(View v){
        Toast.makeText(this, "A to A",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityA.class);
    }

    @OnClick(R.id.a_button_b)
    public void a_to_b(View v){
        Toast.makeText(this, "A to B",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityB.class);
    }

    @OnClick(R.id.a_button_c)
    public void a_to_c(View v){
        Toast.makeText(this, "A to C",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityC.class);
    }

    @OnClick(R.id.a_button_d)
    public void a_to_d(View v){
        Toast.makeText(this, "A to C",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityD.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
//        Toast.makeText(this, "OnCreate",Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        String bs = bundle.getString("StringBundle");
        int bi = bundle.getInt("IntegerBundle",0);
        BaseBean bean = (BaseBean) bundle.getSerializable("Object");
        shortToast(bean.getName());
//        shortToast(bs);
//        shortToast("Integer is:"+bi);
//        String s = intent.getStringExtra("StringInfo");
//        int i = intent.getIntExtra("Integer",0);
//        shortToast(s);
//        shortToast(String.valueOf(i);
//        shortToast(i+"");
//        shortToast("Integer is:"+i);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }

}