package com.example.convertisseurtempraturedistance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TempFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        RadioGroup rgTemp = view.findViewById(R.id.rgTemp);
        RadioButton rbCtoF = view.findViewById(R.id.rbCtoF);
        EditText etInput = view.findViewById(R.id.etTempInput);
        Button btnConvert = view.findViewById(R.id.btnConvertTemp);
        TextView tvResult = view.findViewById(R.id.tvTempResult);

        btnConvert.setOnClickListener(v -> {
            String valStr = etInput.getText().toString();
            if (valStr.isEmpty()) {
                Toast.makeText(getContext(), "Entrez une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double val = Double.parseDouble(valStr);
            double res = rbCtoF.isChecked() ? (val * 1.8 + 32) : ((val - 32) / 1.8);
            String unite = rbCtoF.isChecked() ? "°F" : "°C";
            tvResult.setText(String.format("Résultat : %.2f %s", res, unite));
        });

        return view;
    }
}