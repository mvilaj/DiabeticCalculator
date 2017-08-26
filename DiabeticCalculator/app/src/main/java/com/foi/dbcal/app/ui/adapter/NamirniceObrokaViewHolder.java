package com.foi.dbcal.app.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.foi.dbcal.app.R;

import java.util.List;

import com.foi.dbcal.common.model.NamirniceObroka;

/**
 * Created by nikra on 27.11.2016..
 */

public class NamirniceObrokaViewHolder extends RecyclerView.ViewHolder {

    public NamirniceObrokaRecyclerViewAdapter adapter;
    private Context context;
    private List<NamirniceObroka> items;

    public TextView tvKolicina;
    public TextView tvNamirnica;

    public NamirniceObrokaViewHolder(View itemView, NamirniceObrokaRecyclerViewAdapter adapter, List<NamirniceObroka> items) {
        super(itemView);

        tvKolicina = (TextView) itemView.findViewById(R.id.tvKolicina);
        tvNamirnica = (TextView) itemView.findViewById(R.id.tvNamirnica);
        this.context = itemView.getContext();
        this.adapter = adapter;
        this.items = items;
    }
}
