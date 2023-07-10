package com.example.tjsillumiwax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.tjsillumiwax.Adaptors.Category_adaptor;
import com.example.tjsillumiwax.Models.Cateogry;
import com.example.tjsillumiwax.databinding.ActivityHomescreenBinding;

import java.util.ArrayList;

public class homescreen extends AppCompatActivity {

    ActivityHomescreenBinding binding;
        Category_adaptor categoryAdaptor;
        ArrayList<Cateogry> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomescreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        categories=new ArrayList<>();

        categoryAdaptor=new Category_adaptor(this,categories);
        categories.add(new Cateogry("Pillar Candles","C:\\Users\\haniy\\Downloads\\Untitled design (1).png","#F5EBE0","lol",1));
        categories.add(new Cateogry("Pillar Candles","C:\\Users\\haniy\\Downloads\\Untitled design (1).png","#F5EBE0","lol",1));
        categories.add(new Cateogry("Pillar Candles","C:\\Users\\haniy\\Downloads\\Untitled design (1).png","#F5EBE0","lol",1));





        GridLayoutManager layoutManager= new GridLayoutManager(this,3);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdaptor);

    }
}