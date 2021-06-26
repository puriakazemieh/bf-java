package com.example.batmanfilm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.batmanfilm.R;
import com.example.batmanfilm.model.RatingsItem;

import java.util.ArrayList;
import java.util.List;

public class AdapterRatings extends RecyclerView.Adapter<AdapterRatings.CommentViewHolder>{
    private List<RatingsItem>commentProductList = new ArrayList<>();

    public AdapterRatings(List<RatingsItem> commentProductList){
        this.commentProductList=commentProductList;
    }


    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rating,parent,false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {

        holder.bindComment(commentProductList.get(position));
    }

    @Override
    public int getItemCount() {
        return commentProductList.size();
    }

    public class  CommentViewHolder extends RecyclerView.ViewHolder {
        private TextView source,value;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            source = itemView.findViewById(R.id.source);
            value = itemView.findViewById(R.id.value);

        }
        public void bindComment(RatingsItem commentProduct)
        {
            source.setText(commentProduct.getSource());
            value.setText(commentProduct.getValue());
        }
    }
}
