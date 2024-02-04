package com.example.tjsillumiwax.Adaptors;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tjsillumiwax.categ_details;
import com.example.tjsillumiwax.Models.Cateogry;

import android.content.Context;
import java.util.ArrayList;
import com.example.tjsillumiwax.R;
import com.example.tjsillumiwax.databinding.ItemCategoryBinding;
import android.util.Log;


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

        Cateogry category = categories.get(position);


        holder.binding.catLabel.setText(category.getName());
        Glide.with(context)
                .load(category.getIcon())
                .into(holder.binding.catImage);


            // Bind category data to the views
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the category ID of the clicked item
                    int categoryId = category.getId();
                    String name = category.getName();
                    String image=category.getIcon();

                    Log.d("TAG", "Image URL: " + category.getIcon());

                    Log.d("CategoryAdapter", "Clicked category ID: " + categoryId);

                    // Start a new activity or perform any desired action with the category ID
                    // For example, you can start a new activity and pass the category ID as an extra
                    Intent intent = new Intent(context, categ_details.class);
                    intent.putExtra("categoryId", categoryId);
                    intent.putExtra("name", name);
                    intent.putExtra("image", image);



                    context.startActivity(intent);
                }
            });




    }

        @Override
        public int getItemCount () {

            return categories.size();
        }

        public class CategoryViewHolder extends RecyclerView.ViewHolder {
            ItemCategoryBinding binding;

            public CategoryViewHolder(@NonNull View itemView) {
                super(itemView);
                binding = ItemCategoryBinding.bind(itemView);

            }

        }
    }
