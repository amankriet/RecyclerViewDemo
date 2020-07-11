package com.naruto.recyclerviewdemo.activities;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.recyclerviewdemo.R;
import com.naruto.recyclerviewdemo.adapters.DemoRecyclerViewAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView demoRecyclerView;
    DemoRecyclerViewAdapter demoAdapter;
    RecyclerView.LayoutManager llManager;

    MenuItem selectedItemCount;
    SelectionTracker selectionTracker;
    private ActionMode actionMode;

    private static final int SPAN_COUNT = 2;
    List<String> demoStrings = Arrays.asList("First", "Second", "Third", "Fourth", "Fifth");
    private String TAG = "MainActivity";

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        demoRecyclerView = findViewById(R.id.rv_demo);
        llManager = new LinearLayoutManager(this);
        demoRecyclerView.setLayoutManager(llManager);

        runAnimationController();

        demoAdapter = new DemoRecyclerViewAdapter(demoStrings, demoRecyclerView.getContext());
        demoRecyclerView.setAdapter(demoAdapter);

//        selectionTracker = new SelectionTracker.Builder<>(
//                "my-selection-id",
//                demoRecyclerView,
//                new MyItemKeyProvider(1, demoStrings),
//                new MyItemLookup(demoRecyclerView),
//                StorageStrategy.createLongStorage()
//        )
//                .withOnItemActivatedListener(new OnItemActivatedListener<Long>() {
//                    @Override
//                    public boolean onItemActivated(@NonNull ItemDetailsLookup.ItemDetails<Long> item, @NonNull MotionEvent e) {
//                        Log.d(TAG, "Selected ItemId: " + item.toString());
//                        return true;
//                    }
//                })
//                .withOnDragInitiatedListener(new OnDragInitiatedListener() {
//                    @Override
//                    public boolean onDragInitiated(@NonNull MotionEvent e) {
//                        Log.d("TAG", "onDragInitiated");
//                        return true;
//                    }
//
//                })
//                .build();
//        demoAdapter.setSelectionTracker(selectionTracker);
//        selectionTracker.addObserver(new SelectionTracker.SelectionObserver() {
//            @Override
//            public void onItemStateChanged(@NonNull Object key, boolean selected) {
//                super.onItemStateChanged(key, selected);
//            }
//
//            @Override
//            public void onSelectionRefresh() {
//                super.onSelectionRefresh();
//            }
//
//            @Override
//            public void onSelectionChanged() {
//                super.onSelectionChanged();
//                if (selectionTracker.hasSelection() && actionMode == null) {
//                    actionMode = startSupportActionMode(new ActionModeController(MainActivity.this, selectionTracker));
//                    setMenuItemTitle(selectionTracker.getSelection().size());
//                } else if (!selectionTracker.hasSelection() && actionMode != null) {
//                    actionMode.finish();
//                    actionMode = null;
//                } else {
//                    setMenuItemTitle(selectionTracker.getSelection().size());
//                }
//                Iterator<String> itemIterable = selectionTracker.getSelection().iterator();
//                while (itemIterable.hasNext()) {
//                    Log.i(TAG, itemIterable.next().getItemName());
//                }
//            }
//
//            @Override
//            public void onSelectionRestored() {
//                super.onSelectionRestored();
//            }
//        });
//
//        if (savedInstanceState != null) {
//            selectionTracker.onRestoreInstanceState(savedInstanceState);
//        }
    }

    private void runAnimationController() {
        LayoutAnimationController controller = AnimationUtils
                .loadLayoutAnimation(demoRecyclerView.getContext(), R.anim.layout_slide_from_left);
        demoRecyclerView.setLayoutAnimation(controller);
    }

    public void setGridLayoutManager(View view) {
        if (mCurrentLayoutManagerType == LayoutManagerType.LINEAR_LAYOUT_MANAGER) {
            llManager = new GridLayoutManager(this, SPAN_COUNT);
            mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
            demoRecyclerView.setLayoutManager(llManager);
            runAnimationController();
        }
    }

    public void setLinearLayoutManager(View view) {
        if (mCurrentLayoutManagerType == LayoutManagerType.GRID_LAYOUT_MANAGER) {
            llManager = new LinearLayoutManager(this);
            mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
            demoRecyclerView.setLayoutManager(llManager);
            runAnimationController();
        }
    }

//    public void setMenuItemTitle(int selectedItemSize) {
//        selectedItemCount.setTitle("" + selectedItemSize);
//    }
}