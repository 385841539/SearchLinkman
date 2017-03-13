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
    private TextPaint textPaint;
    private int everywidth;
    private int length;
    private int everyheght;
    private Rect rect;
    private int index = -1;

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

    private void initpaint() {
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(30);
        rect = new Rect();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                index = (int) (event.getY() / everyheght);
                if (indexPressWord != null && index >= 0) {
                    indexPressWord.setIndexPressWord(words[index]);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                index = (int) (event.getY() / everyheght);
                if (indexPressWord != null && index >= 0) {

                    indexPressWord.setIndexPressWord(words[index]);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
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
            if (index == i) {
                textPaint.setColor(Color.RED);
            } else {
                textPaint.setColor(Color.BLACK);
            }
            canvas.drawText(word, everywidth / 2 - width / 2, everyheght * (i + 1) - height / 2, textPaint);
        }


    }

    private void initheight() {
        everywidth = getWidth();
        length = words.length;
        everyheght = getHeight() / length;
    }

    public interface IndexPressWord {
        void setIndexPressWord(String word);
    }

    private IndexPressWord indexPressWord;

    public void setIndexPressWord(IndexPressWord indexPressWord) {
        this.indexPressWord = indexPressWord;
    }
}
