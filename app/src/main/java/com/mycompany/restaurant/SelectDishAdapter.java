package com.mycompany.restaurant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mycompany.restaurant.model.SelectDishModel;

import java.util.ArrayList;

public class SelectDishAdapter extends RecyclerView.Adapter<SelectDishAdapter.SelectDishViewHolder> {

    private ArrayList<SelectDishModel> selectDishModelList;
    private ItemActionListener listener;
    private boolean showAddButton;
    private boolean showRemoveButton;

    public SelectDishAdapter(ArrayList<SelectDishModel> selectDishModelList, boolean showAddButton, boolean showRemoveButton, ItemActionListener listener) {
        this.selectDishModelList = selectDishModelList;
        this.listener = listener;
        this.showAddButton = showAddButton;
        this.showRemoveButton = showRemoveButton;
    }

    @Override
    public SelectDishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_dish_item, parent, false);
        return new SelectDishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectDishViewHolder holder, int position) {
        holder.update();
    }

    @Override
    public int getItemCount() {
        return selectDishModelList.size();
    }

    class SelectDishViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView text_view;
        private TextView price;
        private ImageView add_cart;
        private ImageView remove_cart;

        SelectDishViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text_view = itemView.findViewById(R.id.text_view);
            price = itemView.findViewById(R.id.price);
            add_cart = itemView.findViewById(R.id.add_cart);
            remove_cart = itemView.findViewById(R.id.remove_cart);
        }

        void update() {
            final SelectDishModel selectDishModel = selectDishModelList.get(getAdapterPosition());
            image.setImageDrawable(ImageSelector.getSubCategoryImage(itemView.getContext(), selectDishModel.getImageId()));
            text_view.setText(selectDishModel.getName());
            String text = selectDishModel.getPrice() + "Р" + " / " + selectDishModel.getWeight() + " г";
            price.setText(text);
            add_cart.setVisibility(showAddButton ? View.VISIBLE : View.GONE);
            remove_cart.setVisibility(showRemoveButton ? View.VISIBLE : View.GONE);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition(), selectDishModel);
                }
            });
        }
    }

    public interface ItemActionListener {
        void onItemClick(int position, SelectDishModel selectDishModel);
    }

}
