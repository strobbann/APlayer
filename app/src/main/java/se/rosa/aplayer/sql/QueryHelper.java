package se.rosa.aplayer.sql;

/**
 * Created by Robert on 18/10/18.
 */

public class QueryHelper {

    public static class Music {

        public static final String CREATE_TABLE_MUSIC =
                "CREATE TABLE " + DbContract.MusicEntry.TABLE_NAME + " (" +
                        DbContract.MusicEntry._ID + " INT PRIMARY KEY AUTOINCREMENT, " +
                        DbContract.MusicEntry.COLUMN_NAME_ANDROID_MUSIC_ID + " INT NOT NULL);";

        public static final String DROP_TABLE_MUSIC =
                "DROP TABLE IF EXISTS " + DbContract.MusicEntry.TABLE_NAME + ";";
    }

    public static class Playlist {
        public static final String CREATE_TABLE_PLAYLIST =
                "CREATE TABLE " + DbContract.Playlist.TABLE_NAME + " (" +
                        DbContract.Playlist._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        DbContract.Playlist.COLUMN_NAME_PLAYLIST_NAME + " TEXT NOT NULL);";

        public static final String DROP_TABLE_PLAYLIST =
                "DROP TABLE IF EXISTS " + DbContract.Playlist.TABLE_NAME + ";";
    }
}
