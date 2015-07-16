package com.rodrigodev.xgen4j_table_generator.model.table;

import org.apache.poi.ss.usermodel.Cell;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
public class Row {

    final private org.apache.poi.ss.usermodel.Row row;
    private int cellNum;

    public Row(org.apache.poi.ss.usermodel.Row row) {
        this.row = row;
    }

    public Cell newCell() {
        return row.createCell(cellNum++);
    }
}
