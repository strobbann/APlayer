package se.rosa.aplayer.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import se.rosa.aplayer.R;
import se.rosa.aplayer.adapter.MainMusicAdapter;
import se.rosa.aplayer.listeners.MusicViewHolderListener;
import se.rosa.aplayer.model.Music;

/**
 * Created by Robert on 17/09/18.
 */

public class MusicListView {

    private View view;
    private RecyclerView recyclerView;
    private MainMusicAdapter mainMusicAdapter;
    private MusicViewHolderListener musicViewHolderListener;

    public MusicListView(LayoutInflater layoutInflater, ViewGroup container, Context context, MusicViewHolderListener musicViewHolderListener) {
        view = layoutInflater.inflate(R.layout.fragment_music_list_view, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        mainMusicAdapter = new MainMusicAdapter(musicViewHolderListener);
        recyclerView.setAdapter(mainMusicAdapter);
    }

    public void setMusic(List<Music> music) {
        mainMusicAdapter.setMusic(music);
    }

    public View getView() {
        return view;
    }

    public int getContainerId() {
        return R.id.container;
    }

}
