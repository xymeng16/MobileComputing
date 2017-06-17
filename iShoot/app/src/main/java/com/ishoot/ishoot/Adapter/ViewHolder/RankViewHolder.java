package com.ishoot.ishoot.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ishoot.ishoot.R;

import org.w3c.dom.Text;

/**
 * Created by Xiangyi Meng on 6/18/2017.
 */

public class RankViewHolder extends RecyclerView.ViewHolder {
    public TextView rank;
    public ImageView icon;
    public TextView hitCount;
    public RankViewHolder(View itemView) {
        super(itemView);
        rank = (TextView) itemView.findViewById(R.id.rank);
        icon = (ImageView)itemView.findViewById(R.id.icon);
        hitCount = (TextView) itemView.findViewById(R.id.hitCount);
    }
}
