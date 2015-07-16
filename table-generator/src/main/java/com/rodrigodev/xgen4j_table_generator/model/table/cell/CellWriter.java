package com.rodrigodev.xgen4j_table_generator.model.table.cell;

import com.rodrigodev.xgen4j_table_generator.model.information.ErrorInfoWrapper;
import com.rodrigodev.xgen4j_table_generator.model.table.Row;
import lombok.experimental.FieldDefaults;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
@FieldDefaults(makeFinal = true)
public abstract class CellWriter {

    private String header;

    public CellWriter(String header) {
        this.header = header;
    }

    protected boolean shouldWrite(ErrorInfoWrapper errorInfo) {
        return true;
    }

    final public void writeHeader(Row row, ErrorInfoWrapper errorInfo) {
        if (shouldWrite(errorInfo)) {
            row.newCell().setCellValue(header);
        }
    }

    final public void writeContent(Row row, ErrorInfoWrapper errorInfo) {
        if (shouldWrite(errorInfo)) {
            writeToCell(row.newCell(), errorInfo);
        }
    }

    protected abstract void writeToCell(Cell cell, ErrorInfoWrapper errorInfo);
}
