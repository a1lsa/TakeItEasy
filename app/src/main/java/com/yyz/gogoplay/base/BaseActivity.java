package com.yyz.gogoplay.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yyz.gogoplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @BindView(R.id.toolbar_left_icon)
    ImageView toolbarLeftIcon;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_right_icon)
    TextView toolbarRightIcon;
    @BindView(R.id.toolbar)
    Toolbar baseToolbar;
    @BindView(R.id.base_layout)
    LinearLayout baseLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);

        initLayout();
        initView();
        initEvent();
    }

    private void initLayout() {
        setSupportActionBar(baseToolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        View contentView = getLayoutInflater().inflate(getLayoutViewRes(), baseLayout, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        baseLayout.addView(contentView,params);
    }


}
