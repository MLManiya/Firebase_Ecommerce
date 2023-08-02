package com.example.firebase_ecommerce.ui.Addproduct;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.firebase_ecommerce.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class AddProductFragment extends Fragment {

    ImageView imageView;
    EditText pname,pprice,pdescription;
    Button submitbutton;
    FirebaseDatabase database;
    DatabaseReference myRef;

    int SELECT_PICTURE = 200;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_add_product,container,false);

        imageView = view.findViewById(R.id.productimage);
        pname=view.findViewById(R.id.productname);
        pprice=view.findViewById(R.id.productprice);
        pdescription=view.findViewById(R.id.productdescription);
        submitbutton = view.findViewById(R.id.submitproduct);
        // Inflate the layout for this fragment

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        Log.d("TTT", "onCreateView: ooo"+myRef);

        return inflater.inflate(R.layout.fragment_add_product, container, false);
    }

    }
