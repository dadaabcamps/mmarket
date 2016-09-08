package com.dadaabcamps.mmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String recyclerViewTitle[] = {"Fresh fruts", "cerials",
            "leather Eags", "Art and jevelary", "Heavy Duty Duvet", "Fruits per Kgs", "Books for Kids",
            "Fruits in large Scale", "Metal Equipments", "Fresh Fish Tilapia", "Peanut Butter", "  sandals"
    };

    private final int recyclerViewImage[] = {
            R.drawable.fruits, R.drawable.cerials, R.drawable.bagsretail, R.drawable.art,
            R.drawable.duvets, R.drawable.fruitskilos, R.drawable.books,
            R.drawable.fruitsretail, R.drawable.metals, R.drawable.fish,
            R.drawable.peanutbutter, R.drawable.sandals};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycerview();
    }


    private void initRecycerview() {

        /** Inflate Link the recycler view Layout file with code
         * set properties such as size and display format*/
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_product_display);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ProductData> av = prepareData();
        RV_DataAdapter mAdapter = new RV_DataAdapter(getApplicationContext(), av);
        mRecyclerView.setAdapter(mAdapter);
    }




    private ArrayList<ProductData> prepareData() {
        ArrayList<ProductData> av = new ArrayList<>();
        //Loop through all product titles defined in string array e.g fruits,arts metals
        for (int i = 0; i < recyclerViewTitle.length; i++) {
            /** create an instance of the class */
            ProductData productdata = new ProductData();
            /** Telling ProductData class instance where to get product image and titles */
            productdata.setrecyclerViewText(recyclerViewTitle[i]);

            productdata.setRecyclerViewImage(recyclerViewImage[i]);
            av.add(productdata);
        }
        return av;
    }
}




