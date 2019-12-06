package com.changedsac.ViewHolder;


import com.changedsac.Interface.ItemClickListener;
import com.changedsac.R;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class CategoryViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView category_name,category_total;
    public ImageView category_image;
    public ItemClickListener itemClickListener;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        category_image=(ImageView)itemView.findViewById(R.id.category_image);
        category_name=(TextView)itemView.findViewById(R.id.category_name);
        category_total = (TextView)itemView.findViewById(R.id.category_total);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
