package com.example.myapplicationrecycleviewjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHodler>{
    private ArrayList<Hero> listHero;

    public GridHeroAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }

    @NonNull
    @Override
    public GridViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero,parent,false);
        return new GridHeroAdapter.GridViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridHeroAdapter.GridViewHodler holder, int position) {
        Hero hero = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }


    public class GridViewHodler extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        public GridViewHodler(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
         }
    }


}
