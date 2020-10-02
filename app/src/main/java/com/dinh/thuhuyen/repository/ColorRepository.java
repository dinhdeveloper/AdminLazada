package com.dinh.thuhuyen.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.dinh.thuhuyen.api.APIService;
import com.dinh.thuhuyen.api.APIUntil;
import com.dinh.thuhuyen.model.ColorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ColorRepository {
    private APIService apiService = APIUntil.getServer();

    public MutableLiveData<List<ColorModel>> getDataProduct() {
        MutableLiveData<List<ColorModel>> data = new MutableLiveData<List<ColorModel>>();

        apiService.getAllColorModel().enqueue(new Callback<List<ColorModel>>() {
            @Override
            public void onResponse(Call<List<ColorModel>> call, Response<List<ColorModel>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ColorModel>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });

        return data;
    }

    public MutableLiveData<Boolean> updateProduct(ColorModel model) {
        MutableLiveData<Boolean> success = new MutableLiveData<Boolean>();

        apiService.updateColorModel(model).enqueue(new Callback<ColorModel>() {
            @Override
            public void onResponse(Call<ColorModel> call, Response<ColorModel> response) {
                if (response.isSuccessful()) {
                    success.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<ColorModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
                success.setValue(false);
            }
        });

        return success;
    }
}
