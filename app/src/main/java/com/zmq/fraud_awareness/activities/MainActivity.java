package com.zmq.fraud_awareness.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.zmq.fraud_awareness.R;

public class MainActivity extends BaseActivity {

    Button btnFrauds, btnArticles, btnVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setup toolbar without back button (this is the main activity)
        setupMainToolbar();

        // Initialize views
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        btnFrauds = findViewById(R.id.btn_frauds);
        btnArticles = findViewById(R.id.btn_articles);
        btnVideos = findViewById(R.id.btn_videos);
    }

    private void setupClickListeners() {
        btnFrauds.setOnClickListener(view -> {
            startActivity(new Intent(this, FraudListActivity.class));
        });

        btnArticles.setOnClickListener(view -> {
            startActivity(new Intent(this, ArticleListActivity.class));
        });

        btnVideos.setOnClickListener(view -> {
            startActivity(new Intent(this, VideoListActivity.class));
        });
    }
}
