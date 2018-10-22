package se.rosa.aplayer.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Arrays;

import se.rosa.aplayer.model.Music;
import se.rosa.aplayer.sql.DbContract;
import se.rosa.aplayer.sql.DbHelper;

/**
 * Created by Robert on 25/09/18.
 */

public class MusicRepository implements Repository<Music>{

    private static MusicRepository instance;

    public static synchronized MusicRepository getInstance(Context context) {
        if (instance == null) {
            instance = new MusicRepository(context);
        }

        return instance;
    }

    private final SQLiteDatabase database;

    private MusicRepository(Context context) {
        database = DbHelper.getInstance(context).getWritableDatabase();
    }

    private ContentValues getContentValues(Music music) {
        ContentValues cv = new ContentValues();
        cv.put(DbContract.MusicEntry.COLUMN_NAME_ANDROID_MUSIC_ID, music.getAndroidMusicId());
        return cv;
    }

    public String getcount() {
        String sqlQuery = "Select * from " + DbContract.MusicEntry.TABLE_NAME;
        return Arrays.toString(database.rawQuery(sqlQuery, null, null).getColumnNames());
    }


    @Override
    public long addOrUpdate(Music music) {
        ContentValues cv = getContentValues(music);
        return database.insert(DbContract.MusicEntry.TABLE_NAME, null, cv);
    }

    @Override
    public int getItem(int id) {
        return 0;
    }

    @Override
    public int deleteItem(Music music) {
        return 0;
    }
}
