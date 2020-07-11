//package com.naruto.recyclerviewdemo.utils;
//
//import android.view.MotionEvent;
//import android.view.View;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.recyclerview.selection.ItemDetailsLookup;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.naruto.recyclerviewdemo.adapters.DemoRecyclerViewAdapter;
//
//public class MyItemLookup extends ItemDetailsLookup {
//
//    private final RecyclerView recyclerView;
//
//    public MyItemLookup(RecyclerView demoRecyclerView) {
//        this.recyclerView = demoRecyclerView;
//    }
//
//    @Nullable
//    @Override
//    public ItemDetails getItemDetails(@NonNull MotionEvent e) {
//        View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
//        if (view != null) {
//            RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
//            if (viewHolder instanceof DemoRecyclerViewAdapter.MyViewHolder) {
//                return ((DemoRecyclerViewAdapter.MyViewHolder) viewHolder).getItemDetails();
//            }
//        }
//
//        return null;
//    }
//}
