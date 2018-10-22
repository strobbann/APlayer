package se.rosa.aplayer.model;

import java.util.jar.Attributes;

/**
 * Created by Robert on 17/09/18.
 */

public class Artist {
    private String name;

    private Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Artist create(String name) {
        return new Artist(name);
    }
}
