package com.mycompany.restaurant;

import com.mycompany.restaurant.model.SelectDishModel;

import java.util.ArrayList;

public class Cart {

    public static ArrayList<SelectDishModel> selectDishModels = new ArrayList<>();

    public static int findItemPosition(SelectDishModel selectDishModel){
        for (int i = 0; i < selectDishModels.size(); i++) {
            SelectDishModel dishModel = selectDishModels.get(i);
            if(dishModel.getImageId() == selectDishModel.getImageId()
                    && dishModel.getWeight() == selectDishModel.getWeight()
                    && dishModel.getPrice() == selectDishModel.getPrice()
                    && dishModel.getName().equals(selectDishModel.getName())){
                return i;
            }
        }
        return -1;
    }

    public static int sumAllPrice(){
        int price = 0;
        for (SelectDishModel dishModel : Cart.selectDishModels) {
            price = price + dishModel.getPrice();
        }
        return price;
    }

}
