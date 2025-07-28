// adapters/ArticleAdapter.java
package com.zmq.fraud_awareness.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zmq.fraud_awareness.R;
import com.zmq.fraud_awareness.models.Article;

import java.util.List;

public class ArticleAdapter extends BaseAdapter {

    Context context;
    List<Article> articleList;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articleList = articles;
    }

    @Override
    public int getCount() { return articleList.size(); }

    @Override
    public Object getItem(int position) { return articleList.get(position); }

    @Override
    public long getItemId(int position) { return articleList.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.article_item, parent, false);
        TextView title = view.findViewById(R.id.article_title);
        TextView content = view.findViewById(R.id.article_content);

        Article article = articleList.get(position);
        title.setText(article.getTitle());
        content.setText(article.getContent());

        return view;
    }
}
