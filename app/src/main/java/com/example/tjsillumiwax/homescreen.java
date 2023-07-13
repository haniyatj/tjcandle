package com.example.tjsillumiwax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.ExceptionsClass;
import com.codebyashish.autoimageslider.Interfaces.ItemsListener;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;
import com.example.tjsillumiwax.Adaptors.Category_adaptor;
import com.example.tjsillumiwax.Adaptors.Product_adaptor;
import com.example.tjsillumiwax.Models.Cateogry;
import com.example.tjsillumiwax.Models.Product;
import com.example.tjsillumiwax.databinding.ActivityHomescreenBinding;

import java.util.ArrayList;

public class homescreen extends AppCompatActivity {

    ActivityHomescreenBinding binding;
        Category_adaptor categoryAdaptor;
        ArrayList<Cateogry> categories;

        Product_adaptor productAdaptor;
        ArrayList<Product> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomescreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //create list for images
        ArrayList<ImageSlidesModel> slidesModels=new ArrayList<>();

        AutoImageSlider autoImageSlider=findViewById(R.id.autoImageSlider);


        try {
            slidesModels.add(new ImageSlidesModel(R.drawable.img_9, ImageScaleType.FIT));
            slidesModels.add(new ImageSlidesModel(R.drawable.img_10, ImageScaleType.FIT));
            slidesModels.add(new ImageSlidesModel(R.drawable.img_11, ImageScaleType.FIT));
            slidesModels.add(new ImageSlidesModel(R.drawable.img_12, ImageScaleType.FIT));



        } catch (ExceptionsClass e) {
            e.printStackTrace();
        }
        autoImageSlider.setImageList(slidesModels,ImageScaleType.FIT);
        categ();
        product();


    }

    void categ()
    {

        categories=new ArrayList<>();

        categoryAdaptor=new Category_adaptor(this,categories);
        categories.add(new Cateogry("Jar Candles","https://cdn.sanity.io/images/w4a0o3t9/development/3954ad2eb01beb1298071720870a7f3176d891e2-3297x3297.jpg?w=1080&fit=max&auto=format&h=1080","#F5EBE0","lol",1));
        categories.add(new Cateogry("Diffusers","https://cdn.sanity.io/images/w4a0o3t9/development/9de0056c02429ad27953ee666565db7e31a15fea-3160x3160.jpg?w=1080&fit=max&auto=format&h=1080","#F5EBE0","lol",1));
        categories.add(new Cateogry("Bundles","https://cdn.sanity.io/images/w4a0o3t9/development/d61dfe03f3998698f7f447cb847cf240516649cc-3052x3052.jpg?w=1080&fit=max&auto=format&h=1080","#F5EBE0","lol",1));


        GridLayoutManager layoutManager= new GridLayoutManager(this,3);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdaptor);
    }

    void product()
    {
        products=new ArrayList<>();


        products.add(new Product("Dandy","https://cdn.sanity.io/images/w4a0o3t9/development/dad62412a13d9df2e6a85d5d9959968750fbc36b-3378x3378.jpg?w=1080&fit=max&auto=format&h=1080","in stock",2000.0,1,33,10));
        products.add(new Product("Bohemia","https://cdn.sanity.io/images/w4a0o3t9/development/b665691a428aff473619a41c55502a116f1c1ed9-3378x3378.jpg?w=1080&fit=max&auto=format&h=1080","in stock",2000.0,1,33,10));
        products.add(new Product("Lemonade","https://cdn.sanity.io/images/w4a0o3t9/development/3285c517336df8974e3cfc83b864612532853728-3378x3378.jpg?w=1080&fit=max&auto=format&h=1080","in stock",2000.0,1,33,10));
        products.add(new Product("Fresh Laundry","https://cdn.sanity.io/images/w4a0o3t9/development/c7e06277a93d2a063270087239432fa05783e02e-3408x3408.jpg?w=1080&fit=max&auto=format&h=1080","in stock",2000.0,1,33,10));

        products.add(new Product("Sunny Side","https://cdn.sanity.io/images/w4a0o3t9/development/3954ad2eb01beb1298071720870a7f3176d891e2-3297x3297.jpg?w=1080&fit=max&auto=format&h=1080","in stock",2000.0,1,33,10));
        products.add(new Product("Hygge","https://cdn.sanity.io/images/w4a0o3t9/development/979ab88e6d2089e35831a522818a35683ca5451d-3223x3223.jpg?w=1080&fit=max&auto=format&h=1080","in stock",2000.0,1,33,10));
        products.add(new Product("Aurora","https://cdn.sanity.io/images/w4a0o3t9/development/ef4600ac43a58ea6add16b4bc253e1126059c06e-3378x3378.jpg?w=1080&fit=max&auto=format&h=1080","in stock",2000.0,1,33,10));
        products.add(new Product("Moon rise","https://cdn.sanity.io/images/w4a0o3t9/development/d405cb2ff0bd1f2d3e3f11184571c99a42e04f6d-3314x3314.jpg?w=1080&fit=max&auto=format&h=1080","in stock",2000.0,1,33,10));



        productAdaptor=new Product_adaptor(this,products);
        GridLayoutManager layoutManager= new GridLayoutManager(this,2);
        binding.Productlist.setLayoutManager(layoutManager);
        binding.Productlist.setAdapter(productAdaptor);



    }


}