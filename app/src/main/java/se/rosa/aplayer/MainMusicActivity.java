package se.rosa.aplayer;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import se.rosa.aplayer.fragments.MusicListFragment;
import se.rosa.aplayer.listeners.MusicPlayerViewListener;
import se.rosa.aplayer.listeners.ToolbarFragmentListener;
import se.rosa.aplayer.model.Artist;
import se.rosa.aplayer.model.Music;
import se.rosa.aplayer.repository.MusicRepository;
import se.rosa.aplayer.views.ToolbarFragment;

public class MainMusicActivity extends AppCompatActivity implements ToolbarFragmentListener {
    private ToolbarFragment toolbarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new MusicListFragment();
        fragmentManager.beginTransaction()
                .add(R.id.mainContainer, fragment)
                .commit();
        toolbarFragment = findViewById(R.id.toolbar);
        toolbarFragment.setToolbarFragmentListener(this);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStackImmediate();
    }

    @Override
    public void onMorePressed() {
        MusicRepository musicRepository = MusicRepository.getInstance(this);
        Toast.makeText(this, String.valueOf(musicRepository.getcount()), Toast.LENGTH_SHORT).show();
    }
}
