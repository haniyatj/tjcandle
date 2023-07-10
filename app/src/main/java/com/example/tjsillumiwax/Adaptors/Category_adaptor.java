package com.example.tjsillumiwax.Adaptors;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tjsillumiwax.Models.Cateogry;
import com.example.tjsillumiwax.databinding.ItemCategoryBinding;
import android.content.Context;
import java.util.ArrayList;
import com.example.tjsillumiwax.R;

public class Category_adaptor extends RecyclerView.Adapter<Category_adaptor.CategoryViewHolder> {

    Context context;
    ArrayList<Cateogry> categories;

    public Category_adaptor(Context context,ArrayList<Cateogry> categories)
    {
        this.context=context;
        this.categories=categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Cateogry category=categories.get(position);
        holder.binding.catLabel.setText(category.getName());
        Glide.with(context)
                .load(category.getIcon())
                .into(holder.binding.catImage);

    }

    @Override
    public int getItemCount() {

        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        ItemCategoryBinding binding;
        public CategoryViewHolder(@NonNull View itemView)
        {
            super(itemView);
            binding=ItemCategoryBinding.bind(itemView);

        }

    }

}
