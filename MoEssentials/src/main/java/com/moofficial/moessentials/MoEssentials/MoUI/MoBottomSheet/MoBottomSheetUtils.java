package com.moofficial.moessentials.MoEssentials.MoUI.MoBottomSheet;

import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.moofficial.moessentials.R;

public class MoBottomSheetUtils {


    /**
     * creates the rounded background for the bottom sheet
     * @param bottomSheet to create the round background for
     * @return MaterialShapeDrawable that is round
     */
    public static MaterialShapeDrawable getRoundBackground(@NonNull View bottomSheet) {
        ShapeAppearanceModel shapeAppearanceModel =

                //Create a ShapeAppearanceModel with the same shapeAppearanceOverlay used in the style
                ShapeAppearanceModel.builder(bottomSheet.getContext(),
                        0, R.style.mo_round_bottom_sheet_dialog)
                        .build();

        //Create a new MaterialShapeDrawable (you can't use the original MaterialShapeDrawable in the BottoSheet)
        MaterialShapeDrawable currentMaterialShapeDrawable = (MaterialShapeDrawable) bottomSheet.getBackground();
        MaterialShapeDrawable newMaterialShapeDrawable = new MaterialShapeDrawable((shapeAppearanceModel));
        //Copy the attributes in the new MaterialShapeDrawable
        newMaterialShapeDrawable.initializeElevationOverlay(bottomSheet.getContext());
        newMaterialShapeDrawable.setFillColor(currentMaterialShapeDrawable.getFillColor());
        newMaterialShapeDrawable.setTintList(currentMaterialShapeDrawable.getTintList());
        newMaterialShapeDrawable.setElevation(currentMaterialShapeDrawable.getElevation());
        newMaterialShapeDrawable.setStrokeWidth(currentMaterialShapeDrawable.getStrokeWidth());
        newMaterialShapeDrawable.setStrokeColor(currentMaterialShapeDrawable.getStrokeColor());
        return newMaterialShapeDrawable;
    }

}
