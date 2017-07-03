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

public class ActivityB extends BaseActivity{

    @BindView(R.id.letterViewB)
    TextView letterViewB;

    @OnClick(R.id.b_button_a)
    public void b_to_a(View v){
        Toast.makeText(this, "B to A",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityA.class);
    }

    @OnClick(R.id.b_button_b)
    public void b_to_b(View v){
        Toast.makeText(this, "B to B",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityB.class);
    }

    @OnClick(R.id.b_button_c)
    public void b_to_c(View v){
        Toast.makeText(this, "B to C",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityC.class);
    }

    @OnClick(R.id.b_button_d)
    public void b_to_d(View v){
        Toast.makeText(this, "B to D",Toast.LENGTH_SHORT).show();
        goToActivity(ActivityD.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
    }
}
