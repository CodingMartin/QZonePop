package com.jhd.mq.blur;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author:Martin
 * Date:2016/9/26
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder> {

    private List<Bean> list;

    public MainMenuAdapter() {
        list = new ArrayList<>();
        list.addAll(Bean.getData());
    }

    @Override public MainMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_pop, parent, false));
    }

    @Override public void onBindViewHolder(MainMenuAdapter.ViewHolder holder, int position) {
        final Bean bean = list.get(position);
        holder.ivMenu.setImageResource(bean.image);
        holder.tvMenu.setText(bean.text);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(v.getContext(), bean.text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override public int getItemCount() {
        return list.size();
    }



    public void add() {
        list.addAll(Bean.getData());
        notifyItemRangeInserted(0,list.size());
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivMenu;
        public TextView tvMenu;

        public ViewHolder(View itemView) {
            super(itemView);
            ivMenu = (ImageView) itemView.findViewById(R.id.iv_menu);
            tvMenu = (TextView) itemView.findViewById(R.id.tv_menu);
        }
    }
}
