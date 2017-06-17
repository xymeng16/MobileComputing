package com.ishoot.ishoot.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ishoot.ishoot.Adapter.ViewHolder.RankViewHolder;
import com.ishoot.ishoot.R;
import com.ishoot.ishoot.bean.RankItem;

/**
 * Created by Xiangyi Meng on 6/18/2017.
 */

public class RankAdapter extends BaseRecycleViewAdapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rank, viewGroup, false);
        return new RankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        final RankItem rankItem = (RankItem) datas.get(i);
        final com.ishoot.ishoot.Adapter.ViewHolder.RankViewHolder holder = (com.ishoot.ishoot.Adapter.ViewHolder.RankViewHolder) viewHolder;
        holder.hitCount.setText(rankItem.getHitCount());
        holder.icon.setImageResource(R.drawable.icon);
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }


}
