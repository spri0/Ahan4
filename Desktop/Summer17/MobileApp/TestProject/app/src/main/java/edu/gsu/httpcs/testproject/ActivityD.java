package edu.gsu.httpcs.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by spri0 on 6/21/17.
 */

public class ActivityD extends BaseActivity{

    @BindView(R.id.letterViewD)
    TextView letterViewD;

    @OnClick(R.id.d_button_a)
    public void d_to_a(View v){
        Toast.makeText(this, "C to A",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityA.class);
    }

    @OnClick(R.id.d_button_b)
    public void d_to_b(View v){
        Toast.makeText(this, "C to B",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityB.class);
    }

    @OnClick(R.id.d_button_c)
    public void d_to_c(View v){
        Toast.makeText(this, "C to C",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityC.class);
    }

    @OnClick(R.id.d_button_d)
    public void d_to_d(View v){
        Toast.makeText(this, "C to D",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityD.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        ButterKnife.bind(this);
    }
}