package com.example.tjsillumiwax.Adaptors;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import android.content.Context;
import java.util.ArrayList;

import com.example.tjsillumiwax.Models.Product;
import com.example.tjsillumiwax.R;
import com.example.tjsillumiwax.databinding.ItemProductBinding;

public class Product_adaptor extends RecyclerView.Adapter<Product_adaptor.ProductViewHolder> {

    private Context context;
    private ArrayList<Product> products;

    public Product_adaptor(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder
    {
        ItemProductBinding binding;
        public ProductViewHolder(@NonNull View itemView)
        {
            super(itemView);
            binding=ItemProductBinding.bind(itemView);

        }

    }

    @NonNull
    @Override
    public Product_adaptor.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new Product_adaptor.ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Product_adaptor.ProductViewHolder holder, int position)
    {
        Product product=products.get(position);
        Glide.with(context)
                .load(product.getImg())
                .into(holder.binding.ProductImg);
        holder.binding.productName.setText(product.getName());
        holder.binding.PriceTag.setText(context.getString(R.string.price_label,product.getPrice()));

    }

    public int getItemCount()
    {
        return products.size();
    }




}
