package com.iteso.tarea4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    private ArrayList<com.iteso.tarea4.beans.ItemProduct> products;
    private Context context;

    public AdapterProduct(Context context, ArrayList<com.iteso.tarea4.beans.ItemProduct> products){
        this.products = products;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent,false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{

        public Button mDetail;
        public TextView mProductTitle;
        public TextView mProductStore;
        public TextView mProductLocation;
        public TextView mProductPhone;
        public ImageView mProductImage;
        public ImageView mProductThumbnail;
        public RelativeLayout mEventLayout;

        public ViewHolder(View v) {
            super(v);
            /*image.findViewById(R.id.item_product_image);
            title.findViewById(R.id.item_product_title);*/
            mEventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);
            mDetail = (Button) v.findViewById(R.id.item_product_detail);
            mProductTitle = (TextView) v.findViewById(R.id.item_product_title);
            mProductStore = (TextView) v.findViewById(R.id.item_product_store);
            mProductLocation = (TextView) v.findViewById(R.id.item_product_location);
            mProductPhone = (TextView) v.findViewById(R.id.item_product_phone);
            mProductImage = (ImageView) v.findViewById(R.id.item_product_image);
            mProductThumbnail = (ImageView) v.findViewById(R.id.item_product_thumbnail);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mProductTitle.setText(products.get(position).getTitle());
        holder.mProductStore.setText(products.get(position).getStore());
        holder.mProductLocation.setText(products.get(position).getLocation());
        holder.mProductPhone.setText(products.get(position).getPhone());
        switch (products.get(position).getImage()){
            case 0:
                holder.mProductImage.setImageResource(R.drawable.mac); break;
            case 1:
                holder.mProductImage.setImageResource(R.drawable.alienware); break;
        }

        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, products.get(position).toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
        holder.mProductPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel: " + products.get(position).getPhone()));
                context.startActivity(intent);*/
                Intent activity2 = new Intent(v.getContext() , ActivityProduct.class);
                context.startActivity(activity2);
            }
        });
        holder.mEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(context, products.get(position).toString(),
                        Toast.LENGTH_LONG).show();*/
                Intent activity2 = new Intent(v.getContext() , ActivityProduct.class);
                activity2.putExtra("ITEM", products.get(position));
                context.startActivity(activity2);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}