package com.jhd.mq.blur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MainPopWindow mainPopWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPopWindow = new MainPopWindow(this);


        findViewById(R.id.activity_main).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mainPopWindow.showAtLocation(findViewById(R.id.activity_main), Gravity.BOTTOM, 0, 0);
            }
        });

    }
}
