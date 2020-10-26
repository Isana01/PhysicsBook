package com.sana.physicsbook.Holder;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sana.physicsbook.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class HolderChapterDetails extends RecyclerView.ViewHolder {

    View view;
    ImageView detail_imageIv;
    TextView detail_headingTv, detail_paragraph1tv, detail_paragraph2Tv;
    Context context;

    public HolderChapterDetails(@NonNull View itemView, Context c) {
        super(itemView);
        view = itemView;
        context = c;
    }

    public void setDetails(Context context, String chapterHeading, String chapterImage, String chapterDetail1, String chapterDetail2) {

        detail_headingTv = view.findViewById(R.id.detail_headingId);
        detail_imageIv = view.findViewById(R.id.detail_imageId);
        detail_paragraph1tv = view.findViewById(R.id.detail_paragraph1Id);
        detail_paragraph2Tv = view.findViewById(R.id.detail_paragraph2Id);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            detail_paragraph1tv.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
            detail_paragraph2Tv.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }

        detail_headingTv.setText(chapterHeading);
        detail_paragraph1tv.setText(chapterDetail1);
        detail_paragraph2Tv.setText(chapterDetail2);
        Glide.with(context).load(chapterImage).into(detail_imageIv);
    }
}
