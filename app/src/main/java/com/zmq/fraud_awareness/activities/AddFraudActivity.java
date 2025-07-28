package com.zmq.fraud_awareness.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zmq.fraud_awareness.R;
import com.zmq.fraud_awareness.database.DBHelper;
import com.zmq.fraud_awareness.models.Fraud;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddFraudActivity extends BaseActivity {

    EditText edtTitle, edtDescription, edtCategory;
    Button btnSubmit;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fraud);

        // Setup toolbar with back button
        setupChildToolbar();

        // Initialize views and setup
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        edtTitle = findViewById(R.id.edt_title);
        edtDescription = findViewById(R.id.edt_description);
        edtCategory = findViewById(R.id.edt_category);
        btnSubmit = findViewById(R.id.btn_submit);

        dbHelper = new DBHelper(this);
    }

    private void setupClickListeners() {
        btnSubmit.setOnClickListener(view -> {
            String title = edtTitle.getText().toString().trim();
            String description = edtDescription.getText().toString().trim();
            String category = edtCategory.getText().toString().trim();
            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

            if (title.isEmpty() || description.isEmpty() || category.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.insertFraud(new Fraud(title, description, category, date));
                Toast.makeText(this, "Fraud case added!", Toast.LENGTH_SHORT).show();
                finish(); // go back to list
            }
        });
    }
}
