package com.dinh.thuhuyen.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.dinh.thuhuyen.api.APIService;
import com.dinh.thuhuyen.api.APIUntil;
import com.dinh.thuhuyen.model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    private APIService apiService = APIUntil.getServer();

    public MutableLiveData<List<ProductModel>> getDataProduct() {
        MutableLiveData<List<ProductModel>> data = new MutableLiveData<List<ProductModel>>();

        apiService.getAllProductModel().enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if (response.isSuccessful()) {
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });

        return data;
    }

    public MutableLiveData<Boolean> updateProduct(ProductModel model) {
        MutableLiveData<Boolean> success = new MutableLiveData<Boolean>();

        apiService.updateProductModel(model).enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response.isSuccessful()) {
                    success.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
                success.setValue(false);
            }
        });

        return success;
    }
}
