package com.ClaVis.clavis.fracments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ClaVis.clavis.MainActivity;
import com.ClaVis.clavis.R;
import com.ClaVis.clavis.adpters.InfoAdapter;
import com.ClaVis.clavis.model.Stats;

import java.util.LinkedList;
import java.util.List;


public class Info_Fragment extends Fragment {

    private Stats stats;
    private List<Stats> statsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info_, container, false);


        stats = (Stats) getArguments().getSerializable(MainActivity.MSG_NAME);
        Log.i(MainActivity.TAG, "onCreateView: " + stats.toString());
        statsList = stats.getList();

        RecyclerView recyclerView = v.findViewById(R.id.rv_info);
        recyclerView.setAdapter(new InfoAdapter(statsList, getActivity()));
        return v;
    }
}