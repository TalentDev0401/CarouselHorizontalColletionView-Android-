package com.coco.horizontalcarouselview.activity;

public class Gallery {

    private final String galleryName;
    private final int galleryIcon;

    public Gallery(String galleryName, int galleryIcon) {
        this.galleryIcon = galleryIcon;
        this.galleryName = galleryName;
    }

    public String getGalleryName() {
        return galleryName;
    }
    public int getGalleryIcon() {
        return galleryIcon;
    }
}

