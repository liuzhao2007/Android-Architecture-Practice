package com.android.android_architecture_practice;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.android_architecture_practice.viewmodel.TextViewModel;

/**
 * Created by liuzhao on 2017/12/19.
 */

public class ViewModelActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("lz", "onCreate");
        setContentView(R.layout.view_model_act);
        textView = (TextView) findViewById(R.id.tv);
        TextViewModel textViewModel = ViewModelProviders.of(this).get(TextViewModel.class);

        textViewModel.getNumber().observe(this, new Observer<Number>() {
            @Override
            public void onChanged(@Nullable Number number) {
                textView.setText(number.name + "  :  " + number.num);
            }
        });

    }


    @Override
    public void finish() {
        super.finish();
        Log.i("lz", "finish");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("lz", "onDestroy");
    }
}
