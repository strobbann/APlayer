package se.rosa.aplayer.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import se.rosa.aplayer.R;
import se.rosa.aplayer.listeners.ToolbarFragmentListener;

/**
 * Created by Robert on 03/10/18.
 */

public class ToolbarFragment extends Toolbar {
    private ImageView moreButton;

    public ToolbarFragment(Context context) {
        super(context);
        inflate(context);
    }

    public ToolbarFragment(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public ToolbarFragment(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public void inflate(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.music_toolbar_view, this);
        moreButton = v.findViewById(R.id.moreButton);

    }

    public void setToolbarFragmentListener(final ToolbarFragmentListener toolbarFragmentListener) {
        moreButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toolbarFragmentListener != null) {
                    toolbarFragmentListener.onMorePressed();
                }
            }
        });
    }

}
