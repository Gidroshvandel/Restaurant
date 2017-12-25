package com.mycompany.restaurant;

import com.mycompany.restaurant.model.SelectDishModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lantiets on 24.12.2017.
 */

public class Cart {

    public static ArrayList<SelectDishModel> selectDishModels = new ArrayList<>();

    public static int findItemPosition(SelectDishModel selectDishModel){
        for (int i = 0; i < selectDishModels.size(); i++) {
            SelectDishModel dishModel = selectDishModels.get(i);
            if(dishModel.getImage() == selectDishModel.getImage()
                    && dishModel.getWeight() == selectDishModel.getWeight()
                    && dishModel.getPrice() == selectDishModel.getPrice()
                    && dishModel.getName().equals(selectDishModel.getName())){
                return i;
            }
        }
        return -1;
    }

}
