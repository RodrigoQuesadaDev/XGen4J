package com.rodrigodev.xgen4j_table_generator.model.table.cell;

import com.rodrigodev.xgen4j_table_generator.model.information.ErrorInfoWrapper;
import org.apache.poi.ss.usermodel.Cell;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
@Singleton
public class NumericIdCellWriter extends CellWriter {

    private static final String HEADER = "Numeric ID";

    @Inject
    public NumericIdCellWriter() {
        super(HEADER);
    }

    @Override
    protected boolean shouldWrite(ErrorInfoWrapper errorInfo) {
        return !errorInfo.code().numericId().isEmpty();
    }

    @Override
    protected void writeToCell(Cell cell, ErrorInfoWrapper errorInfo) {
        cell.setCellValue(errorInfo.code().numericId());
    }
}
