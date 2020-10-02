package com.dinh.thuhuyen.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.canhdinh.lib.roundview.RoundLinearLayout;
import com.dinh.thuhuyen.R;
import com.dinh.thuhuyen.model.ColorModel;

import java.util.List;

public class ListColorImportAdapter extends RecyclerView.Adapter<ListColorImportAdapter.ViewHolder> {
    List<ColorModel> list;
    Context context;

    private ListColorImportListener listener;
    public interface ListColorImportListener{
        void onClickItem(ColorModel model);
    }

    public void setListener(ListColorImportListener listener) {
        this.listener = listener;
    }

    public ListColorImportAdapter(Context context, List<ColorModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ColorModel model = list.get(position);
        if (model != null) {
            if (!TextUtils.isEmpty(model.getName())){
                holder.price_item.setText(model.getName());
            }
            if (!TextUtils.isEmpty(model.getId_code())){
                holder.name_item.setText(model.getId_code());
            }
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_item;
        RoundLinearLayout layout_item;
        TextView name_item, price_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.image_item);
            name_item = itemView.findViewById(R.id.name_item);
            price_item = itemView.findViewById(R.id.price_item);
            layout_item = itemView.findViewById(R.id.layout_item);

            layout_item.setOnClickListener(view -> {
                if (listener!=null)
                    listener.onClickItem(list.get(getAdapterPosition()));
            });
        }
    }
}
