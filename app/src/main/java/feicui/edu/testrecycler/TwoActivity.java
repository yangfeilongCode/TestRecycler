package feicui.edu.testrecycler;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/8.
 */
public class TwoActivity extends Activity implements MyAdapter.OnItemClickListener {
    public RecyclerView mRecyclerView;
     MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mRecyclerView= (RecyclerView) findViewById(R.id.rv_two);
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add("item"+i);
        }
        //布局管理
       mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //3.适配器
        adapter=new MyAdapter(list,this);
        //绑定
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(this);//子条目点击
    }

    @Override
    public void onItemClick(View v, int position, RecyclerView.ViewHolder holder) {

        Toast.makeText(this,"点击"+position,Toast.LENGTH_SHORT).show();
    }
}
