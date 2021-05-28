package com.ClaVis.clavis.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ClaVis.clavis.R;
import com.ClaVis.clavis.model.Stats;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Stats> statsList;
    private final LayoutInflater inflater;

    public InfoAdapter(List<Stats> statsList, Context context) {
        this.statsList = statsList;
        this.inflater = LayoutInflater.from(context);
    }

    private static final class MyHolder extends RecyclerView.ViewHolder{

        private final TextView name, info;
        private final ImageView image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            info = itemView.findViewById(R.id.tv_info);
            image = itemView.findViewById(R.id.iv_image);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_info_imafe, null, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Stats stats = statsList.get(position);
        ((MyHolder) holder).name.setText(stats.getName());
        ((MyHolder) holder).info.setText(stats.getInfo());
        if(stats.getBitmap() != null) ((MyHolder) holder).image.setImageBitmap(stats.getBitmap());
    }

    @Override
    public int getItemCount() {
        return statsList.size();
    }
}
