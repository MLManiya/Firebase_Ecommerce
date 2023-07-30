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

//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//        Log.d("TTT", "onCreateView: ooo"+myRef);
        //addFragment(fragment);
        return inflater.inflate(R.layout.fragment_add_product, container, false);
    }
    private void addFragment(Fragment fragment) {
        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.framelayout,fragment);
        transaction.commit();
    }
//    void imageChooser() {
//        CropImage.activity()
//                .start(getContext(), this);
//    }
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//            if (resultCode == RESULT_OK) {
//                Uri resultUri = result.getUri();
//                imageView.setImageURI(resultUri);
//            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                Exception error = result.getError();
//            }
//        }
//
//    }
}