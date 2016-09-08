public class RV_ItemClickListener implements RecyclerView.OnItemTouchListener {

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, motionEvent e) {

    }
    @override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}


public class RV_ItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mlistener;
    //create clicklistener interface
    public interface OnItemClickListener {
        public void OnItemClick(View view, int i);

    }

    //** Add class constractor, initialise listener and instantiate gesture detector */
    GestureDetector mGestureDetector;
    public RV_ItemClickListener(Context c, onItemClickListener onItemClickListener) {
        mlistener = onItemClickListener;
        mGestureDetector = new GestureDetector(c, new GestureDetector.simpleOnGestureListener() {
            @override
            public boolean onSingleTabUp(MotionEvent e) {
                return true;
            }
        });
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        view mChildView = rv.findChildViewUnder(e.getX(), e.getY());
        if ((mChildView != null && mListener != null && mGestureDetector.onTouchEvent(e))) {
            mlistener.OnItemClick(mChildView, rv.getChildLayoutPosition(mChildView));
            return true;
        }
        return false;

    }
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) { }
} //Ends RV_ItemClickListener class

