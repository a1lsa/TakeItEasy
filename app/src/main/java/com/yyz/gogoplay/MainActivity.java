package com.yyz.gogoplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.yyz.gogoplay.adapter.MainPagerAdapter;
import com.yyz.gogoplay.view.MainView;
import com.yyz.gogoplay.view.impl.JokesFragment;
import com.yyz.gogoplay.view.impl.MovieFragment;
import com.yyz.gogoplay.view.impl.NewsFragment;
import com.yyz.gogoplay.view.impl.UserAccountActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements MainView {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    String[] titles = new String[]{"电影", "新闻", "段子"};
    @BindView(R.id.iv_user_icon)
    CircleImageView ivUserIcon;
    @BindView(R.id.tv_area)
    TextView tvArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutViewRes());
        ButterKnife.bind(this);
        initView();

        initEvent();
    }


    @Override
    public int getLayoutViewRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        addTabs();
        List<Fragment> fragList = new ArrayList<>();
        fragList.add(new MovieFragment());
        fragList.add(new NewsFragment());
        fragList.add(new JokesFragment());
        viewPager.setAdapter(new MainPagerAdapter(fragList, titles, getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void initEvent() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_card:

                        break;
                    case R.id.menu_account:
                        Intent intent=new Intent(MainActivity.this,UserAccountActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.menu_setting:
                        break;
                }
                return false;
            }
        });

    }

    @OnClick({R.id.iv_user_icon, R.id.tv_area})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_user_icon:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.tv_area:

                break;
        }
    }

    @Override
    public void addTabs(){
        for (int i = 0; i < titles.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            TextView tvTab = view.findViewById(R.id.tv_tab);
            tvTab.setText(titles[i]);
            TabLayout.Tab tab = tabLayout.newTab().setCustomView(view);
            tabLayout.addTab(tab);
        }
    }

}
