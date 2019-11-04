package com.example.kostrakanpwt.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kostrakanpwt.Models.RecommendedCardModel;
import com.example.kostrakanpwt.R;

import java.util.ArrayList;

public class RecommendedCardAdapter extends RecyclerView.Adapter<RecommendedCardAdapter.RecommendedViewHolder> {

    //masukin modelnya
    private ArrayList<RecommendedCardModel> dataList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public RecommendedCardAdapter(ArrayList<RecommendedCardModel> dataList){
        this.dataList = dataList;
    }

    @Override
    public RecommendedViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recommended_card, parent, false);
        return new RecommendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecommendedViewHolder holder, int position) {
        holder.tvCategory.setText(dataList.get(position).getCategory());
        holder.tvPrice.setText(dataList.get(position).getPrice());
        holder.tvName.setText(dataList.get(position).getName());
        holder.tvDesc.setText(dataList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class RecommendedViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCategory, tvPrice, tvName, tvDesc;

        public RecommendedViewHolder(View itemView) {
            super(itemView);
            tvCategory = (TextView) itemView.findViewById(R.id.card_category);
            tvPrice = (TextView) itemView.findViewById(R.id.card_price);
            tvName = (TextView) itemView.findViewById(R.id.card_name);
            tvDesc = (TextView) itemView.findViewById(R.id.card_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
