package com.ClaVis.clavis.fracments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ClaVis.clavis.MainActivity;
import com.ClaVis.clavis.R;
import com.ClaVis.clavis.adpters.RecyclerViewAdapter;
import com.ClaVis.clavis.model.Stats;

public class Nots_and_tabsFragment extends Fragment {
    private Integer[] id = {};
    private RecyclerView recyclerView;
    private String[] name = { MainActivity.statsList.get(0).getName(),
            MainActivity.statsList.get(1).getName(),
            MainActivity.statsList.get(2).getName(),
            "", ""};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nots_and_tabs, container, false);

        return v;
    }
}