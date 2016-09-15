package com.dadaabcamps.mmarket;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
//import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigation;


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
    private void initInstances(){
        if (getSupportActionBar() !=null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout, R.string.welcome, R.string.welcome);
        drawerLayout.addDrawerListener(drawerToggle);
        //Intializing NavigationView
        navigation = (NavigationView) findViewById(R.id.navigation_view);
        //Setting Navigation view Item Selected Listener to handle the item click of the navigation menu
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navigation_item_1:
                        //Do some thing here
                        break;
                    case R.id.navigation_item_2:
                        //Do some thing here
                        break;
                    case R.id.navigation_item_3:
                        //Do some thing here
                        break;
                    case R.id.navigation_item_4:
                        //Do some thing here
                        break;


                }
                return false;

            }
        });



        }

    @Override
public void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();

}
@Override
public void onConfigurationChanged(Configuration newConfg) {
    super.onConfigurationChanged(newConfg);
    drawerToggle.onConfigurationChanged(newConfg);
}
    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;
        // Handle action bar item clicks here.The action bar vill
        //automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in androidManifest.xml.
        int id = item.getItemId();
        //noinspection simplifiableIfstatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}







