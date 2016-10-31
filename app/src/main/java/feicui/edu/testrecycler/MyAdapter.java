package feicui.edu.testrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/8.
 */
public class MyAdapter extends RecyclerView.Adapter {
    ArrayList<String> mList;
    Context mContext;
    LayoutInflater layoutInflater;
    MyHolder holder;

    public MyAdapter(ArrayList<String> mList,Context mContext){
        this.mList=mList;
        this.mContext=mContext;
        layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /**
     * 创建ViewHolder  以及子条目的View 并且两者绑定
     * @param parent   父容器  记载此事配器的RecyclerView
     * @param viewType  类型
     * @return
     */
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //初始化子条目的view  注意：需要指定父容器 《parent》
        View view=layoutInflater.inflate(R.layout.item_two_activity,parent,false);
        //初始化ViewHolder的同时  进行子条目视图与ViewHorlder的绑定
        holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        this.holder= (MyHolder) holder;
        //对子条目上面的控件进行渲染
        ((MyHolder) holder).mTvContent.setText(mList.get(position));
        //  子条目点击事件
        ((MyHolder) holder).itemView.setOnClickListener(new MyOnClickListener(position,holder));
    }

    public class MyOnClickListener implements View.OnClickListener{

        int position;
        RecyclerView.ViewHolder holder;

        public MyOnClickListener(int position,RecyclerView.ViewHolder holder){
            this.position=position;
            this.holder=holder;
        }
        @Override
        public void onClick(View v) {

            mOnIteClickListener.onItemClick(v,position,holder);
        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnIteClickListener){
        this.mOnIteClickListener=mOnIteClickListener;
    }
   OnItemClickListener  mOnIteClickListener;
    public interface OnItemClickListener{
        void onItemClick(View v,int position,RecyclerView.ViewHolder holder);
    }


    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    /**
     * 绑定Holder和View  以及存储控件
     */
    public class MyHolder extends RecyclerView.ViewHolder{
        public TextView mTvContent;
        View itemView;

        public MyHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            mTvContent= (TextView) itemView.findViewById(R.id.itm_two_text);
        }
    }
}
