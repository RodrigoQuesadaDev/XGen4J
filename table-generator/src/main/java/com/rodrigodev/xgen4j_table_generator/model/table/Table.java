package com.rodrigodev.xgen4j_table_generator.model.table;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
public class Table {

    final private Sheet sheet;
    private int rowNum;

    public Table(Sheet sheet) {
        this.sheet = sheet;
    }

    public Row newRow() {
        return new Row(sheet.createRow(rowNum++));
    }
}
