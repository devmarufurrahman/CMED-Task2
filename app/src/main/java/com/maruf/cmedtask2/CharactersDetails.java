package com.maruf.cmedtask2;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.maruf.cmedtask2.databinding.ActivityCharactersDetailsBinding;

public class CharactersDetails extends AppCompatActivity {

    ActivityCharactersDetailsBinding binding;
    String name, fatherName, img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCharactersDetailsBinding.inflate(getLayoutInflater());
        View  view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        fatherName = intent.getStringExtra("fatherName");
        img = intent.getStringExtra("img");

        binding.fatherNameDetails.setText(fatherName);
        binding.nameDetails.setText(name);
        Glide.with(this).load("https://bdclean.winkytech.com/resources/user/profile_pic/"+img).into(binding.imgDetails);



    }
}