package edu.gsu.httpcs.testproject;

/**
 * Created by spri0 on 6/21/17.
 */
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import edu.gsu.httpcs.testproject.adapter.BaseViewPagerAdapter;
import edu.gsu.httpcs.testproject.fragment.BlueFragment;
import edu.gsu.httpcs.testproject.fragment.GreenFragment;
import edu.gsu.httpcs.testproject.fragment.RedFragment;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","OnCreate");
        viewPager = (ViewPager) findViewById(R.id.activity_view_pager);
        list.add(new RedFragment());
        list.add(new GreenFragment());
        list.add(new BlueFragment());
        BaseViewPagerAdapter pagerAdapter =
                new BaseViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);
    }

    public ViewPagerActivity(){
        super();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","OnRestart");
    }
}
