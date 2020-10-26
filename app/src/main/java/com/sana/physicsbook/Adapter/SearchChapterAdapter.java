package com.sana.physicsbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sana.physicsbook.Fragments.ChapterFiveFragment;
import com.sana.physicsbook.Fragments.ChapterFourFragment;
import com.sana.physicsbook.Fragments.ChapterOneFragment;
import com.sana.physicsbook.Fragments.ChapterThreeFragment;
import com.sana.physicsbook.Fragments.ChapterTwoFragment;
import com.sana.physicsbook.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class SearchChapterAdapter extends RecyclerView.Adapter<SearchChapterAdapter.SearchChapterHolder> {

    Context context;
    ArrayList<String> ChapterNumber, ChapterTitle;

    public SearchChapterAdapter(Context c, ArrayList<String> ChapterNumber, ArrayList<String> ChapterTitle) {
        this.context = c;
        this.ChapterNumber = ChapterNumber;
        this.ChapterTitle = ChapterTitle;
    }

    @NonNull
    @Override
    public SearchChapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.category_design, parent, false);
        return new SearchChapterHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchChapterHolder holder, int position) {
        holder.textSearch1.setText(ChapterNumber.get(position));
        holder.textSearch2.setText(ChapterTitle.get(position));

        holder.setOnclickListener(new SearchChapterHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (holder.textSearch2.getText().toString().equals("Forces")) {
                    AppCompatActivity activity = (AppCompatActivity) context;
                    Fragment fragment = new ChapterOneFragment();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

                if (holder.textSearch2.getText().toString().equals("Vectors")) {
                    AppCompatActivity activity = (AppCompatActivity) context;
                    Fragment fragment = new ChapterTwoFragment();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

                if (holder.textSearch2.getText().toString().equals("Oscillations")) {
                    AppCompatActivity activity = (AppCompatActivity) context;
                    Fragment fragment = new ChapterThreeFragment();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

                if (holder.textSearch2.getText().toString().equals("Quantum Physics")) {
                    AppCompatActivity activity = (AppCompatActivity) context;
                    Fragment fragment = new ChapterFourFragment();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

                if (holder.textSearch2.getText().toString().equals("Astrology")) {
                    AppCompatActivity activity = (AppCompatActivity) context;
                    Fragment fragment = new ChapterFiveFragment();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return ChapterTitle.size();
    }

    static class SearchChapterHolder extends RecyclerView.ViewHolder {

        TextView textSearch1, textSearch2;
        View view;
        Context context;

        public SearchChapterHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickListener.onItemClick(view, getAdapterPosition());
                }
            });

            textSearch1 = itemView.findViewById(R.id.categoryTitle1Id);
            textSearch2 = itemView.findViewById(R.id.categoryTitle2Id);
        }

        private SearchChapterHolder.ClickListener mClickListener;

        public interface ClickListener {
            void onItemClick(View view, int position);
        }

        public void setOnclickListener(SearchChapterHolder.ClickListener clickListener) {
            mClickListener = clickListener;
        }
    }
}
