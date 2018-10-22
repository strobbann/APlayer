package se.rosa.aplayer.sql;

import android.provider.BaseColumns;

/**
 * Created by Robert on 26/09/18.
 */

public class DbContract {

    public static class MusicEntry implements BaseColumns {
        public static final String TABLE_NAME = "music";
        public static final String COLUMN_NAME_ANDROID_MUSIC_ID = "android_music_id";

    }

    public static class Playlist implements BaseColumns{
        public static final String TABLE_NAME = "playlist";
        public static final String COLUMN_NAME_PLAYLIST_NAME = "playlist_name";
    }
}
