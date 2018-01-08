package com.mycompany.restaurant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mycompany.restaurant.model.MenuModel;

import java.util.List;

//класс адаптера для категорий
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MenuViewHolder> {

    private List<MenuModel> menuModels;

    private ItemActionListener listener;

    public CategoryAdapter(List<MenuModel> menuModels, ItemActionListener listener) {
        this.menuModels = menuModels;
        this.listener = listener;
    }

    //создание холдера
    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_adapter_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.update();
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView text;

        MenuViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
        }

        //загрузка данных из бд при обновлении страницы
        void update() {
            final MenuModel menuModel = menuModels.get(getAdapterPosition());
            image.setImageDrawable(ImageSelector.getCategoryImage(itemView.getContext(), menuModel.getImageId()));
            text.setText(menuModel.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition(), menuModel);
                }
            });
        }
    }

    public interface ItemActionListener {
        void onItemClick(int position, MenuModel menuModel);
    }
}
