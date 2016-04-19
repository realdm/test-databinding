package henrytao.me.testdatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import henrytao.me.testdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private MainViewModel mViewModel;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new MainViewModel();
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAdapter = new Adapter(createData());
        mBinding.list.setAdapter(mAdapter);
        mBinding.list.setLayoutManager(new LinearLayoutManager(this));

        mBinding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.replaceData(createData());
                mBinding.swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private List<Integer> createData() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(i);
        }
        return data;
    }
}
