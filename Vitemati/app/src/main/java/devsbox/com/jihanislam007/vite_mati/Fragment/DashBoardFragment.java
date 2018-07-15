package devsbox.com.jihanislam007.vite_mati.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import devsbox.com.jihanislam007.vite_mati.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {


    public DashBoardFragment() {
        // Required empty public constructor
    }

    private TextView stickyView;
    private ListView listView;
    private View heroImageView;

    private View stickyViewSpacer;
    private int MAX_ROWS = 20;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dash_board, container, false);

        /////////////////////////Parallax listview//////////////////////////

        /* Initialise list view, hero image, and sticky view */
        listView = (ListView) rootView.findViewById(R.id.listView);
        heroImageView = rootView.findViewById(R.id.heroImageView);
        stickyView = (TextView) rootView.findViewById(R.id.stickyView);

        /* Inflate list header layout */
        //LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listHeader = inflater.inflate(R.layout.list_header, null);
        stickyViewSpacer = listHeader.findViewById(R.id.stickyViewPlaceholder);

        /* Add list view header */
        listView.addHeaderView(listHeader);

        /* Handle list View scroll events */
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                /* Check if the first item is already reached to top.*/
                if (listView.getFirstVisiblePosition() == 0) {
                    View firstChild = listView.getChildAt(0);
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
        List<String> modelList = new ArrayList<>();
        for (int i = 0; i < MAX_ROWS; i++) {
            modelList.add("List item " + i);
        }

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.list_row, modelList);
        listView.setAdapter(adapter);

        /////////////////////////Parallax listview//////////////////////////

        return rootView;
    }

}
