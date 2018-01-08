package com.mycompany.restaurant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mycompany.restaurant.model.SelectDishModel;
import com.mycompany.restaurant.model.UserModel;

import java.util.ArrayList;

//адаптер истории заказов
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.StatusViewHolder> {

    private ArrayList<UserModel> selectDishModelList;

    public HistoryAdapter(ArrayList<UserModel> selectDishModelList) {
        this.selectDishModelList = selectDishModelList;
    }

    //создание холдера
    @Override
    public StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_item, parent, false);
        return new StatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatusViewHolder holder, int position) {
        holder.update();
    }

    @Override
    public int getItemCount() {
        return selectDishModelList.size();
    }

    class StatusViewHolder extends RecyclerView.ViewHolder {

        private TextView address;
        private TextView amount;

        StatusViewHolder(View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.address);
            amount = itemView.findViewById(R.id.amount);
        }

        //получение данных из бд при обновлении страницы
        void update() {
            final UserModel selectDishModel = selectDishModelList.get(getAdapterPosition());
            String text = "ул. " + selectDishModel.getStreet() + " д. " + selectDishModel.getBuilding() + " кв. " + selectDishModel.getApartment();
            address.setText(text);
            String text1 = String.valueOf(sumAllPrice(selectDishModel.getSelectDishModel()));
            amount.setText(text1);
        }

        //расчет суммы заказа
        private int sumAllPrice(ArrayList<SelectDishModel> selectDishModels){
            int price = 0;
            for (SelectDishModel dishModel : selectDishModels) {
                price = price + dishModel.getPrice();
            }
            return price;
        }
    }

}
