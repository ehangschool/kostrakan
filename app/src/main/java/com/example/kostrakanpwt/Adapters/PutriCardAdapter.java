package com.example.kostrakanpwt.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kostrakanpwt.Models.PutraCardModel;
import com.example.kostrakanpwt.Models.PutriCardModel;
import com.example.kostrakanpwt.Models.RecommendedCardModel;
import com.example.kostrakanpwt.R;

import java.util.ArrayList;

public class PutriCardAdapter extends RecyclerView.Adapter<PutriCardAdapter.PutriCardViewHolder> {

    private ArrayList<PutriCardModel> dataList;

    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public PutriCardAdapter(ArrayList<PutriCardModel> dataList) {
        this.dataList = dataList;
    }

    public class PutriCardViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCategory, tvPrice, tvName, tvDesc;

        public PutriCardViewHolder(View itemView) {
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

    @Override
    public PutriCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.kostputri_card, viewGroup, false);
        return new PutriCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PutriCardViewHolder holder, int position) {
        holder.tvCategory.setText(dataList.get(position).getCategory());
        holder.tvPrice.setText(dataList.get(position).getPrice());
        holder.tvName.setText(dataList.get(position).getName());
        holder.tvDesc.setText(dataList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
