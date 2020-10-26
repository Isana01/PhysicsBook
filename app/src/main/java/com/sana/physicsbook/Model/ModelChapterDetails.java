package com.sana.physicsbook.Model;

public class ModelChapterDetails {

    String chapterDetail1, chapterDetail2, chapterHeading, chapterImage;

    public ModelChapterDetails() {
    }

    public ModelChapterDetails(String chapterDetail1, String chapterDetail2, String chapterHeading, String chapterImage) {
        this.chapterDetail1 = chapterDetail1;
        this.chapterDetail2 = chapterDetail2;
        this.chapterHeading = chapterHeading;
        this.chapterImage = chapterImage;
    }

    public String getChapterDetail1() {
        return chapterDetail1;
    }

    public void setChapterDetail1(String chapterDetail1) {
        this.chapterDetail1 = chapterDetail1;
    }

    public String getChapterDetail2() {
        return chapterDetail2;
    }

    public void setChapterDetail2(String chapterDetail2) {
        this.chapterDetail2 = chapterDetail2;
    }

    public String getChapterHeading() {
        return chapterHeading;
    }

    public void setChapterHeading(String chapterHeading) {
        this.chapterHeading = chapterHeading;
    }

    public String getChapterImage() {
        return chapterImage;
    }

    public void setChapterImage(String chapterImage) {
        this.chapterImage = chapterImage;
    }
}
