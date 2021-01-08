package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.moofficial.moessentials.MoEssentials.MoColor.MoColor;
import com.moofficial.moessentials.MoEssentials.MoLog.MoLog;
import com.moofficial.moessentials.MoEssentials.MoString.MoString;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable.MoDrawableBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable.MoDrawableUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectable;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoViewUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoViewManager.MoViewManager;
import com.moofficial.moessentials.R;

// a class that can show a single letter inside a text view
// with background drawable or an image view that can show any image
// with a universal set dimensions that can be changed
public class MoLogo extends MoConstraint {


    private TextView innerTextView;
    private ImageView outer;
    private ImageView innerLogo;
    private Drawable savedOuter;
    private Drawable savedInner;
    private ConstraintLayout layout;
    private @ColorRes int color = MoColor.NULL_COLOR;

    public MoLogo(Context context) {
        super(context);
    }

    public MoLogo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoLogo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    // todo test
    public MoLogo small() {
        MoViewUtils.setSize(this.layout,R.dimen.mo_logo_small,R.dimen.mo_logo_small);
        MoViewUtils.setSize(this.innerLogo,R.dimen.mo_logo_small_image,R.dimen.mo_logo_small_image);
        this.innerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getDimension(R.dimen.mo_logo_small_font));
        return this;
    }

    public MoLogo medium() {
        MoViewUtils.setSize(this.layout,R.dimen.mo_logo_medium,R.dimen.mo_logo_medium);
        MoViewUtils.setSize(this.innerLogo,R.dimen.mo_logo_medium_image,R.dimen.mo_logo_medium_image);
        this.innerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getDimension(R.dimen.mo_logo_medium_font));
        return this;
    }

    public MoLogo large() {
        MoViewUtils.setSize(this.layout,R.dimen.mo_logo_large,R.dimen.mo_logo_large);
        MoViewUtils.setSize(this.innerLogo,R.dimen.mo_logo_large_image,R.dimen.mo_logo_large_image);
        this.innerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getDimension(R.dimen.mo_logo_large_font));
        return this;
    }


    public MoLogo setText(String t) {
        this.innerTextView.setText(MoString.getSignature(t).toUpperCase());
        this.color = MoColor.color(t);
        paintColor();
        return this;
    }

    /**
     * paints the color of this class to
     * the outer drawable
     */
    private void paintColor() {
        DrawableCompat.setTint(this.outer.getDrawable(),
                ContextCompat.getColor(getContext(),this.color));
    }

    /**
     * reset the color of this
     * logo to null color, this could be used to reset
     * the color of folder logos
     * @return this for nested calling
     */
    public MoLogo nullColor() {
        this.color = MoColor.NULL_COLOR;
        return this;
    }

    public MoLogo setTextColor(@ColorRes int color) {
        this.innerTextView.setTextColor(ContextCompat.getColor(getContext(),color));
        return this;
    }

    public MoLogo filledCircle() {
        this.outer.setImageDrawable(MoDrawableUtils.filledCircle(getContext(),this.color));
        return this;
    }

    public MoLogo filledRec() {
        this.outer.setImageDrawable(MoDrawableUtils.filledRec(getContext(),this.color));
        return this;
    }

    public MoLogo filledRoundRec() {
        this.outer.setImageDrawable(MoDrawableUtils.filledRoundRec(getContext(),this.color));
        return this;
    }

    /**
     * sets the outer drawable
     * to the universal one that I usually use
     * in my apps
     * @return this for nested calling
     */
    public MoLogo setOuter() {
        return setOuter(MoDrawableUtils.outlineCircle(getContext()));
    }

    public MoLogo setOuter(Drawable d) {
        this.outer.setImageDrawable(d);
        this.savedOuter = d;
        return this;
    }

    /**
     * sets the inner drawable for the logo
     * updates the color based on the drawable
     * that is passed in
     * and paints the color to the outer drawable
     * @param b drawable to update the inner drawable to
     * @return this for nested calling
     */
    public MoLogo setInner(Drawable b) {
        this.innerLogo.setImageDrawable(b);
        this.savedInner = b;
        this.color = MoColor.color(b);
        paintColor();
        return this;
    }


    public MoLogo showLogo() {
        this.innerLogo.setVisibility(View.VISIBLE);
        return this;
    }

    public MoLogo hideLogo() {
        this.innerLogo.setVisibility(View.GONE);
        return this;
    }

    public MoLogo showText() {
        this.innerTextView.setVisibility(View.VISIBLE);
        return this;
    }

    public MoLogo hideText() {
        this.innerTextView.setVisibility(View.GONE);
        return this;
    }

    public MoLogo showLogoHideText() {
        showLogo();
        return hideText();
    }

    /**
     * selects or unSelect depending on whether
     * the item has been selected or not
     * @param o object
     * @param isIcon is used to determine
     *               whether the logo is a text logo
     *               or an icon logo
     * @return this for nested calling
     */
    public MoLogo onSelect(MoSelectableItem o, boolean isIcon) {
        return o.isSelected()? select() : unSelect(isIcon);
    }

    /**
     * same as onSelect but now it fills
     * the drawable inside it, if it is selected
     * @param o
     * @param isIcon is used to determine
     *               whether the logo is a text logo
     *               or an icon logo
     * @return this for nested calling
     */
    public MoLogo onSelectFill(MoSelectableItem o, boolean isIcon) {
        return o.isSelected()? selectFill() : unSelect(isIcon);
    }


    /**
     * fills the outer drawable
     * @return
     */
    private MoLogo selectFill() {
        Drawable d;
        if (this.outer.getDrawable() instanceof GradientDrawable && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            d = new MoDrawableBuilder(getContext())
                    .shape(((GradientDrawable)this.outer.getDrawable()).getShape())
                    .withColor(this.color)
                    .build();
        } else {
            d = new MoDrawableBuilder(getContext()).oval().withColor(this.color).build();
        }
        return select(d,
                ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_check_24));
    }

    /**
     * does not change the outer drawable,
     * just shows a check mark inside the logo
     * @return
     */
    private MoLogo select() {
        return select(
                this.outer.getDrawable(),
                ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_check_24));
    }



    private MoLogo select(Drawable selectedDrawable, Drawable innerDrawable) {
        this.savedOuter = this.outer.getDrawable();
        this.savedInner = this.innerLogo.getDrawable();
        this.outer.setImageDrawable(selectedDrawable);
        this.innerLogo.setImageDrawable(innerDrawable);
        //this.manager = new MoViewManager().saveVisibility(this.outer,this.innerLogo,this.innerTextView);
        showLogoHideText();
        return this;
    }


    private MoLogo unSelect(boolean isIcon) {
        this.outer.setImageDrawable(this.savedOuter);
        this.innerLogo.setImageDrawable(this.savedInner);
        return show(isIcon);
    }

    private MoLogo show(boolean isIcon) {
        if (isIcon) {
            return showLogoHideText();
        } else {
            return showText().hideLogo();
        }
    }

    public String signature() {
        return this.innerTextView.getText().toString();
    }

    public @ColorInt int  getColor() {
        return ContextCompat.getColor(getContext(), this.color);
    }

    public @ColorRes int  getColorRes() {
        return this.color;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_logo;
    }

    @Override
    public void initViews() {
        innerTextView = findViewById(R.id.mo_logo_text);
        outer = findViewById(R.id.mo_logo_outer_drawable);
        innerLogo = findViewById(R.id.mo_logo_image);
        layout = findViewById(R.id.mo_logo_layout);
        setOuter(MoDrawableUtils.outlineCircle(getContext()));
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
