package com.air.foi.diabeticcalculatorapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.air.foi.diabeticcalculatorapp.R;

import java.util.List;

import com.foi.dbcal.common.model.NamirniceObroka;

/**
 * Created by nikra on 27.11.2016..
 */

public class NamirniceObrokaRecyclerViewAdapter extends  RecyclerView.Adapter<NamirniceObrokaViewHolder>{

    List<NamirniceObroka> namirniceObrokaList;
    Context context;

    public NamirniceObrokaRecyclerViewAdapter(List<NamirniceObroka> namirniceObrokaList, Context context) {
        this.namirniceObrokaList = namirniceObrokaList;
        this.context = context;
    }

    @Override
    public NamirniceObrokaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new NamirniceObrokaViewHolder (v, this, namirniceObrokaList);
    }

    @Override
    public void onBindViewHolder(NamirniceObrokaViewHolder holder, int position) {
        holder.tvNamirnica.setText(namirniceObrokaList.get(position).getNamirnica().getNaziv());
        holder.tvKolicina.setText(String.valueOf(namirniceObrokaList.get(position).getKolicina()));
    }

    @Override
    public int getItemCount() {
        return namirniceObrokaList.size();
    }
}
