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


public class Activity2_2fragment extends Fragment {
    private RecyclerView recyclerView1;
    private Integer[] id = {R.id.action_activity2_2fragment_to_bazizucMenuFragment, R.id.action_activity2_2fragment_to_nots_and_tabsFragment};
    private String[] name = {"Базовое изучение", "Ноты"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_activity2_2fragment, container, false);
        recyclerView1 = v.findViewById(R.id.rv);
        recyclerView1.setAdapter(new RecyclerViewAdapter(getActivity(), this, id, name));


        return v;

    }


    public static Activity2_2fragment getInstance(String s){
        Activity2_2fragment fragment = new Activity2_2fragment();
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.MSG_NAME, s);
        fragment.setArguments(bundle);
        return fragment;
    }

}