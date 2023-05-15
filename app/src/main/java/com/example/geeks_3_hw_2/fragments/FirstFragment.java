package com.example.geeks_3_hw_2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.geeks_3_hw_2.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class FirstFragment extends Fragment {

    AppCompatEditText editTextName;
    AppCompatEditText editTextLastName;
    MaterialButton buttonNext;

    SecondFragment secondFragment = new SecondFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findView();
        setOnClick();
    }

    private void findView() {
        buttonNext = requireActivity().findViewById(R.id.button_next_first);
        editTextName = requireActivity().findViewById(R.id.edit_text_name);
        editTextLastName = requireActivity().findViewById(R.id.edit_text_lastname);
    }

    private void setOnClick() {
        buttonNext.setOnClickListener(v -> {
            putElements();
            if (editTextName.getText().toString().isEmpty() || editTextLastName.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Fill in all fields!", Toast.LENGTH_SHORT).show();
            } else {
                putElements();
                replaceFragment();
            }
        });
    }

    private void putElements() {
        Bundle bundle = new Bundle();
        bundle.putString("name", Objects.requireNonNull(editTextName.getText()).toString());
        bundle.putString("lastName", Objects.requireNonNull(editTextLastName.getText()).toString());
        secondFragment.setArguments(bundle);
    }

    private void replaceFragment() {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, secondFragment)
                .addToBackStack(null)
                .commit();
    }
}