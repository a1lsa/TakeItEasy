package com.yyz.gogoplay.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by yyz on 2017/12/25.
 */

public class TopScrollview extends ScrollView {
    private ScrollListener listener;

    public TopScrollview(Context context) {
        super(context);
    }

    public TopScrollview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TopScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollListener(ScrollListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener != null) {
            listener.onScrollChanged(l, t, oldl, oldt);
        }
    }

    public interface ScrollListener {
        void onScrollChanged(int l, int t, int oldl, int oldt);
    }
}
