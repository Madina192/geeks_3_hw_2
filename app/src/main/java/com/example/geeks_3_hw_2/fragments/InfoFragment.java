package com.example.geeks_3_hw_2.fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeks_3_hw_2.R;
public class InfoFragment extends Fragment {

    AppCompatTextView textViewName;
    AppCompatTextView textViewLastName;
    AppCompatTextView textViewAge;
    AppCompatTextView textViewGender;
    AppCompatTextView textViewStudyAddress;
    AppCompatTextView textViewJobAddress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        setTextForViews();
    }

    private void findView() {
        textViewName = requireActivity().findViewById(R.id.text_view_name);
        textViewLastName = requireActivity().findViewById(R.id.text_view_lastname);
        textViewAge = requireActivity().findViewById(R.id.text_view_age);
        textViewGender = requireActivity().findViewById(R.id.text_view_gender);
        textViewStudyAddress = requireActivity().findViewById(R.id.text_view_study_address);
        textViewJobAddress = requireActivity().findViewById(R.id.text_view_job_address);
    }

    private void setTextForViews() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            textViewName.setText(bundle.getString("name"));
            textViewLastName.setText(getArguments().getString("lastName"));
            textViewAge.setText(getArguments().getString("age"));
            textViewGender.setText(getArguments().getString("gender"));
            textViewStudyAddress.setText(getArguments().getString("studyAddress"));
            textViewJobAddress.setText(getArguments().getString("jobAddress"));
        }

    }
}