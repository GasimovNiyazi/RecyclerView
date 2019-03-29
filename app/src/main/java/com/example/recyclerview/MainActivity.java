package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.recyclerview.model.Data;
import com.example.recyclerview.ui.RecyclerViewAdapter;
import com.example.recyclerview.utilits.Constants;
import com.example.recyclerview.utilits.PaginationScrollListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity   {

    private static final String TAG = "MainActivity";


    @BindView(R.id.recyler_view)
    RecyclerView mRecyclerView;


    private RecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private int mCurrentPage= Constants.PAGE_START;
    private boolean isLastPage=false;
    private int mTotalPage=5;
    private boolean isLoading=false;
    int itemCount=0;


    private ArrayList<Data> mPersonData = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



        initImageBitmaps();
        initRecyclerView();
        preparedListItem();
    }




    private void initImageBitmaps(){



        mPersonData.add(new Data("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "Adam","Chief"));
        mPersonData.add(new Data("My Notes","12 Mar 2018"));
        mPersonData.add(new Data("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "Adam","Chief"));
        mPersonData.add(new Data("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "Adam","Chief"));
        mPersonData.add(new Data("My Notes","12 Mar 2018"));
        mPersonData.add(new Data("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "Adam","Chief"));
        mPersonData.add(new Data("My Notes","12 Mar 2018"));
        mPersonData.add(new Data("My Notes","12 Mar 2018"));





    }

    private void initRecyclerView(){
        Log.d(TAG, "init recyclerview.");
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewAdapter(this, mPersonData);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addOnScrollListener(new PaginationScrollListener(mLayoutManager) {

            @Override
            protected void loadMoreItems() {

                isLoading=true;
                mCurrentPage++;
                preparedListItem();
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return false;
            }
        });

    }
    private void preparedListItem() {

      final List<Data> mData=new ArrayList<>();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random=new Random();


                for(int i=0;i<5;i++){
                    int ran=random.nextInt(2);
                    itemCount++;

                    Data data;

                    if(ran==0){
                        data=new Data("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                                "Adam"+itemCount,"Chief");

                    }else {
                        data=new Data(
                                "My Notes "+itemCount,"19 Mar 2019");
                    }

              mData.add(data);

                }


                if(mCurrentPage !=Constants.PAGE_START)mAdapter.removeLoadingFooter();
                mAdapter.addAll(mData);
                if(mCurrentPage<mTotalPage)mAdapter.addLoadingFooter();
                else isLastPage=true;
                isLoading=false;

            }
        },1500);


    }


}
