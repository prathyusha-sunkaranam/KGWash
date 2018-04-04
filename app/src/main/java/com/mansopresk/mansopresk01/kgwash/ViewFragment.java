package com.mansopresk.mansopresk01.kgwash;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {
    View view;


    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);

        int layoutScreen = getArguments().getInt("screen_count");

        if (layoutScreen == 0) {
            view = inflater.inflate(R.layout.wash_iron, container, false);
        } else if (layoutScreen == 1) {
            view = inflater.inflate(R.layout.wash_fold, container, false);
        } else if (layoutScreen == 2) {
            view = inflater.inflate(R.layout.iron, container, false);
        }

        return view;
    }

    public static Fragment newInstance(int screenCount) {
        ViewFragment f = new ViewFragment();
        Bundle b = new Bundle();
        b.putInt("screen_count", screenCount);
        f.setArguments(b);
        return f;
    }



}


