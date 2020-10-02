package com.dinh.thuhuyen.fragment.color_import;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinh.thuhuyen.R;
import com.dinh.thuhuyen.activity.MainActivity;
import com.dinh.thuhuyen.adapter.ListColorImportAdapter;
import com.dinh.thuhuyen.adapter.ListProductAdapter;
import com.dinh.thuhuyen.fragment.product.ProductDetailFragment;
import com.dinh.thuhuyen.viewmodel.ColorViewModel;
import com.dinh.thuhuyen.viewmodel.ProductViewModel;
import com.facebook.shimmer.ShimmerFrameLayout;

public class ListColorImportFragment extends Fragment {
    private RecyclerView recycler_view_list;
    private TextView tvTitleHeader;
    private ImageView btnBackHeader;

    private ShimmerFrameLayout mShimmerFrameLayout;

    MainActivity activity;
    ColorViewModel colorViewModel;
    public ListColorImportFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_color_import, container, false);
        activity = (MainActivity)getActivity();
        addControls(view);
        addEvents();
        btnBackHeader.setOnClickListener(view1 -> {
            activity.checkBack();
        });
        tvTitleHeader.setText("Danh sách màu sắc");
        return view;
    }

    private void addEvents() {
        colorViewModel = ViewModelProviders.of(requireActivity()).get(ColorViewModel.class);
        colorViewModel.init().observe(this, productModels -> {
            ListColorImportAdapter productAdapter = new ListColorImportAdapter(getContext(), productModels);
            recycler_view_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recycler_view_list.setHasFixedSize(true);
            recycler_view_list.setAdapter(productAdapter);
            productAdapter.notifyDataSetChanged();

            //shimmerAnimation stop and hide
            mShimmerFrameLayout.stopShimmer();
            mShimmerFrameLayout.setVisibility(View.GONE);

            productAdapter.setListener(model -> {
                colorViewModel.setSelectedItem(model);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layoutRoot, new ProductDetailFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            });
        });
    }

    private void addControls(View view) {
        recycler_view_list = view.findViewById(R.id.recycler_view_list);
        tvTitleHeader = view.findViewById(R.id.tvTitleHeader);
        btnBackHeader = view.findViewById(R.id.btnBackHeader);

        mShimmerFrameLayout = view.findViewById(R.id.shimmer_view_product);
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerFrameLayout.startShimmer();
    }

    @Override
    public void onPause() {
        super.onPause();
        mShimmerFrameLayout.stopShimmer();
    }
}