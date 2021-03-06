package com.dinh.thuhuyen.fragment.menu_main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.canhdinh.lib.alert.AlertError;
import com.dinh.thuhuyen.R;
import com.dinh.thuhuyen.fragment.color_import.ListColorImportFragment;
import com.dinh.thuhuyen.fragment.product.ListProductFragment;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuMainFragment extends Fragment {
    public static String pattern = "###,###.###";
    public static DecimalFormat DECIMAIFOMAT = new DecimalFormat(pattern);

    private RelativeLayout
            btnProductManager,
            btnServiceManager,
            tvBtnProductExportManager,
            btnPriceExport,
            btnEmployeeManager,
            btnSlideManager,
            btnPostManager,
            btnOrderManager;
    private TextView tvTitleHeader;
    private ImageView btnBackHeader;

    public MenuMainFragment() {
        // Required empty public constructor
    }


    public static MenuMainFragment newInstance(String param1, String param2) {
        MenuMainFragment fragment = new MenuMainFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_menu_main, container, false);

        addControls(view);
        addEvent();

        return view;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void addEvent() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        btnBackHeader.setVisibility(View.INVISIBLE);

        tvTitleHeader.setText("Trang chủ");
        if (isNetworkConnected()) {
            //danh sách sản phẩm
            btnProductManager.setOnClickListener(view -> {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layoutRoot, new ListProductFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            });
            // san pham nhap
            btnServiceManager.setOnClickListener(view -> {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layoutRoot, new ListColorImportFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            });
            //san pham xuat
            tvBtnProductExportManager.setOnClickListener(view -> {

            });
            //tien phải trả
            btnPriceExport.setOnClickListener(view -> {

            });
        } else {
            AlertError.showAlertError(getContext(), "Xác nhận", "Lỗi kết nối mạng");
        }
    }

    private void addControls(View view) {
        btnProductManager = view.findViewById(R.id.btnProductManager);
        btnServiceManager = view.findViewById(R.id.btnServiceManager);
        tvBtnProductExportManager = view.findViewById(R.id.tvBtnProductExportManager);
        btnPriceExport = view.findViewById(R.id.btnPriceExport);
        btnEmployeeManager = view.findViewById(R.id.btnEmployeeManager);
        btnSlideManager = view.findViewById(R.id.btnSlideManager);
        btnPostManager = view.findViewById(R.id.btnPostManager);
        btnOrderManager = view.findViewById(R.id.btnOrderManager);
        tvTitleHeader = view.findViewById(R.id.tvTitleHeader);
        btnBackHeader = view.findViewById(R.id.btnBackHeader);
    }

}