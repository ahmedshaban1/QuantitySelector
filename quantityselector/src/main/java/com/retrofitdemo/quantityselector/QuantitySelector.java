package com.retrofitdemo.quantityselector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by mohamed on 24/05/18.
 */

public class QuantitySelector extends LinearLayout {
    View root;
    ImageView plusIcon,minusIcon;
    TextView counter;

    int maxValue = Integer.MAX_VALUE;
    int minValue = 0;
    int current_value = 0;


    //attrs
    float counter_size;
    int counter_color;

    Drawable plus_icon;
    Drawable minus_icon;

    public QuantitySelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        root = inflate(context,R.layout.quantitiy_selector,this);
        plusIcon = findViewById(R.id.increment);
        minusIcon = findViewById(R.id.decrement);
        counter = findViewById(R.id.counter);
        counter.setText(current_value+"");

        TypedArray a = context.obtainStyledAttributes(attrs,  R.styleable.QuantitySelector, 0, 0);

        counter_size = a.getDimension(R.styleable.QuantitySelector_counter_text_size,20f);
        counter_color = a.getColor(R.styleable.QuantitySelector_counter_text_color, Color.BLACK);

        plus_icon = a.getDrawable(R.styleable.QuantitySelector_plus_icon);
        minus_icon = a.getDrawable(R.styleable.QuantitySelector_minus_icon);

        //do something with str

        a.recycle();

        initViews();






        setUpListeners();

    }

    private void initViews() {
        counter.setTextSize(counter_size);
        counter.setTextColor(counter_color);

        if(minus_icon!=null)
            minusIcon.setImageDrawable(minus_icon);
        if(plus_icon!=null)
            plusIcon.setImageDrawable(plus_icon);
    }

    private void setUpListeners() {
        plusIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                current_value++;
                if(current_value <= maxValue){
                    counter.setText(current_value+"");
                }else{
                    current_value--;
                }

            }
        });

        minusIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                current_value--;
                if(current_value >= 0){
                    counter.setText(current_value+"");
                }else{
                    current_value++;
                }
            }
        });
    }
}
