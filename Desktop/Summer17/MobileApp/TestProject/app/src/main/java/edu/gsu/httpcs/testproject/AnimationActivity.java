package edu.gsu.httpcs.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity{

    @BindView(R.id.activity_animation_tv)
    TextView textView;
    private Animation alphaAnimation;
    private Animation scaleAnimation;
    private Animation rotateAnimation;
    private Animation transAnimation;
    private Animation setAnimation;

    @OnClick(R.id.activity_animation_bt1)
    public void alpha(View view){
        textView.startAnimation(alphaAnimation);
    }
    @OnClick(R.id.activity_animation_bt2)
    public void scale(View view){
        textView.startAnimation(scaleAnimation);
    }
    @OnClick(R.id.activity_animation_bt3)
    public void rotate(View view){
        textView.startAnimation(rotateAnimation);
    }
    @OnClick(R.id.activity_animation_bt4)
    public void set(View view){
        textView.startAnimation(transAnimation);
    }
    @OnClick(R.id.activity_animation_bt5)
    public void trans(View view){
        textView.startAnimation(setAnimation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initialAnimation();
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                shortToast("click");
            }
        });
    }
    private void initialAnimation(){
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
        transAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);

    }
}
