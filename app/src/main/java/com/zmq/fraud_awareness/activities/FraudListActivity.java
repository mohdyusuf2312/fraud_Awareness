package com.zmq.fraud_awareness.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zmq.fraud_awareness.R;
import com.zmq.fraud_awareness.adapters.FraudAdapter;
import com.zmq.fraud_awareness.database.DBHelper;
import com.zmq.fraud_awareness.models.Fraud;

import java.util.List;

public class FraudListActivity extends BaseActivity {

    RecyclerView recyclerView;
    Button btnAddFraud;
    FraudAdapter adapter;
    DBHelper dbHelper;
    List<Fraud> fraudList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraud_list);

        // Setup toolbar with back button
        setupChildToolbar();

        // Initialize views and data
        initializeViews();
        setupRecyclerView();
        setupClickListeners();
    }

    private void initializeViews() {

        recyclerView = findViewById(R.id.recycler_frauds);
        btnAddFraud = findViewById(R.id.btn_add_fraud);

        dbHelper = new DBHelper(this);
    }

    private void setupRecyclerView() {

        fraudList = dbHelper.getAllFrauds();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FraudAdapter(fraudList);
        recyclerView.setAdapter(adapter);
    }

    private void setupClickListeners() {
        btnAddFraud.setOnClickListener(v -> {
            startActivity(new Intent(this, AddFraudActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fraudList.clear();
        fraudList.addAll(dbHelper.getAllFrauds());
        adapter.notifyDataSetChanged();
    }
}
