package com.dinh.thuhuyen.fragment.product;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.canhdinh.lib.helper.MyLog;
import com.canhdinh.lib.helper.MyToast;
import com.dinh.thuhuyen.R;
import com.dinh.thuhuyen.model.ProductModel;
import com.dinh.thuhuyen.viewmodel.ProductViewModel;

public class ProductDetailFragment extends Fragment implements LifecycleOwner {
    private ProductViewModel productViewModel;
    private TextView tv_title;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productViewModel = ViewModelProviders.of(requireActivity()).get(ProductViewModel.class);
        productViewModel.getSelectedItem().observe(this, model -> {
            tv_title.setText(model.getName()+"  a");
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_title = view.findViewById(R.id.tv_title);
    }
}