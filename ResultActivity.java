package com.geeks.hw25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.geeks.hw25.MainActivity;
import com.geeks.hw25.R;

public class ResultActivity extends AppCompatActivity {

    private Button hiddenButton;
    private TextView resultText;
    private boolean isEqualClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hiddenButton = findViewById(R.id.hiddenButton);
        resultText = findViewById(R.id.text_view);

        hiddenButton.setVisibility(View.GONE);

        Button equalsButton = findViewById(R.id.hiddenButton);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hiddenButton.setVisibility(View.VISIBLE);
                isEqualClicked = true;
            }
        });

        ImageButton otherButton = findViewById(R.id.btn_equal);
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEqualClicked) {
                    hiddenButton.setVisibility(View.GONE);
                    isEqualClicked = false;
                }
            }
        });

        hiddenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, ResultActivity.class);
                intent.putExtra("result", resultText.getText().toString());
                startActivity(intent);
            }
        });
    }
}


