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

public class SecondFragment extends Fragment {
    MaterialButton buttonNextSecond;
    AppCompatEditText editTextAge;
    AppCompatEditText editTextGender;
    ThirdFragment thirdFragment = new ThirdFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findView();
        setOnClick();
    }

    private void findView() {
        buttonNextSecond = requireActivity().findViewById(R.id.button_next_second);
        editTextAge = requireActivity().findViewById(R.id.edit_text_age);
        editTextGender = requireActivity().findViewById(R.id.edit_text_gender);
    }

    private void setOnClick() {
        buttonNextSecond.setOnClickListener(v -> {
            putElements();
            navigate();
        });
    }

    private void navigate() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, thirdFragment)
                .addToBackStack(null)
                .commit();
    }

    private void putElements() {
        Bundle bundle = new Bundle();
        if (getArguments() != null) {
            bundle.putString("name", getArguments().getString("name"));
            bundle.putString("lastName", getArguments().getString("lastName"));
            System.out.println(getArguments().getString("name"));
        }
        bundle.putString("age", Objects.requireNonNull(editTextAge.getText()).toString());
        bundle.putString("gender", Objects.requireNonNull(editTextGender.getText()).toString());
        thirdFragment.setArguments(bundle);
    }
}