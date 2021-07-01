package com.example.batmanfilm.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.batmanfilm.R;
import com.example.batmanfilm.activity.DetailActivity;
import com.example.batmanfilm.model.MoveDataModel;
import com.example.batmanfilm.model.SearchItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.BannerViewHolder> {
   // private List<MoveDataModel> searchItems = new ArrayList<>();
private MoveDataModel searchItem;


    public AdapterMovie(MoveDataModel cartItem) {
        this.searchItem = cartItem;
    }


    @NonNull
    @io.reactivex.annotations.NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull @io.reactivex.annotations.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @io.reactivex.annotations.NonNull BannerViewHolder holder, int position) {
      //  holder.bindBanner(searchItems.get(position));
        ((BannerViewHolder) holder).bindBanner(searchItem.getSearch().get(position));
    }

    @Override
    public int getItemCount() {
        return searchItem.getSearch().size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView poster;
        private TextView title,year,Type,imdbID;

        public BannerViewHolder(@NonNull @io.reactivex.annotations.NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.img_poster);
            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            imdbID = itemView.findViewById(R.id.imdbID);
            Type = itemView.findViewById(R.id.Type);
        }

        public void bindBanner(SearchItem searchItem) {

            Picasso.get().load(searchItem.getPoster()).placeholder(R.drawable.ic_launcher_background).into(poster);
            title.setText("title: "+searchItem.getTitle());
            year.setText("year: "+searchItem.getYear());
            imdbID.setText("imdbID: "+searchItem.getImdbID());
            Type.setText("Type: "+searchItem.getType());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("id", searchItem.getImdbID());
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}

