package com.android.android_architecture_practice;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.android_architecture_practice.viewmodel.TextViewModel;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("lz", "onCreate");
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        TextViewModel textViewModel = ViewModelProviders.of(this).get(TextViewModel.class);

        textViewModel.getNumber().observe(this, new Observer<Number>() {
            @Override
            public void onChanged(@Nullable Number number) {
                textView.setText(number.name + "  :  " + number.num);
            }
        });

    }
}
