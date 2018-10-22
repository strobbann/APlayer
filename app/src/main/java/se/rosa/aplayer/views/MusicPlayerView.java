package se.rosa.aplayer.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import se.rosa.aplayer.R;
import se.rosa.aplayer.listeners.MusicPlayerViewListener;

/**
 * Created by Robert on 28/09/18.
 */

public class MusicPlayerView {
    private View view;
    private ImageView playButton;
    private ImageView pauseButton;


    public MusicPlayerView(LayoutInflater inflater, ViewGroup container, MusicPlayerViewListener musicPlayerViewListener) {
        view = inflater.inflate(R.layout.fragment_music_player, container, false);
        playButton = view.findViewById(R.id.playButton);
        pauseButton = view.findViewById(R.id.pauseButton);
        setPlayButtonListener(musicPlayerViewListener);
    }

    public void setPlayButtonListener(final MusicPlayerViewListener musicPlayerViewListener) {
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicPlayerViewListener.onPlayButtonPressed();
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicPlayerViewListener.onPauseButtonPressed();
            }
        });
    }

    public View getView() {
        return view;
    }
}
