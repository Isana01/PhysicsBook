package com.sana.physicsbook.Holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sana.physicsbook.Fragments.ChapterFiveFragment;
import com.sana.physicsbook.Fragments.ChapterFourFragment;
import com.sana.physicsbook.Fragments.ChapterOneFragment;
import com.sana.physicsbook.Fragments.ChapterThreeFragment;
import com.sana.physicsbook.Fragments.ChapterTwoFragment;
import com.sana.physicsbook.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class HolderChaptersCategories extends RecyclerView.ViewHolder implements View.OnClickListener {

    View view;
    public TextView categoryTitle1Tv, categoryTitle2Tv;
    Context context;

    public HolderChaptersCategories(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();

        categoryTitle1Tv = itemView.findViewById(R.id.categoryTitle1Id);
        categoryTitle2Tv = itemView.findViewById(R.id.categoryTitle2Id);

        itemView.setClickable(true);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (getAdapterPosition()) {
            case 0:
                AppCompatActivity activity = (AppCompatActivity) context;
                Fragment fragment = new ChapterOneFragment();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case 1:
                activity = (AppCompatActivity) context;
                fragment = new ChapterTwoFragment();
                fragmentManager = activity.getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case 2:
                activity = (AppCompatActivity) context;
                fragment = new ChapterThreeFragment();
                fragmentManager = activity.getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case 3:
                activity = (AppCompatActivity) context;
                fragment = new ChapterFourFragment();
                fragmentManager = activity.getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case 4:
                activity = (AppCompatActivity) context;
                fragment = new ChapterFiveFragment();
                fragmentManager = activity.getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            default:
                Toast.makeText(context, "Category pending ", Toast.LENGTH_SHORT).show();
        }
    }
}