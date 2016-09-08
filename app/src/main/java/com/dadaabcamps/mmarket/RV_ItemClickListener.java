package com.dadaabcamps.mmarket;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Okidi~PC on 9/8/2016.
 */
public class RV_ItemClickListener implements RecyclerView.OnItemTouchListener{

    private OnItemClickListener mlistener;
    //create clicklistener interface
    public interface OnItemClickListener {
        public void OnItemClick(View view, int i);

    }

    //** Add class constractor, initialise listener and instantiate gesture detector */
    GestureDetector mGestureDetector;
    public RV_ItemClickListener(Context c, OnItemClickListener onItemClickListener) {
        mlistener = onItemClickListener;
        mGestureDetector = new GestureDetector(c, new GestureDetector.SimpleOnGestureListener() {
         @Override
            public boolean onSingleTapUp(MotionEvent e){
             return true;
         }

        });
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View mChildView = rv.findChildViewUnder(e.getX(), e.getY());
        if ((mChildView != null && mlistener != null && mGestureDetector.onTouchEvent(e))) {
            mlistener.OnItemClick(mChildView, rv.getChildLayoutPosition(mChildView));
            return true;
        }
        return false;

    }
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) { }



}
