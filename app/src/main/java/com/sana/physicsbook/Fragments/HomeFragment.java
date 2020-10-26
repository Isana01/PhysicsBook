package com.sana.physicsbook.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sana.physicsbook.Adapter.AdapterChaptersCategory;
import com.sana.physicsbook.Adapter.SearchChapterAdapter;
import com.sana.physicsbook.Model.ModelChaptersCategory;
import com.sana.physicsbook.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    RecyclerView mRecyclerViewCategories;
    ArrayList<String> ChapterNumber, ChapterTitle;
    SearchChapterAdapter searchChapterAdapter;
    AdapterChaptersCategory adapterChaptersCategory;
    ModelChaptersCategory m;
    EditText searchCategoryEt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        getActivity().setTitle("Home");

        ChapterNumber = new ArrayList<>();
        ChapterTitle = new ArrayList<>();

        mRecyclerViewCategories = view.findViewById(R.id.rv_home);
        searchCategoryEt = view.findViewById(R.id.searchCategoryId);

        mRecyclerViewCategories.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerViewCategories.setLayoutManager(gridLayoutManager);
        mRecyclerViewCategories.addItemDecoration(new DividerItemDecoration(getContext(), GridLayoutManager.VERTICAL));


        adapterChaptersCategory = new AdapterChaptersCategory(getContext(), getMyList());
        mRecyclerViewCategories.setAdapter(adapterChaptersCategory);


        searchCategoryEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!s.toString().isEmpty()) {
                    filter(s.toString());
                } else {
                    filter("");
                }
            }
        });

        return view;
    }

    private ArrayList<ModelChaptersCategory> getMyList() {
        ArrayList<ModelChaptersCategory> models = new ArrayList<>();

        //0
        m = new ModelChaptersCategory();
        m.setChapterNumber("Chapter 1");
        m.setChapterTitle("Forces");
        models.add(m);

        //1
        m = new ModelChaptersCategory();
        m.setChapterNumber("Chapter 2");
        m.setChapterTitle("Autonomous Agents");
        models.add(m);

        //2
        m = new ModelChaptersCategory();
        m.setChapterNumber("Chapter 3");
        m.setChapterTitle("Oscillations");
        models.add(m);

        //3
        m = new ModelChaptersCategory();
        m.setChapterNumber("Chapter 4");
        m.setChapterTitle("Quantum Physics");
        models.add(m);

        //4
        m = new ModelChaptersCategory();
        m.setChapterNumber("Chapter 5");
        m.setChapterTitle("Astrology");
        models.add(m);

        return models;
    }

    private void filter(final String searchedString) {

        ChapterNumber.clear();
        ChapterTitle.clear();
        mRecyclerViewCategories.removeAllViews();

        int counter = 0;

        String titlea1 = "Chapter 1";
        String titlea2 = "Forces";

        String titleb1 = "Chapter 2";
        String titleb2 = "Particles";

        String titlec1 = "Chapter 3";
        String titlec2 = "Oscillations";

        String titled1 = "Chapter 4";
        String titled2 = "Quantum Physics";

        String titlee1 = "Chapter 5";
        String titlee2 = "Astrology";

        if (titlea2.toLowerCase().contains(searchedString.toLowerCase())) {
            ChapterNumber.add(titlea1);
            ChapterTitle.add(titlea2);
            counter++;
        }

        if (titleb2.toLowerCase().contains(searchedString.toLowerCase())) {
            ChapterNumber.add(titleb1);
            ChapterTitle.add(titleb2);
            counter++;
        }

        if (titlec2.toLowerCase().contains(searchedString.toLowerCase())) {
            ChapterNumber.add(titlec1);
            ChapterTitle.add(titlec2);
            counter++;
        }

        if (titled2.toLowerCase().contains(searchedString.toLowerCase())) {
            ChapterNumber.add(titled1);
            ChapterTitle.add(titled2);
            counter++;
        }

        if (titlee2.toLowerCase().contains(searchedString.toLowerCase())) {
            ChapterNumber.add(titlee1);
            ChapterTitle.add(titlee2);
            counter++;
        }

        searchChapterAdapter = new SearchChapterAdapter(getContext(), ChapterNumber, ChapterTitle);
        mRecyclerViewCategories.setAdapter(searchChapterAdapter);
    }
}
