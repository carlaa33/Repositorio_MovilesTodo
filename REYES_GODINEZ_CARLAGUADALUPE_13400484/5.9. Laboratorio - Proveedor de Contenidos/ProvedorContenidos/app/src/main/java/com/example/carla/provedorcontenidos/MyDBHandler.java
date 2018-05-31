package com.example.carla.provedorcontenidos;

import android.content.Context;

/**
 * Created by carla on 21/05/18.
 */
import com.example.carla.provedorcontenidos.MyDBHandler;
import com.ejemplos.database.provider.MyContentProvider;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.ContentResolver;
public class MyDBHandler extends SQLiteOpenHelper {
    private ContentResolver myCR;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    public static final String TABLE_PRODUCTS = "productos";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";
    public static final String COLUMN_QUANTITY = "quantity";
    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        myCR = context.getContentResolver();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addProduct(Product product) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.getProductName());
        values.put(COLUMN_QUANTITY, product.getQuantity());
        myCR.insert(MyContentProvider.CONTENT_URI, values);
    }
    public Product findProduct(String productname) {
        String[] projection = {COLUMN_ID,
                COLUMN_PRODUCTNAME, COLUMN_QUANTITY };
        String selection = "productname = \"" + productname + "\"";
        Cursor cursor = myCR.query(myCR.CONTENT_URI, projection, selection, null,null);
        Product product = new Product();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.setID(Integer.parseInt(cursor.getString(0)));
            product.setProductName(cursor.getString(1));
            product.setQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            product = null;
        }
        return product;
    }
    public boolean deleteProduct(String productname) {
        boolean result = false;
        String selection = "productname = \"" + productname + "\"";
        int rowsDeleted = myCR.delete(MyContentProvider.CONTENT_URI,selection, null);
        if (rowsDeleted > 0)
            result = true;
        return result;
    }
}