package edu.gsu.httpcs.testproject;

/**
 * Created by spri0 on 6/21/17.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NinePatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_patch);
        Toast.makeText(this, "OnCreate",Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);
    }
}