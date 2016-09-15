package com.dadaabcamps.mmarket.databases;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.ColorMatrix;

import com.dadaabcamps.mmarket.Message;


/**
 * Created by Okidi~PC on 9/15/2016.
 */
public class DBHelperAdapter {



    static class DBHelper extends SQLiteOpenHelper {
        SQLiteDatabase db;
        Context context;
        private static final int DB_VERSION = 01;
        private static final String TEXT_TYPE = " TEXT";
        private static final String INTEGER_TYPE = " INTEGER ";
        private static final String COMA = ", ";
        private static final String P_KEY = " INTEGER PRIMARY AUTOINCREMENT, ";
        private static final String CREATE_CAMPTABLE = "CREATE TABLE "
                +  DatabaseStructure.CampTable.TABLE_NAME + "("
                +  DatabaseStructure.CampTable.UID + P_KEY
                +  DatabaseStructure.CampTable.CAMPNAME + TEXT_TYPE + COMA
                +  DatabaseStructure.CampTable.LOCATION + TEXT_TYPE + ")";

        private static final String DROP_CAMPTABLE = "DROP TABLE IF EXISTS "+ DatabaseStructure.CampTable.TABLE_NAME;

        public DBHelper(Context context) {
            super(context, DatabaseStructure.DB_NAME,null, DB_VERSION);
            this.context = context;

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                db.execSQL(CREATE_CAMPTABLE);
                Message.message(context, "DB TABLE CREATED");

            } catch (SQLException e) {
                Message.message(context, " TABLE NOT CREATED" + e);

            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            try {
                db.execSQL(DROP_CAMPTABLE);
                onCreate(db);

            } catch (SQLException e) {
                Message.message(context, "DB TABLE UPGRADED"+e);

            }
        }
    }//Ends DBHelper class

}
