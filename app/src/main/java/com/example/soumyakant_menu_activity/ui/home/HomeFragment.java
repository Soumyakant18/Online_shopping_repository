package com.example.soumyakant_menu_activity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.soumyakant_menu_activity.R;
import com.example.soumyakant_menu_activity.pojo;
import com.example.soumyakant_menu_activity.testadapterlist;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements testadapterlist.CartItemClickListener {

    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate (R.layout.fragmenthome, container, false);


        listView = root.findViewById (R.id.listone);


        List<pojo> items = new ArrayList<> ( );
        items.add (new pojo (R.drawable.bottles2, R.drawable.baseline_shopping_cart_24, "BOLD fit ", "gym water bottle ", "Rs.700"));
        items.add (new pojo (R.drawable.tshirt2, R.drawable.baseline_shopping_cart_24, "WROGN", "Tshirt", "Rs.699"));
        items.add (new pojo (R.drawable.book1, R.drawable.baseline_shopping_cart_24, "Richyrich", "book", "Rs.399"));
        items.add (new pojo (R.drawable.tshirt1, R.drawable.baseline_shopping_cart_24, "Levis", "T shirt", "Rs.599"));
        items.add (new pojo (R.drawable.pen1, R.drawable.baseline_shopping_cart_24, "Flair", "Ball pens", "Rs.199"));
        items.add (new pojo (R.drawable.bottles3, R.drawable.baseline_shopping_cart_24, "ATLAS", "water bottles", "Rs.359"));
        items.add (new pojo (R.drawable.tshirt3, R.drawable.baseline_shopping_cart_24, "ZARA", "T shirt", "Rs.999"));
        items.add (new pojo (R.drawable.bottles1, R.drawable.baseline_shopping_cart_24, "Cello", "water bottles", "Rs.199"));
        items.add (new pojo (R.drawable.book2, R.drawable.baseline_shopping_cart_24, "Willy", "death comic", "Rs.249"));
        items.add (new pojo (R.drawable.book3, R.drawable.baseline_shopping_cart_24, "R.d.sharma", "math books", "Rs.399"));
        items.add (new pojo (R.drawable.pen2, R.drawable.baseline_shopping_cart_24, "Classmate", "ball pen", "Rs.59"));
        items.add (new pojo (R.drawable.pen3, R.drawable.baseline_shopping_cart_24, "Vector", "ballpen", "Rs.199"));


        testadapterlist adapter = new testadapterlist (requireContext ( ), items);

           adapter.setCartItemClickListener (this);

        listView.setAdapter (adapter);
        return root;
    }



    @Override
    public void onCartImageClick(pojo item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedItem", item);
        Navigation.findNavController(requireView())
                .navigate(R.id.nav_cart, bundle);
    }
}


