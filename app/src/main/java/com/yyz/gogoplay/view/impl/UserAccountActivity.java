package com.yyz.gogoplay.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yyz.gogoplay.R;
import com.yyz.gogoplay.widget.YbpView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAccountActivity extends AppCompatActivity {

    @BindView(R.id.ybp)
    YbpView ybp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        ButterKnife.bind(this);
//        ybp.startAnim();
    }
}
