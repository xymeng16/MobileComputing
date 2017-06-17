package com.ishoot.ishoot.bean;

import android.media.Image;

/**
 * Created by Xiangyi Meng on 6/17/2017.
 */

public class RankItem {
    private int rank;
    private String name;
    private int icon;
    private String hitCount;
    public RankItem(int r, String n, int i, String h) {
        rank = r;
        name = n;
        icon = i;
        hitCount = h;
    }
    public String getHitCount() {
        return hitCount;
    }

    public void setHitCount(String hitCount) {
        this.hitCount = hitCount;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
