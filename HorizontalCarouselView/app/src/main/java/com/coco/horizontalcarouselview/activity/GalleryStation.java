package com.coco.horizontalcarouselview.activity;

import com.coco.horizontalcarouselview.R;

import java.util.Arrays;
import java.util.List;

public class GalleryStation {


    public static GalleryStation get() {
        return new GalleryStation();
    }

    private GalleryStation() {
    }

    public List<Gallery> getData() {
        return Arrays.asList(
                new Gallery("Everyday Candle", R.drawable.shop1),
                new Gallery("Small Porcelain Bowl", R.drawable.shop2),
                new Gallery("Favourite Board", R.drawable.shop3),
                new Gallery("Earthenware Bowl", R.drawable.shop4),
                new Gallery("Porcelain Dessert Plate", R.drawable.shop5),
                new Gallery("Detailed Rolling Pin", R.drawable.shop6));
    }
}
