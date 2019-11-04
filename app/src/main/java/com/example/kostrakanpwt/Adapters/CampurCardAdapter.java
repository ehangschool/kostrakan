package com.example.kostrakanpwt.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kostrakanpwt.Models.CampurCardModel;
import com.example.kostrakanpwt.Models.PutraCardModel;
import com.example.kostrakanpwt.R;

import java.util.ArrayList;

public class CampurCardAdapter extends RecyclerView.Adapter<CampurCardAdapter.CampurCardViewHolder> {
    private ArrayList<CampurCardModel> dataList;

    public OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public CampurCardAdapter(ArrayList<CampurCardModel> dataList) {
        this.dataList = dataList;
    }

    public class CampurCardViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCategory, tvPrice, tvName, tvDesc;

        public CampurCardViewHolder(View itemView) {
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
    public CampurCardAdapter.CampurCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.kostputra_card, viewGroup, false);
        return new CampurCardAdapter.CampurCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CampurCardAdapter.CampurCardViewHolder holder, int position) {
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
