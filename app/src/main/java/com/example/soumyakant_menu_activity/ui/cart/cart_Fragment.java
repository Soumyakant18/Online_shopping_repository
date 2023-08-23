package com.example.soumyakant_menu_activity.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.soumyakant_menu_activity.R;
import com.example.soumyakant_menu_activity.pojo;


public class cart_Fragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cart_, container, false);

        ImageView brimg = root.findViewById(R.id.brandImageInCart);
        TextView brtext = root.findViewById(R.id.brandNameInCart);
        TextView prname = root.findViewById(R.id.productNameInCart);
        TextView pricett = root.findViewById(R.id.priceInCart);

        Button removeButton = root.findViewById(R.id.button);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                brimg.setImageResource(0);
                brtext.setText("");
                prname.setText("");
                pricett.setText("");

                Navigation.findNavController (requireView ()).popBackStack ();


                Toast.makeText(getContext(), "Your order is placed", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle arguments = getArguments();
        if (arguments != null) {
            pojo selectedItem = arguments.getParcelable("selectedItem");
            if (selectedItem != null) {
                brimg.setImageResource(selectedItem.getImageprd());
                brtext.setText(selectedItem.getTextbrand());
                prname.setText(selectedItem.getTextdesc());
                pricett.setText(selectedItem.getTextprice());
            }
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
