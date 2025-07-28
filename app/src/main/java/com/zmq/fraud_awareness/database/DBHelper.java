package com.zmq.fraud_awareness.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.database.Cursor;

import com.zmq.fraud_awareness.models.Fraud;
import java.util.ArrayList;
import java.util.List;

import com.zmq.fraud_awareness.models.Article;
import com.zmq.fraud_awareness.models.VideoItem;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "fraud_awareness.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Fraud Table
        db.execSQL(
            "CREATE TABLE frauds (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "title TEXT, " +
            "description TEXT, " +
            "category TEXT, " +
            "date TEXT)"
        );

        // Articles Table
        db.execSQL(
            "CREATE TABLE articles (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "title TEXT, " +
            "content TEXT, " +
            "category TEXT, " +
            "date TEXT)"
        );

        // Videos Table
        db.execSQL(
            "CREATE TABLE videos (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "title TEXT, " +
            "filename TEXT, " +           // e.g., "upi_tips.mp4"
            "description TEXT)"
        );
        
        // Insert sample data
        insertSampleData(db);
    }

    private void insertSampleData(SQLiteDatabase db) {
        // Insert sample fraud cases
        db.execSQL("INSERT INTO frauds (title, description, category, date) VALUES " +
            "('UPI Fraud Case', 'Fraudster asked for UPI PIN and transferred money', 'UPI Scam', '2025-07-15')");
        db.execSQL("INSERT INTO frauds (title, description, category, date) VALUES " +
            "('OTP Scam', 'Received fake call asking for OTP verification', 'Phone Scam', '2025-06-10')");

        // Insert sample articles
        db.execSQL("INSERT INTO articles (title, content, category, date) VALUES " +
            "('How to Stay Safe from UPI Fraud', 'Never share your UPI PIN with anyone. Banks never ask for PIN over phone or SMS.', 'Safety Tips', '2025-06-01')");
        db.execSQL("INSERT INTO articles (title, content, category, date) VALUES " +
            "('Recognizing Phone Scams', 'Be cautious of calls claiming to be from banks or government agencies asking for personal information.', 'Awareness', '2025-06-05')");
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // For upgrade logic
        db.execSQL("DROP TABLE IF EXISTS frauds");
        db.execSQL("DROP TABLE IF EXISTS articles");
        db.execSQL("DROP TABLE IF EXISTS videos");
        onCreate(db);
    }

    public void insertFraud(Fraud fraud) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", fraud.getTitle());
        values.put("description", fraud.getDescription());
        values.put("category", fraud.getCategory());
        values.put("date", fraud.getDate());

        db.insert("frauds", null, values);
        db.close();
    }

    public List<Fraud> getAllFrauds() {
        List<Fraud> fraudList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM frauds", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String description = cursor.getString(2);
                String category = cursor.getString(3);
                String date = cursor.getString(4);

                fraudList.add(new Fraud(id, title, description, category, date));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return fraudList;
    }

    public void insertArticle(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", article.getTitle());
        values.put("content", article.getContent());
        values.put("category", article.getCategory());
        values.put("date", article.getDate());

        db.insert("articles", null, values);
        db.close();
    }

    public List<Article> getAllArticles() {
        List<Article> articleList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM articles", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String content = cursor.getString(2);
                String category = cursor.getString(3);
                String date = cursor.getString(4);

                articleList.add(new Article(id, title, content, category, date));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return articleList;
    }

    public void insertVideo(VideoItem video) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", video.getTitle());
        values.put("filename", video.getFilename());  // e.g., "upi_fraud_tips.mp4"
        values.put("description", video.getDescription());

        db.insert("videos", null, values);
        db.close();
    }

    public List<VideoItem> getAllVideos() {
        List<VideoItem> videoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM videos", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String filename = cursor.getString(2);
                String description = cursor.getString(3);

                videoList.add(new VideoItem(id, title, filename, description));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return videoList;
    }

}
