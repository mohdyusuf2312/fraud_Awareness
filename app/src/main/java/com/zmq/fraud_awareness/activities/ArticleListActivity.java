package com.zmq.fraud_awareness.activities;

import android.os.Bundle;
import android.widget.ListView;

import com.zmq.fraud_awareness.R;
import com.zmq.fraud_awareness.adapters.ArticleAdapter;
import com.zmq.fraud_awareness.database.DBHelper;
import com.zmq.fraud_awareness.models.Article;

import java.util.List;

public class ArticleListActivity extends BaseActivity {

    ListView listView;
    DBHelper dbHelper;
    List<Article> articles;
    ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        // Setup toolbar with back button
        setupChildToolbar();

        // Initialize views and data
        initializeViews();
        loadArticles();
    }

    private void initializeViews() {
        listView = findViewById(R.id.article_list_view);
        dbHelper = new DBHelper(this);
    }

    private void loadArticles() {
        articles = dbHelper.getAllArticles();
        adapter = new ArticleAdapter(this, articles);
        listView.setAdapter(adapter);
    }
}
