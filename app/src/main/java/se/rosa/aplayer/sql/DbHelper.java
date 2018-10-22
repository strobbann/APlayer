package se.rosa.aplayer.sql;

import android.app.DownloadManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Robert on 26/09/18.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Aplayer.db";
    private static final int DB_VERSION = 1;

    private static DbHelper instance;

    public static synchronized DbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbHelper(context);
        }

        return instance;
    }

    private DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QueryHelper.Music.CREATE_TABLE_MUSIC + QueryHelper.Playlist.CREATE_TABLE_PLAYLIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(QueryHelper.Music.DROP_TABLE_MUSIC + QueryHelper.Playlist.DROP_TABLE_PLAYLIST);
        onCreate(db);
    }
}
