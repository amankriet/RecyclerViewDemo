package com.naruto.recyclerviewdemo.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemKeyProvider;

import java.util.List;

public class MyItemKeyProvider extends ItemKeyProvider {

    private final List<String> demoStrings;

    public MyItemKeyProvider(int i, List<String> demoStrings) {
        super(i);
        this.demoStrings = demoStrings;
    }

    @Nullable
    @Override
    public Object getKey(int position) {
        return demoStrings.get(position);
    }

    @Override
    public int getPosition(@NonNull Object key) {
        return demoStrings.indexOf(key);
    }
}
