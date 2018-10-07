package com.example.sarve.projectlife;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.tapsong1)
    public void goSong1() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/eAfyFTzZDMM")));
    }
    @OnClick(R.id.tapsong2)
    public void goSong2() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/r0U0AlLVqpk")));
    }

    @OnClick(R.id.tapsong3)
    public void goSong3() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/eHbNU9WuVgw")));
    }


}
