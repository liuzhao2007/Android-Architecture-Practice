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
            // will only be loaded once
            number = new MutableLiveData<Number>();
            loadNumberAsync();
            Log.i("lz", "loadNumberAsync init only Once");
        }
        return number;
    }

    private void loadNumberAsync() {
        // Do an asyncronous operation to fetch data.

        Number num = new Number();
        num.name = "时间";
        num.num = 101;
        number.setValue(num);
    }

    /**
     * Test when will be called
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("lz", "onCleared");
    }
}
