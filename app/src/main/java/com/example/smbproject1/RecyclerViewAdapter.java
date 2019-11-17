package com.example.smbproject1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ItemActivity> list;
    private Context context;

     public RecyclerViewAdapter(List<ItemActivity> lil, Context ctx){
        list = lil;
        context = ctx;
     }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
         ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemActivity li = list.get(position);
        holder.name.setText(li.getName());
        holder.price.setText(li.getPrice()+"");
        holder.quantity.setText(li.getQuantity()+"");
        if(li.isChecked()){
            holder.bought.setChecked(true);
        } else {
            holder.bought.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, price, quantity;
        CheckBox bought;
        ConstraintLayout listLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            price = itemView.findViewById(R.id.itemPrice);
            quantity = itemView.findViewById(R.id.itemQuantity);
            bought = itemView.findViewById(R.id.itemCheckBox);
            listLayout = itemView.findViewById(R.id.list_layout);

            itemView.setOnClickListener(this);

            bought.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                              //funkcja zeby odznaczyc update
                        Toast.makeText(RecyclerViewAdapter.this.context, "is bought", Toast.LENGTH_LONG).show();
                    } else {
                               // funkcja zeby zaznaczyc update
                        Toast.makeText(RecyclerViewAdapter.this.context, "is not bought", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        @Override
        public void onClick(View itemView) {
            Toast.makeText(RecyclerViewAdapter.this.context, "TEST", Toast.LENGTH_LONG).show();
        }
    }




}
