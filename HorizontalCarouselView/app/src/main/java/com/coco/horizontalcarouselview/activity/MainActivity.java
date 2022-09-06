package com.coco.horizontalcarouselview.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.coco.horizontalcarouselview.R;
import com.coco.horizontalcarouselview.library.DiscreteScrollView;
import com.coco.horizontalcarouselview.library.transform.ScaleTransformer;

import java.util.List;

public class MainActivity extends AppCompatActivity implements
        DiscreteScrollView.ScrollStateChangeListener<GalleryAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<GalleryAdapter.ViewHolder>, GalleryAdapter.onItemClickListener {

    private List<Gallery> galleries;
    private DiscreteScrollView galleryPicker;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        galleries = GalleryStation.get().getData();
        galleryPicker = findViewById(R.id.item_picker);
        textView = findViewById(R.id.textView);
        galleryPicker.setSlideOnFling(true);
        galleryPicker.setAdapter(new GalleryAdapter(galleries, MainActivity.this));
        galleryPicker.addOnItemChangedListener(this);
        galleryPicker.addScrollStateChangeListener(this);
        galleryPicker.scrollToPosition(2);
        galleryPicker.setItemTransitionTimeMillis(150);
        galleryPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());
    }

    @Override
    public void onCurrentItemChanged(@Nullable GalleryAdapter.ViewHolder holder, int position) {
        //viewHolder will never be null, because we never remove items from adapter's list
        if (holder != null) {
            Gallery gallery = galleries.get(position);
            textView.setText(gallery.getGalleryName());
        }
    }

    @Override
    public void onScrollStart(@NonNull GalleryAdapter.ViewHolder holder, int position) {
    }

    @Override
    public void onScroll(
            float position,
            int currentIndex, int newIndex,
            @Nullable GalleryAdapter.ViewHolder currentHolder,
            @Nullable GalleryAdapter.ViewHolder newHolder) {
        Gallery current = galleries.get(currentIndex);
        RecyclerView.Adapter<?> adapter = galleryPicker.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (newIndex >= 0 && newIndex < itemCount) {
            Gallery next = galleries.get(newIndex);
        }
    }

    @Override
    public void onScrollEnd(@NonNull GalleryAdapter.ViewHolder holder, int position) {

    }

    /*
     * Gallery Adapter click listener callback.
     */
    @Override
    public void onContainerClick(int position) {
        Toast.makeText(getApplicationContext(), "Item Clicked: " + position, Toast.LENGTH_LONG).show();
    }
}