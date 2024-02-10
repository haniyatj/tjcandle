package com.example.tjsillumiwax;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.ExceptionsClass;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;
import com.example.tjsillumiwax.Adaptors.Category_adaptor;
import com.example.tjsillumiwax.Adaptors.Product_adaptor;
import com.example.tjsillumiwax.Models.Cateogry;
import com.example.tjsillumiwax.Models.Product;
import com.example.tjsillumiwax.databinding.ActivityHomescreenBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class homescreen extends AppCompatActivity {

    ActivityHomescreenBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomescreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);

        NavigationView navigationView=findViewById(R.id.navigationView);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        binding.searchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                Intent intent = new Intent(homescreen.this, SearchActivity.class);
                intent.putExtra("query", text.toString());
                startActivity(intent);

            }

            @Override
            public void onButtonClicked(int buttonCode) {

                if (buttonCode == MaterialSearchBar.BUTTON_NAVIGATION) {
                    // Toggle the navigation drawer state (show/hide)
                    if (!drawerLayout.isDrawerOpen(GravityCompat.START)) //if drawer closed, it will open
                    {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                }

            }

        });

        // Set navigation item selected listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.shop) {
                    Intent intent = new Intent(homescreen.this,Factory.class);
                    startActivity(intent);
                }

                else if (id==R.id.about)
                {
                    Intent intent = new Intent(homescreen.this, About.class);
                    startActivity(intent);
                }
                // Return true to indicate that the item has been handled
                return true;
            }
        });


        // Call syncState to synchronize the drawer indicator icon with the current drawer state
                actionBarDrawerToggle.syncState();


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

        //Toast.makeText(homescreen.this,"connection succes",Toast.LENGTH_LONG).show();
        // Initialize Firebase
        FirebaseApp.initializeApp(this);




    }

    void categ()
    {
        RecyclerView recyclerView;
        DatabaseReference database;
        Category_adaptor categoryAdaptor;
        ArrayList<Cateogry> categories;


        recyclerView=(RecyclerView)findViewById(R.id.categories_list);
        database= FirebaseDatabase.getInstance().getReference().child("categories");
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        categories=new ArrayList<>();
        categoryAdaptor=new Category_adaptor(this,categories);


        // Use GridLayoutManager with span count of 2
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(categoryAdaptor);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Cateogry cateogry=dataSnapshot.getValue(Cateogry.class);
                    categories.add(cateogry);

                }
                categoryAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    void product()
    {
        RecyclerView recyclerView;
        DatabaseReference database;
        ArrayList<Product> list;
        Product_adaptor myadaptor;

        recyclerView=(RecyclerView)findViewById(R.id.Productlist);
        database= FirebaseDatabase.getInstance().getReference().child("bestsellers");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        myadaptor=new Product_adaptor(this,list);


        // Use GridLayoutManager with span count of 2
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(myadaptor);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Product product=dataSnapshot.getValue(Product.class);
                    list.add(product);

                }
                myadaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}