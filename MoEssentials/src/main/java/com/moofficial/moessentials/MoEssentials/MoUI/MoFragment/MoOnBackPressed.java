package com.moofficial.moessentials.MoEssentials.MoUI.MoFragment;

public interface MoOnBackPressed {

    /**
     *
     * @return true if this was consumed
     * by the class, so the activity should not do anything
     * if false, the activities on back pressed will
     * be called instead
     */
    boolean onBackPressed();

}
