package com.example.administrator.movieonline;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class NavigationLayout extends LinearLayout {

    public NavigationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.navigation, this);
        View list = findViewById(R.id.list);
        View homepage = findViewById(R.id.homepage);
        View mine = findViewById(R.id.mine);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),RegisterActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MainActivity.class);
                v.getContext().startActivity(intent);

            }
        });
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),RegisterActivity.class);
                v.getContext().startActivity(intent);

            }
        });
    }

}