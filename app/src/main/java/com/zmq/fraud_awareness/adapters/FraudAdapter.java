// adapters/FraudAdapter.java
package com.zmq.fraud_awareness.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zmq.fraud_awareness.R;
import com.zmq.fraud_awareness.models.Fraud;

import java.util.List;

public class FraudAdapter extends RecyclerView.Adapter<FraudAdapter.FraudViewHolder> {

    List<Fraud> fraudList;

    public FraudAdapter(List<Fraud> fraudList) {
        this.fraudList = fraudList;
    }

    @NonNull
    @Override
    public FraudViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fraud_item, parent, false);
        return new FraudViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FraudViewHolder holder, int position) {
        Fraud fraud = fraudList.get(position);
        holder.txtTitle.setText(fraud.getTitle());
        holder.txtDescription.setText(fraud.getDescription());
        holder.txtCategory.setText(fraud.getCategory());
        holder.txtDate.setText(fraud.getDate());
    }

    @Override
    public int getItemCount() {
        return fraudList.size();
    }

    public static class FraudViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDescription, txtCategory, txtDate;

        public FraudViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDescription = itemView.findViewById(R.id.txt_description);
            txtCategory = itemView.findViewById(R.id.txt_category);
            txtDate = itemView.findViewById(R.id.txt_date);
        }
    }
}
