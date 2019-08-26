package com.project.world.lean.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PoiHelloWorld {

    public static void main(String[] args) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get("Payment Report_v1.2.xlsx"));
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
        Workbook workbook = HSSFWorkbookFactory.create(inputStream);

        Sheet firstSheet = workbook.createSheet("first");
        for (int rowNum = 0; rowNum < 10000; rowNum++) {
            firstSheet.createRow(rowNum).createCell(0).setCellValue(rowNum);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        FileCopyUtils.copy(outputStream.toByteArray(), new File("test2.xls"));

        outputStream.close();
    }
}
