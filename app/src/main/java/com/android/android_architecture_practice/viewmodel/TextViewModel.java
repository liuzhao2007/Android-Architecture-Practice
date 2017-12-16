package com.android.android_architecture_practice.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.android.android_architecture_practice.Number;


/**
 * Created by liuzhao on 2017/12/16.
 */

public class TextViewModel extends ViewModel {
    private MutableLiveData<Number> number;

    public LiveData<Number> getNumber() {
        if (number == null) {
            number = new MutableLiveData<Number>();
            loadNumber();
            Log.i("lz", "loadNumber init");
        }
        return number;
    }

    private void loadNumber() {
        Number num = new Number();
        num.name = "时间";
        num.num = 101;
        number.setValue(num);
    }

}
