package se.rosa.aplayer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import se.rosa.aplayer.R;
import se.rosa.aplayer.listeners.MusicViewHolderListener;
import se.rosa.aplayer.model.Music;

/**
 * Created by Robert on 17/09/18.
 */

public class MainMusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {

    private List<Music> musicList;
    private MusicViewHolderListener musicViewHolderListener;

    public MainMusicAdapter(MusicViewHolderListener musicViewHolderListener) {
        musicList = new ArrayList<>();
        this.musicViewHolderListener = musicViewHolderListener;
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_music, parent, false);
        MusicViewHolder vh = new MusicViewHolder(v, musicViewHolderListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        holder.setMusic(musicList.get(position));
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }


    public void setMusic(List<Music> music) {
        this.musicList = music;
        notifyDataSetChanged();
    }
}
