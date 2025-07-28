package com.zmq.fraud_awareness.activities;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.TextView;

import com.zmq.fraud_awareness.R;

public class VideoPlayerActivity extends BaseActivity {

    VideoView videoView;
    int videoResId;
    String videoTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        // Setup toolbar with back button
        setupChildToolbar();

        // Get intent data
        videoResId = getIntent().getIntExtra("videoResId", -1);
        videoTitle = getIntent().getStringExtra("videoTitle");

        setTitle(videoTitle);
        // Update toolbar title
        updateToolbarTitle(videoTitle);

        // Initialize video player
        initializeVideoPlayer();
    }

    private void updateToolbarTitle(String title) {
        if (toolbar != null) {
            TextView toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
            if (toolbarTitle != null && title != null) {
                toolbarTitle.setText(title);
            }
        }
    }

    private void initializeVideoPlayer() {
        videoView = findViewById(R.id.video_view);

        if (videoResId != -1) {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResId);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            videoView.requestFocus();
            videoView.start();
        }
    }
}
