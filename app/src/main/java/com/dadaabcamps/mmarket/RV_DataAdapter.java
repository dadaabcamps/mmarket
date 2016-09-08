package com.dadaabcamps.mmarket;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Okidi~PC on 9/8/2016.
 */
public class RV_DataAdapter extends RecyclerView.Adapter<RV_DataAdapter.ViewHolder> {


    private ArrayList<ProductData> arrayList;
    private Context mcontent;
    //Rv_DataAdapter class constructor that inialize the array List

    public RV_DataAdapter(Context context, ArrayList<ProductData> android) {
        this.arrayList = android;
        this.mcontent = context;
    }

    //Adapter display/inflates the grid layout file with Image and titles
    @Override
    public RV_DataAdapter.ViewHolder onCreateViewHolder(ViewGroup vGroup, int i) {
        View view = LayoutInflater.from(vGroup.getContext()).inflate(R.layout.products_grid_display, vGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RV_DataAdapter.ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position).getrecyclerViewTitleText());
        holder.imageView.setImageResource(arrayList.get(position).getRecyclerViewImage());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView  imageView;

        public ViewHolder(View v) {
            super(v);

            textView = (TextView) v.findViewById(R.id.producttext);
            imageView = (ImageView) v.findViewById(R.id.productimage);
        }
    }//Ends ViewHolder class
}


