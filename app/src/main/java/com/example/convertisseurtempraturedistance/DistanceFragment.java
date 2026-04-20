package com.example.convertisseurtempraturedistance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        RadioGroup rgDist = view.findViewById(R.id.rgDist);
        RadioButton rbKmToMiles = view.findViewById(R.id.rbKmToMiles);
        EditText etInput = view.findViewById(R.id.etDistInput);
        Button btnConvert = view.findViewById(R.id.btnConvertDist);
        TextView tvResult = view.findViewById(R.id.tvDistResult);

        btnConvert.setOnClickListener(v -> {
            String valStr = etInput.getText().toString();
            if (valStr.isEmpty()) {
                Toast.makeText(getContext(), "Entrez une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double val = Double.parseDouble(valStr);
            double res = rbKmToMiles.isChecked() ? (val * 0.6214) : (val / 0.6214);
            String unite = rbKmToMiles.isChecked() ? "Miles" : "Km";
            tvResult.setText(String.format("Résultat : %.2f %s", res, unite));
        });

        return view;
    }
}