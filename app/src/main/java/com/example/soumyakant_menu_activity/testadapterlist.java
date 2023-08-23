package com.example.soumyakant_menu_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class testadapterlist extends BaseAdapter {
    private List<pojo> items;

    private Context context;

    public testadapterlist(Context context, List<pojo> items) {
        this.context = context;
        this.items = items;
    }

    public void setCartItemClickListener(CartItemClickListener listener) {
        cartItemClickListener = listener;
    }


    public interface CartItemClickListener {
        void onCartImageClick(pojo item);
    }

    private CartItemClickListener cartItemClickListener;
    public class Viewholder {
        ImageView brandpr;
        TextView brandtt;
        ImageView cart;
        TextView prdesc;
        TextView price;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        final Viewholder holder;
        if (convertview == null) {
            convertview = LayoutInflater.from(context).inflate(R.layout.demolayout, null);
            holder = new Viewholder();
            holder.brandpr = (ImageView) convertview.findViewById(R.id.newimage);
            holder.brandtt = (TextView) convertview.findViewById(R.id.brand);
            holder.cart = (ImageView) convertview.findViewById(R.id.cart);
            holder.prdesc = (TextView) convertview.findViewById(R.id.product);
            holder.price = (TextView) convertview.findViewById(R.id.price);
            convertview.setTag(holder);


        } else {
            holder = (Viewholder) convertview.getTag();
        }
        pojo listItem = items.get(position);


        holder.brandpr.setImageResource(listItem.getImageprd ());
        holder.cart.setImageResource(listItem.getImagecart ());
        holder.brandtt.setText(listItem.getTextbrand ());
        holder.prdesc.setText(listItem.getTextdesc ());
        holder.price.setText(listItem.getTextprice ());




        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cartItemClickListener != null) {

                    cartItemClickListener.onCartImageClick(listItem);
                }
            }
        });


        return convertview;
    }

}

