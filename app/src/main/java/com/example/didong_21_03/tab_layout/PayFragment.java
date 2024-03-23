package com.example.didong_21_03.tab_layout;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.didong_21_03.R;

public class PayFragment extends Fragment {

    private TextView textView;

    public PayFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);

        textView = view.findViewById(R.id.del);
        applyStrikethroughText();

        return view;
    }

    private void applyStrikethroughText() {
        String text = "₹2,999";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new StrikethroughSpan(), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }
}
