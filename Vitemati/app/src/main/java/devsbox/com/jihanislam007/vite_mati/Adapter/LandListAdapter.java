package devsbox.com.jihanislam007.vite_mati.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import devsbox.com.jihanislam007.vite_mati.Activity.MainActivity;
import devsbox.com.jihanislam007.vite_mati.Fragment.LandDetailsFragment;
import devsbox.com.jihanislam007.vite_mati.ModelClass.LandList;
import devsbox.com.jihanislam007.vite_mati.R;

public class LandListAdapter extends ArrayAdapter {

    Context mcontext;
    ArrayList<LandList> landLists;

    public LandListAdapter(Context mcontext, ArrayList<LandList> landLists) {
        super(mcontext, R.layout.row_custom_listview);
        this.mcontext = mcontext;
        this.landLists = landLists;

    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        //android.view.LayoutInflater inflater = context.getLayoutInflater();
        LayoutInflater inflater = LayoutInflater.from(mcontext);

        View rowView= inflater.inflate(R.layout.row_custom_listview, null, true);


        TextView wonnerlistTV = (TextView) rowView.findViewById(R.id.wonnerlistTV);
        TextView LandAddressTv = (TextView) rowView.findViewById(R.id.LandAddressTv);
        TextView LandPriceTv = (TextView) rowView.findViewById(R.id.LandPriceTv);
        LinearLayout DetailsLinearLayout = (LinearLayout) rowView.findViewById(R.id.DetailsLinearLayout);

        /*ImageView backgroundImageView = (ImageView) rowView.findViewById(R.id.backgroundImageView);

        Glide.with(mcontext)
                .load(categoryItemList.get(position).getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(backgroundImageView);*/

        wonnerlistTV.setText(landLists.get(position).getWonner_name());
        LandAddressTv.setText(landLists.get(position).getLand_address()+"");
        LandPriceTv.setText(landLists.get(position).getLand_price()+"");

        DetailsLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.os.Bundle bundle=new android.os.Bundle();

                /*bundle.putString("TitleName", categoryItemList.get(position).getTitleName());
                bundle.putString("Image",categoryItemList.get(position).getImageURL());
                bundle.putString("elaments",categoryItemList.get(position).getUpokoron());
                bundle.putString("procedure",categoryItemList.get(position).getProcedure());*/

                LandDetailsFragment landDetailsFragment = new LandDetailsFragment();
              //  detailsViewFragment.setArguments(bundle);

                FragmentTransaction fragTransaction = ((MainActivity)mcontext).getSupportFragmentManager().beginTransaction();
                fragTransaction.replace(R.id.frag_container,landDetailsFragment );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();
            }
        });

        return rowView;
    }

    @Override
    public int getCount() {
        return landLists.size();
    }
}