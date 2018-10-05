package com.willblaschko.android.alexavoicelibrary.actions;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.willblaschko.android.alexavoicelibrary.R;

public class ShowDisplayFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.randertemplate, container, false);
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView body = (TextView)view.findViewById(R.id.body);

        String titleb = getArguments().getString("title");
        String bodyb = getArguments().getString("body");

        title.setText(titleb);
        body.setText(bodyb);

        return view;
    }
}
