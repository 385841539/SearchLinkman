package com.example.ruedy.searchlinkman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by ruedy on 2017/3/13.
 */

public class IndexWord extends View {

    private String[] words = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    private TextPaint textPaint;//文本画笔
    private int everywidth;//每一个字母单元格的宽度
    private int length;//words长度，
    private int everyheght;//每一个字母单元格的高度
    private Rect rect;//矩形
    private int index = -1;//用于touchevent中记录点击的是哪个字幕

    public IndexWord(Context context) {
        this(context, null);
    }

    public IndexWord(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndexWord(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initpaint();


    }

    private void initpaint() {//初始化文本画笔
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(30);
        rect = new Rect();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN | MotionEvent.ACTION_MOVE:
                //如果是点击或者滑动状态，则使字幕变色，并回调实现方法
                index = (int) (event.getY() / everyheght);
                //获取被点击的字幕，然后回调出去
                if (indexPressWord != null && index >= 0) {
                    indexPressWord.setIndexPressWord(words[index]);
                }
                invalidate();//重走onDraw方法。
                break;
            case MotionEvent.ACTION_UP://手指抬起，所有字母变为黑色
                index = -1;
                invalidate();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initheight();
        for (int i = 0; i < length; i++) {
            String word = words[i];
            textPaint.getTextBounds(word, 0, 1, rect);
            int width = rect.width();
            int height = rect.height();
            if (index == i) {//被点击的字幕为红色
                textPaint.setColor(Color.RED);
            } else {
                textPaint.setColor(Color.BLACK);
            }
            canvas.drawText(word, everywidth / 2 - width / 2, everyheght * i + (everyheght / 2 + height / 2), textPaint);
        }

    }

    private void initheight() {
        everywidth = getWidth();
        length = words.length;
        everyheght = getHeight() / length;
    }

    /**
     * 接口，用于回调点击和滑动事件
     */
    public interface IndexPressWord {
        void setIndexPressWord(String word);
    }

    private IndexPressWord indexPressWord;

    public void setIndexPressWord(IndexPressWord indexPressWord) {
        this.indexPressWord = indexPressWord;
    }
}
