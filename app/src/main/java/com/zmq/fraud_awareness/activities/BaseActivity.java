package com.zmq.fraud_awareness.activities;

import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.zmq.fraud_awareness.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    /**
     * Setup toolbar with back button (for child activities)
     * @param showBackButton whether to show the back button
     */
    protected void setupToolbar(boolean showBackButton) {
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false); // Hide default title
                getSupportActionBar().setDisplayHomeAsUpEnabled(showBackButton);
                getSupportActionBar().setDisplayShowHomeEnabled(showBackButton);
                
                if (showBackButton) {
                    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
                }
            }
        }
    }

    /**
     * Setup toolbar for MainActivity (no back button)
     */
    protected void setupMainToolbar() {
        setupToolbar(false);
    }

    /**
     * Setup toolbar for child activities (with back button)
     */
    protected void setupChildToolbar() {
        setupToolbar(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}