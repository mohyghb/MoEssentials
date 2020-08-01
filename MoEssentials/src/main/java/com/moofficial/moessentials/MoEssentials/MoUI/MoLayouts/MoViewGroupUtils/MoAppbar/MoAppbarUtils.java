package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils.MoAppbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.moofficial.moessentials.R;

import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS;
import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL;
import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP;
import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS;
import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED;
import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED;
import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_NO_SCROLL;

public class MoAppbarUtils {



//    public static void sync(View parent, int appbarLayoutId,int collapsingToolbarId,int bt,int st){
//         sync(parent.findViewById(appbarLayoutId),parent.findViewById(collapsingToolbarId),
//                 parent.findViewById(bt),parent.findViewById(st));
//    }

    /**
     * transitions between the title inside the collapsing toolbar
     * and the title of the small toolbar
     * @param appBarLayout app bar layout of the activity
     * @param collapsingToolbar collapsing toolbar of the view
     * @param mainTitle main title of the view
     * @param minorTitles other titles that have to change their Alpha in accordance with
     *                    the appbar layout and the collapsing toolbar, also chnage their text
     *                    based on the main title
     */
    public static void sync(AppBarLayout appBarLayout,
                            CollapsingToolbarLayout collapsingToolbar,TextView mainTitle, TextView ... minorTitles ){
        syncText(minorTitles, mainTitle.getText());
        syncFadingTitles(appBarLayout, collapsingToolbar, mainTitle, minorTitles);
        syncOnTextChanged(mainTitle, minorTitles);
    }

    /**
     *
     * @param mainTitle
     * @param minorTitles
     */
    // syncing on text change listeners
    private static void syncOnTextChanged(TextView mainTitle, TextView[] minorTitles) {
        mainTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                syncText(minorTitles, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     *
     * @param appBarLayout
     * @param collapsingToolbar
     * @param mainTitle
     * @param minorTitles
     */
    // syncing with the position of the app bar layout
    private static void syncFadingTitles(AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbar, TextView mainTitle, TextView[] minorTitles) {

        appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
            int col = collapsingToolbar.getScrimVisibleHeightTrigger();
            int h = collapsingToolbar.getHeight();
            float f = (float)(col-verticalOffset)/h;
            float actualF = verticalOffset==0?0f:Math.abs(verticalOffset)>col?1f:f;
            for(TextView tv: minorTitles){
                tv.setAlpha(actualF);
            }
            mainTitle.setAlpha(1f-actualF);
        });
    }

    /**
     *
     * @param minorTitles
     * @param text
     */
    private static void syncText(TextView[] minorTitles, CharSequence text) {
        // sync their titles at the beginning
        for (TextView tv : minorTitles) {
            tv.setText(text);
        }
    }


    /**
     * disables the app bar from being scrolled
     * @param toolbar
     */
    public static void disableToolBarScrolling(CollapsingToolbarLayout toolbar) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
    }

    /**
     * enables the scrolling
     * @param toolbar
     */
    public static void enableToolBarScrolling(CollapsingToolbarLayout toolbar) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(SCROLL_FLAG_SCROLL | SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
    }


    /**
     * enables the scrolling
     * @param toolbar
     */
    public static void setFlags(CollapsingToolbarLayout toolbar,int flags) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(flags);
    }

    public static void snapWithToolbar(CollapsingToolbarLayout t){
        setFlags(t,SCROLL_FLAG_EXIT_UNTIL_COLLAPSED | SCROLL_FLAG_SNAP | SCROLL_FLAG_SNAP_MARGINS | SCROLL_FLAG_SCROLL);
    }

    public static void snapNoToolbar(CollapsingToolbarLayout t){
        setFlags(t,SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED | SCROLL_FLAG_SNAP | SCROLL_FLAG_SNAP_MARGINS | SCROLL_FLAG_SCROLL);
    }

    public static void noToolbar(CollapsingToolbarLayout t){
        setFlags(t,SCROLL_FLAG_SCROLL | SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
    }


}
