package com.yyz.gogoplay.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yyz.gogoplay.R;

/**
 * Created by yyz on 2017/12/27.
 */

public class YbpView extends View {
    private Paint mPaint;
    private int outR;
    private int innerR;
    private String number="500,000";
    private String txtStr="最高可贷额度";
    private int staColor=getResources().getColor(R.color.ybp_start);
    private int endColor=getResources().getColor(R.color.ybp_end);

    private int color=Color.parseColor("#c96161");
    private ValueAnimator animator;
    private float totalAn=241;


    public YbpView(Context context) {
        super(context);
        init();
    }

    public YbpView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint=new Paint();
//        mPaint.setColor(color);
        Shader shader=new LinearGradient(100,100,800,800,staColor,endColor,Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        mPaint.setStyle(Paint.Style.STROKE);//STROKE:描边 FILL:填充  FILL_AND_STROKE:描边加填充
        mPaint.setStrokeWidth(20);//描边的宽度
        mPaint.setAntiAlias(true);// 抗锯齿

//        initAnim();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        RectF out=new RectF(100,100,800,800);
        canvas.drawArc(out,-210,totalAn,false,mPaint);
        RectF inner=new RectF(100+40,100+40,800-40,800-40);

        int startA=-210;//起始角度
        int sweepA=1;//扫过的角度--刻度的宽度
        int wLength=3;//留白
        int count=240/(sweepA+wLength);//条数
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        for (int i = 0; i <count +1; i++) {
            canvas.drawArc(inner,startA,sweepA,false,mPaint);
            startA=startA+sweepA+wLength;
        }

        mPaint.setColor(color);
        mPaint.setTextSize(80);
        canvas.drawText(number,320,450,mPaint);
        mPaint.setTextSize(30);
        canvas.drawText(txtStr,380,350,mPaint);


    }

    private void initAnim() {
        animator = ValueAnimator.ofFloat(totalAn);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                totalAn = (Float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });

    }

    public void startAnim(){
        animator.start();
    }

}
