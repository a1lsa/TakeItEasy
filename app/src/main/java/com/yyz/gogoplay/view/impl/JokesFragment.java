package com.yyz.gogoplay.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yyz.gogoplay.R;
import com.yyz.gogoplay.base.BaseFragment;

/**
 * Created by yyz on 2017/12/25.
 */

public class JokesFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jokes, null);
        return view;
    }
}
