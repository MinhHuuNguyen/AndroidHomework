package com.example.minh.dailyquote.Models;


import android.support.v4.app.Fragment;

/**
 * Created by Minh on 10/25/2016.
 */

public class FragmentEvent {
    private Fragment fragment;
    private boolean addToBackstack;

    public FragmentEvent(Fragment fragment, boolean addToBackstack) {
        this.fragment = fragment;
        this.addToBackstack = addToBackstack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public boolean isAddToBackstack() {
        return addToBackstack;
    }

    public void setAddToBackstack(boolean addToBackstack) {
        this.addToBackstack = addToBackstack;
    }
}
