package devsbox.com.jihanislam007.vite_mati.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import devsbox.com.jihanislam007.vite_mati.Adapter.LandListAdapter;
import devsbox.com.jihanislam007.vite_mati.ModelClass.LandList;
import devsbox.com.jihanislam007.vite_mati.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandListFragment extends Fragment {

    ListView LandListListview;
    ArrayList<LandList> landLists = new ArrayList<>();
    LandListAdapter landListAdapter;
    Context context;

    Spinner DivisionSpinner,
            DistrictSpinner,
            StationSpinner;

    public LandListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_land_list, container, false);

        //////////////////////////listView start////////////////////////////
        LandListListview = (ListView) rootView.findViewById(R.id.LandListListview);

        landListAdapter=new LandListAdapter(getContext(),landLists);
        LandListListview.setAdapter(landListAdapter);

        testdata();
        //////////////////////////listView finish////////////////////////////

        //////////////////////////Spinner start/////////////////////////////

        DivisionSpinner = rootView.findViewById(R.id.DivisionSpinner);
        DistrictSpinner = rootView.findViewById(R.id.DistrictSpinner);
        StationSpinner = rootView.findViewById(R.id.StationSpinner);

        //DivisionSpinner.setTextColor(Color.BLACK);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("ঢাকা");
        categories.add("চট্টগ্রাম");
        categories.add("বরিশাল");
        categories.add("খুলনা");
        categories.add("ময়মনসিংহ");
        categories.add("রাজশাহী");
        categories.add("রংপুর");
        categories.add("সিলেট");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_style, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        DivisionSpinner.setAdapter(dataAdapter);
        DistrictSpinner.setAdapter(dataAdapter);
        StationSpinner.setAdapter(dataAdapter);

        //////////////////////////Spinner finish////////////////////////////



        return rootView;
    }

    public void testdata(){

        LandList a = new LandList(1,"xyz","dhaka, sherpur , Mymenshing , Bangladesh","5000");
        landLists.add(a);

        LandList b = new LandList(1,"xyz","dhaka, sherpur","5000");
        landLists.add(b);

        LandList c = new LandList(1,"xyz","dhaka, sherpur","5000");
        landLists.add(c);

        LandList d = new LandList(1,"xyz","dhaka, sherpur","5000");
        landLists.add(d);

        LandList e = new LandList(1,"xyz","dhaka, sherpur","5000");
        landLists.add(e);



    }

}
