package com.ClaVis.clavis.fracments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ClaVis.clavis.R;
import com.ClaVis.clavis.adpters.ElementsAdapter;

public class PromeshtochniiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_promeshtochnii, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.rvpromesh);
        recyclerView.setAdapter(new ElementsAdapter(getActivity(), this, getArguments()));

        return v;
    }
}