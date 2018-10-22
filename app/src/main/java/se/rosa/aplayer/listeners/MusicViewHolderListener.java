package se.rosa.aplayer.listeners;

import se.rosa.aplayer.model.Music;

/**
 * Created by Robert on 25/09/18.
 */

public interface MusicViewHolderListener {
    void onItemClicked(Music music);

    void onItemHold(Music music);
}
