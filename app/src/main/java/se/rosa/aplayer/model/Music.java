package se.rosa.aplayer.model;

/**
 * Created by Robert on 17/09/18.
 */

public class Music {
    private long id;
    private Artist artist;
    private String title;
    private String soundPath;
    private int androidMusicId;

    private Music(long id, Artist artist, String title, String soundPath, int androidMusicId) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.soundPath = soundPath;
        this.androidMusicId = androidMusicId;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getSoundPath() {
        return soundPath;
    }

    public int getAndroidMusicId() {
        return androidMusicId;
    }

    public static Music create(long id, Artist artist, String title, String soundPath, int androidMusicId) {
        return new Music(id, artist, title, soundPath, androidMusicId);
    }

    public long getId() {
        return id;
    }
}
