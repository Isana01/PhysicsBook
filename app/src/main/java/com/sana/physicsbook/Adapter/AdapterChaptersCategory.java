package com.sana.physicsbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sana.physicsbook.Holder.HolderChaptersCategories;
import com.sana.physicsbook.Model.ModelChaptersCategory;
import com.sana.physicsbook.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterChaptersCategory extends RecyclerView.Adapter<HolderChaptersCategories> {

    Context c;
    ArrayList<ModelChaptersCategory> models;

    public AdapterChaptersCategory(Context c, ArrayList<ModelChaptersCategory> models) {
        this.c = c;
        this.models = models;
    }


    @NonNull
    @Override
    public HolderChaptersCategories onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_design, null);
        return new HolderChaptersCategories(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderChaptersCategories holder, int position) {
        holder.categoryTitle1Tv.setText(models.get(position).getChapterNumber());
        holder.categoryTitle2Tv.setText(models.get(position).getChapterTitle());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
