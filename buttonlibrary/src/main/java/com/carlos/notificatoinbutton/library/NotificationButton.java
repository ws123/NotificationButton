package com.carlos.notificatoinbutton.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Administrator on 2016/2/20.
 */
public class NotificationButton extends Button {

    private int circleBgColor = Color.RED;
    private int numberColor = Color.WHITE;
    private float circleSize = 60;
    private float numberSize = 40;
    private Paint paint;
    private int notificationNumber = 0;
    private RectF rectFSmall, rectFMiddle, rectFBig;

    private Button button;


    public NotificationButton(Context context) {
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true);
        button = new Button(context);
    }

    public NotificationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        button = new Button(context, attrs);
    }

    public NotificationButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        button = new Button(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.notButton);
        circleBgColor = typedArray.getColor(R.styleable.notButton_circleBgColor, Color.RED);
        numberColor = typedArray.getColor(R.styleable.notButton_numberColor, Color.WHITE);
        circleSize = typedArray.getFloat(R.styleable.notButton_circleSize, 60);
        numberSize = typedArray.getFloat(R.styleable.notButton_numberSize, 40);
        typedArray.recycle();
        paint = new Paint();
        paint.setAntiAlias(true);
        if (getWidth() != 0) {
            if (notificationNumber > 0 && notificationNumber < 10 && rectFSmall == null) {
                rectFSmall = new RectF(getWidth() - circleSize, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
            } else if (notificationNumber > 9 && notificationNumber < 100 && rectFMiddle == null) {
                rectFMiddle = new RectF(getWidth() - circleSize - circleSize / 2, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
            } else if (notificationNumber > 100 && rectFBig == null) {
                rectFBig = new RectF(getWidth() - circleSize * 2, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        button.layout(left, top, (int) (right - circleSize / 2), bottom);
        if (notificationNumber > 0 && notificationNumber < 10 && rectFSmall == null) {
            rectFSmall = new RectF(getWidth() - circleSize, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
        } else if (notificationNumber > 9 && notificationNumber < 100 && rectFMiddle == null) {
            rectFMiddle = new RectF(getWidth() - circleSize - circleSize / 2, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
        } else if (notificationNumber > 100 && rectFBig == null) {
            rectFBig = new RectF(getWidth() - circleSize * 2, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.setBackgroundColor(Color.alpha(0));
        super.onDraw(canvas);
        canvas.save();
        canvas.scale((getWidth() - circleSize / 2) / (float) getWidth(), (getHeight() - circleSize / 2) / (float) getHeight(), getWidth() - circleSize * 2 / 3, getHeight());
        button.draw(canvas);
        canvas.restore();
        if (notificationNumber <= 0) {
            return;
        }
        if (notificationNumber > 0 && notificationNumber < 10) {
            drawCircleNumber(rectFSmall, canvas, "" + notificationNumber);
        } else if (notificationNumber > 9 && notificationNumber < 100) {
            drawCircleNumber(rectFMiddle, canvas, "" + notificationNumber);
        } else if (notificationNumber > 100) {
            drawCircleNumber(rectFBig, canvas, "99+");
        }
    }

    private void drawCircleNumber(RectF rectF, Canvas canvas, String text) {
        if (rectF == null) return;
        paint.setColor(circleBgColor);
        canvas.drawRoundRect(rectF, circleSize, circleSize, paint);
        paint.setColor(numberColor);
        paint.setTextSize(numberSize);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        int baseline = (int) ((rectF.bottom + rectF.top - fontMetrics.bottom - fontMetrics.top) / 2);
        canvas.drawText(text, getWidth() - rectF.width() / 2 + 1, baseline - 2, paint);
    }

    /**
     * set circle bg color
     *
     * @param circleBgColor the color value of circleBg
     */
    public void setCircleBgColor(int circleBgColor) {
        this.circleBgColor = circleBgColor;
    }

    /**
     * set number color
     *
     * @param numberColor the color value of number
     */
    public void setNumberColor(int numberColor) {
        this.numberColor = numberColor;
    }

    /**
     * set count of notification
     *
     * @param notificationNumber the count of notification
     */
    public void setNotificationNumber(int notificationNumber) {
        this.notificationNumber = notificationNumber;
        if (notificationNumber > 0 && notificationNumber < 10 && rectFSmall == null && getWidth() != 0) {
            rectFSmall = new RectF(getWidth() - circleSize, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
        } else if (notificationNumber > 9 && notificationNumber < 100 && rectFMiddle == null && getWidth() != 0) {
            rectFMiddle = new RectF(getWidth() - circleSize - circleSize / 2, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
        } else if (notificationNumber > 100 && rectFBig == null && getWidth() != 0) {
            rectFBig = new RectF(getWidth() - circleSize * 2, getY() - circleSize / 2, getWidth(), getY() + circleSize / 2);
        }
        invalidate();
    }
}
