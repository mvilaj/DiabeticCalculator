package com.foi.dbcal.common.service;

import android.content.Context;
import android.widget.TableRow;

import java.util.List;

/**
 * Created by nikra on 08/25/17.
 */

public interface TableData {
    public TableRow getTableHeader (Context conn);

    public List<TableRow> getNatasteTableRows (Context conn);
    public List<TableRow> getPrijeTableRows (Context conn);
    public List<TableRow> getNakonTableRows (Context conn);
}
