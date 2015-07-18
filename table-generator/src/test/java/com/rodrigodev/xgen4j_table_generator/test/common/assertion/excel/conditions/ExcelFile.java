/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Rodrigo Quesada <rodrigoquesada.dev@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.rodrigodev.xgen4j_table_generator.test.common.assertion.excel.conditions;

import org.apache.poi.ss.usermodel.*;
import org.assertj.core.api.Condition;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 14/07/15.
 */
public class ExcelFile extends Condition<InputStream> {

    private InputStream expectedInputStream;

    public ExcelFile(InputStream expectedInputStream) {
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
