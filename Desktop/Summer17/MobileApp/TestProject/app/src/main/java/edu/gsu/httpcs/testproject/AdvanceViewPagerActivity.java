package edu.gsu.httpcs.testproject;

/**
 * Created by spri0 on 6/21/17.
 */
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.gsu.httpcs.testproject.adapter.ViewFragmentStateAdapter;
import edu.gsu.httpcs.testproject.fragment.BlueFragment;
import edu.gsu.httpcs.testproject.fragment.GreenFragment;
import edu.gsu.httpcs.testproject.fragment.RedFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvanceViewPagerActivity extends AppCompatActivity {

    private ArrayList<Pair<String, Fragment>> list = new ArrayList<Pair<String, Fragment>>();
    @BindView(R.id.activity_advance_view_pager_tablayout)
    TabLayout tabLayout;

    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_view_pager);
        ButterKnife.bind(this);
        list.add(new Pair<String, Fragment>("Red", new RedFragment()));
        list.add(new Pair<String, Fragment>("Green", new GreenFragment()));
        list.add(new Pair<String, Fragment>("Blue", new BlueFragment()));
        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}