package com.zmq.fraud_awareness.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zmq.fraud_awareness.R;

public class VideoListActivity extends BaseActivity {

    String[] videoTitles = {
        "UPI Fraud Awareness",
        "OTP Scam Explained",
        "SIM Swap Attack"
    };

    int[] videoResIds = {
        R.raw.upi_fraud,
        R.raw.otp_scam,
        R.raw.sim_swap
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        // Setup toolbar with back button
        setupChildToolbar();

        // Initialize views and setup list
        initializeViews();
        setupVideoList();
    }

    private void initializeViews() {
        listView = findViewById(R.id.video_list_view);
    }

    private void setupVideoList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, videoTitles);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, VideoPlayerActivity.class);
            intent.putExtra("videoResId", videoResIds[i]);
            intent.putExtra("videoTitle", videoTitles[i]);
            startActivity(intent);
        });
    }
}
