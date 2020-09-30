package com.dinh.thuhuyen.fragment.product;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.canhdinh.lib.alert.AlertConfirmSuccess;
import com.canhdinh.lib.alert.AlertError;
import com.canhdinh.lib.alert.AlertSuccess;
import com.canhdinh.lib.helper.MyLog;
import com.canhdinh.lib.helper.MyToast;
import com.canhdinh.lib.roundview.RoundTextView;
import com.dinh.thuhuyen.R;
import com.dinh.thuhuyen.activity.MainActivity;
import com.dinh.thuhuyen.model.ProductModel;
import com.dinh.thuhuyen.viewmodel.ProductViewModel;
import com.zcw.togglebutton.ToggleButton;

public class ProductDetailFragment extends Fragment implements LifecycleOwner {
    private ProductViewModel productViewModel;

    private TextView tvTitleHeader;
    private ImageView btnBackHeader;
    private EditText edt_id_code, edt_name_product;
    private RoundTextView btnSelecteImage, btnSubmit;
    private ImageView imvAvatar;

    MainActivity activity;

    private String id_product;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productViewModel = ViewModelProviders.of(requireActivity()).get(ProductViewModel.class);
        productViewModel.getSelectedItem().observe(this, model -> {
            if (model != null) {
                id_product = String.valueOf(model.getId());
            }
            if (!TextUtils.isEmpty(model.getId_code())) {
                edt_id_code.setText(model.getId_code());
            }
            if (!TextUtils.isEmpty(model.getName())) {
                edt_name_product.setText(model.getName());
            }

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
        activity = (MainActivity) getActivity();

        tvTitleHeader = view.findViewById(R.id.tvTitleHeader);
        btnBackHeader = view.findViewById(R.id.btnBackHeader);

        edt_id_code = view.findViewById(R.id.edt_id_code);
        edt_name_product = view.findViewById(R.id.edt_name_product);
        imvAvatar = view.findViewById(R.id.imvAvatar);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        tvTitleHeader.setText("Chi tiết sản phẩm");
        btnBackHeader.setOnClickListener(view1 -> {
            activity.checkBack();
        });

        btnSubmit.setOnClickListener(view1 -> {
            ProductModel productModel = new ProductModel();
            productModel.setId(Integer.valueOf(id_product));
            if (!TextUtils.isEmpty(edt_id_code.getText().toString().trim())) {
                productModel.setId_code(edt_id_code.getText().toString().trim());
            }
            if (!TextUtils.isEmpty(edt_name_product.getText().toString().trim())) {
                productModel.setName(edt_name_product.getText().toString().trim());
            }
            productViewModel.updateProduct(productModel);

            productViewModel.getUpdate().observe(this, aBoolean -> {
                if (aBoolean.booleanValue()){
                    AlertSuccess.showAlertSuccess(getContext(),"Xác nhận","Cập nhật thành công");
                }
                else if(!aBoolean.booleanValue()){
                    AlertError.showAlertError(getContext(),"Lỗi","Cập nhật không thành công");
                }
            });
        });
    }
}