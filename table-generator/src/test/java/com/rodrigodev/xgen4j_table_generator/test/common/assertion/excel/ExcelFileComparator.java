package com.rodrigodev.xgen4j_table_generator.test.common.assertion.excel;

import org.apache.poi.ss.usermodel.*;
import org.assertj.core.api.Condition;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class ExcelFileComparator extends Condition<InputStream> {

    private InputStream expectedInputStream;

    public ExcelFileComparator(InputStream expectedInputStream) {
        this.expectedInputStream = expectedInputStream;
    }

    @Override
    public boolean matches(InputStream actualInputStream) {

        boolean result = true;

        try {
            try (Workbook expectedWb = WorkbookFactory.create(expectedInputStream)) {
                Sheet expectedSheet = expectedWb.getSheetAt(0);

                try (Workbook actualWb = WorkbookFactory.create(actualInputStream)) {
                    Sheet actualSheet = actualWb.getSheetAt(0);

                    int expectedRowCount = expectedSheet.getLastRowNum();
                    for (int r = 0; r <= expectedRowCount; r++) {
                        Row expectedRow = expectedSheet.getRow(r);
                        Row actualRow = actualSheet.getRow(r);
                        if (actualRow == null) {
                            actualRow = actualSheet.createRow(r);
                        }

                        int expectedCellCount = expectedRow.getLastCellNum();
                        for (int c = 0; c < expectedCellCount; c++) {
                            Cell expectedCell = expectedRow.getCell(c, Row.CREATE_NULL_AS_BLANK);
                            Cell actualCell = actualRow.getCell(c, Row.CREATE_NULL_AS_BLANK);

                            if (expectedCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                assertThat(actualCell.getNumericCellValue())
                                        .isEqualTo(expectedCell.getNumericCellValue(), offset(0.00001));
                            }
                            else {
                                expectedCell.setCellType(Cell.CELL_TYPE_STRING);
                                actualCell.setCellType(Cell.CELL_TYPE_STRING);
                                assertThat(actualCell.getStringCellValue())
                                        .isEqualTo(expectedCell.getStringCellValue());
                            }
                        }
                    }
                }
            }
        }
        catch (AssertionError error) {
            describedAs(error.getMessage());
            result = false;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
