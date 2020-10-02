package com.dinh.thuhuyen.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.dinh.thuhuyen.model.ColorModel;
import com.dinh.thuhuyen.repository.ColorRepository;

import java.util.List;

public class ColorViewModel extends ViewModel {
    private MutableLiveData<List<ColorModel>> data = new MutableLiveData<>();
    private MutableLiveData<ColorModel> mSelectedItem = new MutableLiveData<>();
    private MutableLiveData<Boolean> checkUpdate = new MutableLiveData<>();
    private ColorRepository repository = new ColorRepository();

    public MutableLiveData<List<ColorModel>> init() {
        data = repository.getDataProduct();
        return data;
    }

    public MutableLiveData<ColorModel> getSelectedItem() {
        return mSelectedItem;
    }

    public void setSelectedItem(ColorModel selectedItem) {
        mSelectedItem.postValue(selectedItem);
    }

    public void updateColor(ColorModel productModel) {
        checkUpdate = repository.updateProduct(productModel);
    }

    public MutableLiveData<Boolean> getUpdate() {
        return checkUpdate;
    }
}
