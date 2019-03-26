package com.example.fuckinggreatadvice.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fuckinggreatadvice.R;
import com.example.fuckinggreatadvice.pojo.Advice;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private List<Advice> adviceList;
    private Context context;
    private OnDeleteItemLister onDeleteItemLister;

    public FavoriteAdapter(Context context, OnDeleteItemLister onDeleteItemLister) {
        this.context = context;
        this.onDeleteItemLister = onDeleteItemLister;
        adviceList = new ArrayList<>();
    }

    public void setAdviceList(List<Advice> adviceList) {
        this.adviceList = adviceList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.favorite_advice_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(adviceList.get(i).getText());
        viewHolder.imageButton.setOnClickListener(v -> onDeleteItemLister.onDeleteAdvice(adviceList.get(i)));
    }

    @Override
    public int getItemCount() {
        return adviceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageButton imageButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_advice);
            imageButton = itemView.findViewById(R.id.delete_advice_button);
        }
    }

    public interface OnDeleteItemLister {
        void onDeleteAdvice(Advice advice);
    }
}
