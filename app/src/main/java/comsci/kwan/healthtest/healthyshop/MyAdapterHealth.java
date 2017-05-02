package comsci.kwan.healthtest.healthyshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import comsci.kwan.healthtest.R;

/**
 * Created by kwan_raksasook on 2/5/2560.
 */

public class MyAdapterHealth extends BaseAdapter {
    //Expilcit
    private Context context;
    private String[] drinkString, sourceString, priceString;
    private int[] ints;

    public MyAdapterHealth(Context context,int[] ints, String[]drinkString, String[]sourceString, String[]priceString){
        this.context = context;
        this.ints = ints;
        this.drinkString = drinkString;
        this.sourceString = sourceString;
        this.priceString = priceString;
    }


    @Override
    public int getCount() {
        return ints.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);
        //Show food
        TextView foodTextView = (TextView) view.findViewById(R.id.txtListFood);


        //show price
        TextView priceTextView = (TextView) view.findViewById(R.id.txtListPrice);


        //show image
        ImageView foodImageView = (ImageView) view.findViewById(R.id.imvListFood);


        foodImageView.setImageResource(ints [position]);
        foodTextView.setText(drinkString[position]);
        priceTextView.setText(priceString[position]);

        return view;
    } // get view
}// mainclass
