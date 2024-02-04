package com.example.tjsillumiwax;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import com.bumptech.glide.Glide;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.example.tjsillumiwax.Models.Product;
import com.example.tjsillumiwax.databinding.ActivityProductDetailsBinding;
import com.hishd.tinycart.model.Cart;
import com.hishd.tinycart.util.TinyCartHelper;


public class product_details extends AppCompatActivity {

    ActivityProductDetailsBinding binding;
    Product currentProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String name=getIntent().getStringExtra("name");
        String image=getIntent().getStringExtra("image");
        String des=getIntent().getStringExtra("des");
        String scent=getIntent().getStringExtra("scent");
        String status=getIntent().getStringExtra("status");
        int stock=getIntent().getIntExtra("stock",0);
        int id=getIntent().getIntExtra("id",0);
        int quantity=getIntent().getIntExtra("quantity",0);

        double price=getIntent().getDoubleExtra("price",0);
        double discount=getIntent().getDoubleExtra("discount",0);


        Glide.with(this)
                .load(image)
                .into(binding.image);


        binding.name.setText(name);
        binding.descp.setText(des);
        binding.scent.setText(scent);


        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        currentProduct=new Product(name,image,status,price,discount,stock,id,des,scent,quantity);

        Cart cart = TinyCartHelper.getCart();
        binding.addtocartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.addItem(currentProduct,1);
                binding.addtocartbtn.setEnabled(false);
                binding.addtocartbtn.setText("Added to Cart");
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onSupportNavigateUp()
    {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Or perform any other desired action
            return true;
        }
        if (item.getItemId() == R.id.cart) {
            startActivity(new Intent(this,CartActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}