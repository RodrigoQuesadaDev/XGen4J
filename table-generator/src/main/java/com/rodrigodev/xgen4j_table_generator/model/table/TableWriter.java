package com.rodrigodev.xgen4j_table_generator.model.table;

import com.rodrigodev.xgen4j_table_generator.model.information.ErrorInfoWrapper;
import com.rodrigodev.xgen4j_table_generator.model.information.InformationWrapper;
import com.rodrigodev.xgen4j_table_generator.model.table.cell.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Rodrigo Quesada on 15/07/15.
 */
@Singleton
public class TableWriter {

    public static class InjectedFields {
        @Inject IdCellWriter idWriter;
        @Inject NumericIdCellWriter numericIdWriter;
        @Inject DescriptionCellWriter descriptionWriter;
        @Inject ExceptionCellWriter exceptionCellWriter;
        @Inject CommonCellWriter commonCellWriter;

        @Inject
        public InjectedFields() {
        }
    }

    private CellWriter[] cellWriters;

    @Inject
    public TableWriter(InjectedFields inj) {
        cellWriters = new CellWriter[]{
                inj.idWriter,
                inj.numericIdWriter,
                inj.descriptionWriter,
                inj.exceptionCellWriter,
                inj.commonCellWriter
        };
    }

    public void write(InformationWrapper information, OutputStream output) {
        try {
            Workbook wb = new XSSFWorkbook();
            Table table = new Table(wb.createSheet());

            writeHeaders(information, table.newRow());
            for (ErrorInfoWrapper errorInfo : information.list()) {
                writeContent(errorInfo, table.newRow());
            }

            wb.write(output);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void writeHeaders(InformationWrapper information, Row row) {
        List<ErrorInfoWrapper> infoList = information.list();
        if (!infoList.isEmpty()) {
            for (CellWriter cellWriter : cellWriters) {
                cellWriter.writeHeader(row, infoList.get(0));
            }
        }
    }

    private void writeContent(ErrorInfoWrapper errorInfo, Row row) {
        for (CellWriter cellWriter : cellWriters) {
            cellWriter.writeContent(row, errorInfo);
        }
    }
}
