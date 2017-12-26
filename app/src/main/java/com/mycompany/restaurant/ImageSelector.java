package com.mycompany.restaurant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

public class ImageSelector {

    public static Drawable getCategoryImage(Context context, int id) {
        switch (id) {
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.category_dessert);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.category_drinkables);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.category_garnish);
            case 4:
                return ContextCompat.getDrawable(context, R.drawable.category_meat);
            case 5:
                return ContextCompat.getDrawable(context, R.drawable.category_salad);
            case 6:
                return ContextCompat.getDrawable(context, R.drawable.category_sauce);
            case 7:
                return ContextCompat.getDrawable(context, R.drawable.category_snack);
            case 8:
                return ContextCompat.getDrawable(context, R.drawable.category_soup);
            default:
                return null;
        }
    }

    public static Drawable getSubCategoryImage(Context context, int id) {
        switch (id) {
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.soup);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.soup2);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.soup3);
            case 4:
                return ContextCompat.getDrawable(context, R.drawable.soup4);
            case 5:
                return ContextCompat.getDrawable(context, R.drawable.salad);
            default:
                return null;
        }
    }

}
