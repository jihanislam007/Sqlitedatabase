package devsbox.com.jihanislam007.vite_mati.Fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import devsbox.com.jihanislam007.vite_mati.Adapter.LandListAdapter;
import devsbox.com.jihanislam007.vite_mati.ModelClass.LandList;
import devsbox.com.jihanislam007.vite_mati.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {


    public DashBoardFragment() {
        // Required empty public constructor
    }

    private LinearLayout stickyView;
    private View heroImageView;

    private View stickyViewSpacer;
    private int MAX_ROWS = 30;

    ListView landlistListView;
    ArrayList<LandList> landLists = new ArrayList<>();
    LandListAdapter landListAdapter;
    Context context;

    Spinner DivisionSpinner,
            DistrictSpinner,
            StationSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dash_board, container, false);



        /////////////////////////Parallax listview//////////////////////////

        /* Initialise list view, hero image, and sticky view */
        landlistListView = (ListView) rootView.findViewById(R.id.listView);
        heroImageView = rootView.findViewById(R.id.heroImageView);
        stickyView = (LinearLayout) rootView.findViewById(R.id.stickyView);

        /* Inflate list header layout */
        //LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listHeader = inflater.inflate(R.layout.list_header, null);
        stickyViewSpacer = listHeader.findViewById(R.id.stickyViewPlaceholder);

        /* Add list view header */
        landlistListView.addHeaderView(listHeader);

        /* Handle list View scroll events */
        landlistListView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                /* Check if the first item is already reached to top.*/
                if (landlistListView.getFirstVisiblePosition() == 0) {
                    View firstChild = landlistListView.getChildAt(0);
                    int topY = 0;
                    if (firstChild != null) {
                        topY = firstChild.getTop();
                    }

                    int heroTopY = stickyViewSpacer.getTop();
                    stickyView.setY(Math.max(0, heroTopY + topY));

                    /* Set the image to scroll half of the amount that of ListView */
                    heroImageView.setY(topY * 0.5f);
                }
            }
        });


           /* Populate the ListView with sample data */
      /*  List<String> modelList = new ArrayList<>();
        for (int i = 0; i < MAX_ROWS; i++) {
            modelList.add("List item " + i);
        }

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.list_row, modelList);
        listView.setAdapter(adapter);*/

        landListAdapter=new LandListAdapter(getContext(),landLists);
        landlistListView.setAdapter(landListAdapter);

        /////////////////////////Parallax listview//////////////////////////
        /////////////////////////Spinner start/////////////////////////////

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

        /////////////////////////Spinner finish/////////////////////////////
        testdata();

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
