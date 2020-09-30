package com.dinh.thuhuyen.fragment.product;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.canhdinh.lib.helper.MyToast;
import com.dinh.thuhuyen.R;
import com.dinh.thuhuyen.activity.MainActivity;
import com.dinh.thuhuyen.adapter.ListProductAdapter;
import com.dinh.thuhuyen.model.ProductModel;
import com.dinh.thuhuyen.viewmodel.ProductViewModel;

import java.util.List;

public class ListProductFragment extends Fragment implements LifecycleOwner {
    private RecyclerView recycler_view_list;
    private TextView tvTitleHeader;
    private ImageView btnBackHeader;

    private ProductViewModel productViewModel;

    public ListProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_list_product, container, false);

        addControls(view);
        addEvents();
        btnBackHeader.setOnClickListener(view1 -> {

        });
        tvTitleHeader.setText("Danh sách sản phẩm");
        return view;
    }

    private void addEvents() {
        productViewModel = ViewModelProviders.of(requireActivity()).get(ProductViewModel.class);
        productViewModel.init().observe(this, productModels -> {
            ListProductAdapter productAdapter = new ListProductAdapter(getContext(), productModels);
            recycler_view_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recycler_view_list.setHasFixedSize(true);
            recycler_view_list.setAdapter(productAdapter);
            productAdapter.notifyDataSetChanged();

            productAdapter.setListener(model -> {
                productViewModel.setSelectedItem(model);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ProductDetailFragment productFragment = new ProductDetailFragment();
                ft.replace(R.id.layoutRoot, productFragment);
                ft.commit();
            });
        });
    }

    private void addControls(View view) {
        recycler_view_list = view.findViewById(R.id.recycler_view_list);
        tvTitleHeader = view.findViewById(R.id.tvTitleHeader);
        btnBackHeader = view.findViewById(R.id.btnBackHeader);
    }
}