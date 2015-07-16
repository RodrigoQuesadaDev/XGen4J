package com.rodrigodev.xgen4j_table_generator.model.table.cell;

import com.rodrigodev.xgen4j_table_generator.model.information.ErrorInfoWrapper;
import org.apache.poi.ss.usermodel.Cell;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
@Singleton
public class DescriptionCellWriter extends CellWriter {

    private static final String HEADER = "Description";

    @Inject
    public DescriptionCellWriter() {
        super(HEADER);
    }

    @Override
    public void writeToCell(Cell cell, ErrorInfoWrapper errorInfo) {
        cell.setCellValue(errorInfo.description().map(
                d -> d.usesCustomMessageGenerator()
                        ? ((Class<?>) d.description()).getSimpleName()
                        : d.description().toString()
        ).orElse(""));
    }
}
