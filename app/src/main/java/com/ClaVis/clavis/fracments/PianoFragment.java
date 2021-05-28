package com.ClaVis.clavis.fracments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ClaVis.clavis.MainActivity;
import com.ClaVis.clavis.R;
import com.ClaVis.clavis.model.Stats;

public class PianoFragment extends Fragment {
    private static ImageView imageView;
    private static TextView textView, textViewFailScore;
    public static String statsName;
    private static Integer mode;

    @SuppressLint("UseCompatLoadingForDrawables")
    public static void setImage(Context context) {
        int id = MainActivity.getIds()[((MainActivity) context).getTmp()];
        Log.i(MainActivity.TAG, "setImage: " + id);
        if (imageView != null && mode != null){
            switch (mode){
                case 0:
                    switch (id){
                        case R.id.bt1:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_doooskripich));
                            break;
                        case R.id.bt2:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_reskripich));
                            break;
                        case R.id.bt3:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_miskripich));
                            break;
                        case R.id.bt4:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_faskripich));
                            break;
                        case R.id.bt5:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_solskripich));
                            break;
                        case R.id.bt6:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_ljaskripich));
                            break;
                        case R.id.bt7:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_siiskripich));
                            break;
                    }
                    break;
                case 1:
                    switch (id){
                        case R.id.bt1:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_doo_bass));
                            break;
                        case R.id.bt2:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_re_bass));
                            break;
                        case R.id.bt3:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_mi_bass));
                            break;
                        case R.id.bt4:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_fa_bass));
                            break;
                        case R.id.bt5:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_sol_bass));
                            break;
                        case R.id.bt6:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_lia_bass));
                            break;
                        case R.id.bt7:
                            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_si_bass));
                            break;
                    }
                    break;
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_piano, container, false);
        imageView = v.findViewById(R.id.imv_nota);
        textView = v.findViewById(R.id.tv_score);
        textView.setText("Score: " + MainActivity.score);
        textViewFailScore = v.findViewById(R.id.tv_score_fail);
        textViewFailScore.setText("Score: " + MainActivity.fails_score);
        statsName = ((Stats)getArguments().getSerializable(MainActivity.MSG_NAME)).getName();

        mode = getArguments().getInt(MainActivity.MSG_MODE);

        setImage(getActivity());
        Log.i(MainActivity.TAG, "onCreateView: ");

        return v;
    }

    public static void setScore(Integer score){
        textView.setText("Score: " + score);
    }

    public static void setFailScore(Integer scoreFail){
        textViewFailScore.setText("Score: " + scoreFail);
    }

    @Override
    public void onResume() {
        super.onResume();
        setImage(getActivity());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (((MainActivity) getActivity()).getPreferences().getInt(statsName, 0) < MainActivity.score) {
            ((MainActivity) getActivity()).getPreferences().edit().putInt(statsName, MainActivity.score).apply();
        }
        MainActivity.score = 0;
        MainActivity.fails_score = 0;    }
}