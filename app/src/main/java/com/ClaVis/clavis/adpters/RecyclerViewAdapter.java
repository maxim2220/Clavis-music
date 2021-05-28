package com.ClaVis.clavis.adpters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ClaVis.clavis.MainActivity;
import com.ClaVis.clavis.R;
import com.ClaVis.clavis.fracments.BazizucMenuFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


        private final LayoutInflater inflater;
        private final Fragment fragment;
        private final Integer[] id;
        private final String[] name;


    public RecyclerViewAdapter(Context context, Fragment fragment, Integer[] id, String[] name) {
            this.id = id;
            this.name = name;
            this.fragment = fragment;

            inflater = LayoutInflater.from(context);


        }

        private final class MyHolder extends RecyclerView.ViewHolder{

            private final TextView textView;
            protected final View view;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                view = itemView;
                textView = itemView.findViewById(R.id.tv_item);
            }
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.list_item, parent, false);

            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((MyHolder) holder).textView.setText(name[position]);
            ((MyHolder) holder).  view.setOnClickListener((view) ->{
                Bundle b = new Bundle();
                b.putSerializable(MainActivity.MSG_NAME, MainActivity.statsList.get(position));
                b.putSerializable(MainActivity.MSG_MODE, position);
                NavHostFragment.findNavController(fragment)
                        .navigate(id[position], b);
            });
        }

        @Override
        public int getItemCount() {
            return id.length;
        }
    }

