package com.example.geeks_3_hw_2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeks_3_hw_2.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class ThirdFragment extends Fragment {

    MaterialButton buttonFinish;
    AppCompatEditText editTextStudyAddress;
    AppCompatEditText editTextJobAddress;
    InfoFragment infoFragment = new InfoFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findView();
        setOnClick();
    }

    private void findView() {
        buttonFinish = requireActivity().findViewById(R.id.button_finish);
        editTextStudyAddress = requireActivity().findViewById(R.id.edit_text_study_address);
        editTextJobAddress = requireActivity().findViewById(R.id.edit_text_job_address);
    }

    private void setOnClick() {
        buttonFinish.setOnClickListener(v -> {
            putElements();
            navigate();
        });
    }

    private void navigate() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new InfoFragment())
                .addToBackStack(null)
                .commit();
    }

    private void putElements() {
        Bundle bundle = new Bundle();
        bundle.putString("name", getArguments() != null ? getArguments().getString("name") : null);
        bundle.putString("lastName", getArguments().getString("lastName"));
        bundle.putString("age", getArguments().getString("age"));
        bundle.putString("gender", getArguments().getString("gender"));
        bundle.putString("studyAddress", Objects.requireNonNull(editTextStudyAddress.getText()).toString());
        bundle.putString("jobAddress", Objects.requireNonNull(editTextJobAddress.getText()).toString());
        infoFragment.setArguments(bundle);
    }
}