package com.yyz.gogoplay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yyz.gogoplay.R;

import java.util.List;

import static android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * Created by yyz on 2017/12/25.
 */

public class MovieRecycleAdapter  extends RecyclerView.Adapter<MovieRecycleAdapter.MovieHolder> {
    private List<String>mList;
    private Context context;
    private LayoutInflater inflater;

    public MovieRecycleAdapter(List<String> mList, Context context) {
        this.mList = mList;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_movie,null);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        holder.tvName.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MovieHolder extends ViewHolder{
        TextView tvName;

        public MovieHolder(View itemView){
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_name);
        }
    }
}
