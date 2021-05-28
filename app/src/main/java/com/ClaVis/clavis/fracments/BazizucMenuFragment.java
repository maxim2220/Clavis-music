package com.ClaVis.clavis.fracments;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ClaVis.clavis.MainActivity;
import com.ClaVis.clavis.R;
import com.ClaVis.clavis.adpters.RecyclerViewAdapter;


public class BazizucMenuFragment extends Fragment {
    @IdRes
    private Integer[] id = {R.id.action_bazizucMenuFragment_to_promeshtochniiFragment, R.id.action_bazizucMenuFragment_to_promeshtochniiFragment};
    private RecyclerView recyclerView;
    private String[] name = { MainActivity.statsList.get(0).getName(),
            MainActivity.statsList.get(1).getName(),
            MainActivity.statsList.get(2).getName()};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bazizuc_menu, container, false);
        recyclerView = v.findViewById(R.id.rvmenubaz);
        recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), this, id, name ));
        return v;
    }
}