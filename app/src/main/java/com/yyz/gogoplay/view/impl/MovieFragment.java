package com.yyz.gogoplay.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yyz.gogoplay.R;
import com.yyz.gogoplay.adapter.MovieRecycleAdapter;
import com.yyz.gogoplay.widget.TopScrollview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yyz on 2017/12/25.
 */

public class MovieFragment extends Fragment {
    private String Tag="MovieFragment.class";
    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.ll_type)
    LinearLayout llType;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.scrollView)
    TopScrollview scrollView;
    Unbinder unbinder;

    List<String> mListData;
    @BindView(R.id.ll_type_hint)
    LinearLayout llTypeHint;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, null);
        unbinder = ButterKnife.bind(this, view);

        initView();
        initEvent();
        return view;
    }

    private void initView() {
        mListData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mListData.add("电影" + (i + 1));
        }
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(new MovieRecycleAdapter(mListData, getContext()));
        scrollView.smoothScrollTo(0,20);
        llTypeHint.setVisibility(View.GONE);
    }

    private void initEvent() {
        scrollView.setScrollListener(new TopScrollview.ScrollListener() {
            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
//                Log.e(Tag,"l="+l+",t"+t+",oldl="+oldl+",oldt="+oldt);
                 int height = ivPic.getHeight();
                int height2 = llType.getHeight();

                if (t-oldt>0){
                    if (t>=height && oldt!=0) {
                        llTypeHint.setVisibility(View.VISIBLE);
                    }
                } else if (t<=height+height2){
                    llTypeHint.setVisibility(View.GONE);
                }

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.iv_pic)
    public void onViewClicked() {
    }


}
