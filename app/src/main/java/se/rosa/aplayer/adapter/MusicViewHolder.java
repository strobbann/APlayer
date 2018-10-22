package se.rosa.aplayer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import se.rosa.aplayer.R;
import se.rosa.aplayer.listeners.MusicViewHolderListener;
import se.rosa.aplayer.model.Music;

/**
 * Created by Robert on 21/09/18.
 */

public class MusicViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private ImageView imageView;
    private CheckBox checkBox;
    private MusicViewHolderListener musicViewHolderListener;

    public MusicViewHolder(View itemView, MusicViewHolderListener musicViewHolderListener) {
        super(itemView);
        textView = itemView.findViewById(R.id.musicTitle);
        this.musicViewHolderListener = musicViewHolderListener;
        checkBox = itemView.findViewById(R.id.checkbox);
        checkBox.setVisibility(View.GONE);

    }

    public void setMusic(final Music music) {
        textView.setText(music.getTitle());
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                checkBox.setVisibility(View.VISIBLE);
                musicViewHolderListener.onItemHold(music);
                checkBox.setChecked(!checkBox.isChecked());
                return true;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicViewHolderListener.onItemClicked(music);
            }
        });
    }

}
