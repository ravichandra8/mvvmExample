package com.jd.mvvmexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jd.mvvmexample.repository.retrofit.model.Image;
import java.util.List;


public class HerosAdapter extends RecyclerView.Adapter<HerosAdapter.HeroViewHolder> {

    Context mCtx;
    List<Image> heroList;

    public HerosAdapter(Context mCtx, List<Image> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);

        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Image hero = heroList.get(position);
        Log.d("comments",hero.getTags());

        holder.textView.setText(hero.getId()+"");
        holder.name.setText(hero.getUser());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {


        TextView name;
        TextView textView;

        public HeroViewHolder(View mbinding) {
            super(mbinding);

            textView = itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
        }



    }
}