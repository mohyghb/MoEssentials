package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.widget.ImageButton;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoPaddingBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoViewUtils;
import com.moofficial.moessentials.R;

/**
 * an image button with the borderless ripple
 * when the user clicks it for better UI
 * and 8dp padding to make it
 */
public class MoImageButton extends androidx.appcompat.widget.AppCompatImageButton {

    public MoImageButton(@NonNull Context context) {
        super(context);
        setup();
    }

    public MoImageButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public MoImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public MoImageButton setIcon(@DrawableRes int res) {
        setImageResource(res);
        return this;
    }

    /**
     * adds the padding
     * and the ripple on click effect
     */
    private void setup() {
        MoViewUtils.borderlessRippleOnClick(getContext(), this);
        new MoPaddingBuilder(getContext(),
                (int) getResources().getDimension(R.dimen.mo_image_button_padding))
                .apply(this);
    }

}
