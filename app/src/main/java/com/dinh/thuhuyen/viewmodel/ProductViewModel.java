package com.dinh.thuhuyen.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dinh.thuhuyen.model.ProductModel;
import com.dinh.thuhuyen.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {
    private MutableLiveData<List<ProductModel>> data = new MutableLiveData<>();
    private MutableLiveData<ProductModel> mSelectedItem = new MutableLiveData<>();
    private MutableLiveData<Boolean> checkUpdate = new MutableLiveData<>();
    private ProductRepository repository = new ProductRepository();

//    public MutableLiveData<List<ProductModel>> init() {
//        data = repository.getDataProduct();
//        return data;
//    }

    public void init() {
        if (this.data != null) {
                data = repository.getDataProduct();
            return;
        }
        this.data = new MutableLiveData<>();
    }

    public MutableLiveData<List<ProductModel>> getData() {
        return data;
    }


    public MutableLiveData<ProductModel> getSelectedItem() {
        return mSelectedItem;
    }

    public void setSelectedItem(ProductModel selectedItem) {
        mSelectedItem.postValue(selectedItem);
    }

    public void updateProduct(ProductModel productModel) {
        checkUpdate = repository.updateProduct(productModel);
    }

    public MutableLiveData<Boolean> getUpdate() {
        return checkUpdate;
    }
}
