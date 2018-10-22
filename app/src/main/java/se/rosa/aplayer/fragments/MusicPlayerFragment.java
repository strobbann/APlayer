package se.rosa.aplayer.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;

import se.rosa.aplayer.listeners.MusicPlayerViewListener;
import se.rosa.aplayer.model.Music;
import se.rosa.aplayer.views.MusicPlayerView;

/**
 * Created by Robert on 28/09/18.
 */

public class MusicPlayerFragment extends Fragment implements MusicPlayerViewListener{

    private MusicPlayerView view;
    private Music music;
    private String gsonKey = "Music";
    private MediaPlayer mp;

    public MusicPlayerFragment create(Music music) {
        this.music = music;
        Bundle bundle = new Bundle();
        bundle.putString(gsonKey, new Gson().toJson(music));
        MusicPlayerFragment fragment = new MusicPlayerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            if (getArguments().getString(gsonKey) != null) {
                music = new Gson().fromJson(getArguments().getString(gsonKey), Music.class);
                mp = new MediaPlayer();
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = new MusicPlayerView(inflater, container, this);
        return view.getView();
    }

    @Override
    public void onPlayButtonPressed() {
        if (!mp.isPlaying()) {
            try {
                mp.setDataSource(music.getSoundPath());
                mp.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mp.start();
        }
    }

    @Override
    public void onPauseButtonPressed() {
        if (mp.isPlaying()) {
            mp.stop();
        }
    }
}
