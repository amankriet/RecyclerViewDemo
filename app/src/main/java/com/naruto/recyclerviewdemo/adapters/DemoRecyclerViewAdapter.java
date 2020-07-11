package com.naruto.recyclerviewdemo.adapters;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.recyclerviewdemo.R;

import java.util.List;

public class DemoRecyclerViewAdapter extends RecyclerView.Adapter<DemoRecyclerViewAdapter.MyViewHolder> {

    List<String> demoStrings;
    Context mContext;

//    private SelectionTracker selectionTracker;

    public DemoRecyclerViewAdapter(List<String> demoStrings, Context context) {
        this.demoStrings = demoStrings;
        this.mContext = context;
    }

//    public SelectionTracker getSelectionTracker() {
//        return selectionTracker;
//    }
//
//    public void setSelectionTracker(SelectionTracker selectionTracker) {
//        this.selectionTracker = selectionTracker;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_single_view, parent, false);
        MyViewHolder demoView = new MyViewHolder(view);
        return demoView;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

//        String item = demoStrings.get(position);
//
//        holder.bind(item, selectionTracker.isSelected(item));


        holder.demoTv.setText(demoStrings.get(position));
        holder.demoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.expandableDemoView.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(holder.demoCardView, new AutoTransition());
                    holder.expandableDemoView.setVisibility(View.VISIBLE);
                } else {
                    TransitionManager.beginDelayedTransition(holder.demoCardView, new AutoTransition());
                    holder.expandableDemoView.setVisibility(View.GONE);
                }
            }
        });

        holder.demoImageView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));

        switch (position) {
            case 0:
                holder.demoImageView.setImageResource(R.mipmap.ic_1);
                break;
            case 1:
                holder.demoImageView.setImageResource(R.mipmap.ic_2);
                break;
            case 2:
                holder.demoImageView.setImageResource(R.mipmap.ic_3);
                break;
            case 3:
                holder.demoImageView.setImageResource(R.mipmap.ic_4);
                break;
            case 4:
                holder.demoImageView.setImageResource(R.mipmap.ic_5);
                break;
            default:
                holder.demoImageView.setImageResource(R.mipmap.ic_6);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return demoStrings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView demoTv;
        ImageView demoImageView;
        CardView demoCardView;
        LinearLayout expandableDemoView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            demoTv = itemView.findViewById(R.id.tv_demo_text);
            demoImageView = itemView.findViewById(R.id.iv_demo);
            demoCardView = itemView.findViewById(R.id.cv_demo);
            expandableDemoView = itemView.findViewById(R.id.ll_expandable);
        }

//        public final void bind(String item, boolean isActive) {
//            itemView.setActivated(isActive);
////            itemPrice.setText(item.getItemPrice() + "$");
////            itemName.setText(item.getItemName());
////            itemId.setText(item.getItemId() + "");
//
//        }

//        @Override
//        public ItemDetailsLookup.ItemDetails getItemDetails() {
//            return new MyItemDetail(getAdapterPosition(), demoStrings.get(getAdapterPosition()));
//        }
    }
}
