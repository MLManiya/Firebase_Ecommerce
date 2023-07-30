package com.example.firebase_ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.PopupMenu;

import com.example.firebase_ecommerce.ui.Addproduct.AddProductFragment;
import com.example.firebase_ecommerce.ui.home.HomeFragment;
import com.example.firebase_ecommerce.ui.slideshow.SlideshowFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_ecommerce.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        Log.d("TTT", "onCreateView: "+myRef);


        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_home){
                    addfragment(new HomeFragment());
                    binding.drawerLayout.closeDrawers();
                }
                if(item.getItemId()==R.id.nav_addproduct){
                    addfragment(new AddProductFragment());
                   // Splash_Screen.editor.putString("from","add");
                    binding.drawerLayout.closeDrawers();
                }
                if(item.getItemId()==R.id.nav_slideshow){
                    addfragment(new SlideshowFragment());
                   // Splash_Screen.editor.putString("from","update");
                    binding.drawerLayout.closeDrawers();
                }
//                if(item.getItemId()==R.id.signout){
//                    editor.putInt("login",0);
//                    editor.commit();
//                    Intent intent = new Intent(Main_Page.this,Signup_Page.class);
//                    startActivity(intent);
//                }
                return true;
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.framelayout);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
//        binding.appBarMain.menudot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu = new PopupMenu(Main_Page.this,view);
//                popupMenu.getMenuInflater().inflate(R.menu.menudot,popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//
//                        if(menuItem.getItemId()==R.id.nav_setting)
//                        {
//
//                        }
//                        if(menuItem.getItemId()==R.id.nav_logout)
//                        {
//                            Splash_Screen.editor.putInt("login",0);
//                            Splash_Screen.editor.commit();
//                            Intent intent = new Intent(Main_Page.this, Login_Activity.class);
//                            startActivity(intent);
//                        }
//                        return true;
//                    }
//                });
//                popupMenu.show();
//            }
//        });
        return true;
    }
    private void addfragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.framelayout);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}