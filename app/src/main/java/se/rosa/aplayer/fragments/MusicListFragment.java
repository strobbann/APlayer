package se.rosa.aplayer.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import se.rosa.aplayer.R;
import se.rosa.aplayer.listeners.MusicPlayerViewListener;
import se.rosa.aplayer.listeners.MusicViewHolderListener;
import se.rosa.aplayer.model.Artist;
import se.rosa.aplayer.model.Music;
import se.rosa.aplayer.repository.MusicRepository;
import se.rosa.aplayer.views.MusicListView;
import se.rosa.aplayer.views.MusicPlayerView;

/**
 * Created by Robert on 17/09/18.
 */

public class MusicListFragment extends Fragment implements MusicViewHolderListener {

    private MusicRepository musicRepository;

    public static final int MY_PERMISSION_REQUEST = 1;
    private MusicListView view;
    private boolean isInPlayListMode;
    private List<Music> musicList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicRepository = MusicRepository.getInstance(this.getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = new MusicListView(inflater, container, getContext(), this);
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            } else {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);

            }
        } else {
            getMusic();
        }
        return view.getView();
    }

    public void getMusic() {
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query(songUri, null, null, null, null);
        if (songCursor != null && songCursor.moveToFirst()) {
            List<Music> musicList = new ArrayList<>();
            int songIdIndex = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int titleIndex = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int artistIndex = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int isSongIndex = songCursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC);
            int dataIndex = songCursor.getColumnIndex(MediaStore.Audio.Media.DATA);

            while (songCursor.moveToNext()) {
                if (songCursor.getInt(isSongIndex) == 1) {
                    String title = songCursor.getString(titleIndex);
                    int songId = songCursor.getInt(songIdIndex);
                    Artist artist = Artist.create(songCursor.getString(artistIndex));
                    String soundPath = songCursor.getString(dataIndex);
                    Music music = Music.create(-1, artist, title, soundPath, songId);
                    musicList.add(music);
                }
            }
            songCursor.close();
            view.setMusic(musicList);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getMusic();
                } else {
                    getActivity().finish();
                }
            }
            return;
        }
    }

    @Override
    public void onItemClicked(Music music) {
        FragmentManager fragmentManager = getChildFragmentManager();
        MusicPlayerFragment musicPlayerFragment = new MusicPlayerFragment().create(music);
        fragmentManager.beginTransaction()
                .add(this.view.getContainerId(), musicPlayerFragment)
                .commit();
    }

    @Override
    public void onItemHold(Music music) {

        if (isInPlayListMode) {

        }
    }
}
