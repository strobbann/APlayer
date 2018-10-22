package se.rosa.aplayer.model;

import java.util.List;

/**
 * Created by Robert on 10/10/18.
 */

public class Playlist {
    private long id;
    private String name;
    private List<Long> musicList;

    private Playlist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Playlist create(long id, String name) {
        return new Playlist(id, name);
    }

}
