package com.project.world.lean.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PoiHelloWorld {

    public static void main(String[] args) throws IOException {

        Workbook workbook = HSSFWorkbookFactory.create(sourceFile(), null, true);

        Sheet firstSheet = workbook.createSheet("Test11");
        for (int rowNum = 23; rowNum < 10000; rowNum++) {
            firstSheet.createRow(rowNum).createCell(0).setCellValue(rowNum);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        FileCopyUtils.copy(outputStream.toByteArray(), new File("test2.xlsx"));
        outputStream.close();

        FileCopyUtils.copy(sourceFile(), new File("test3.xlsx"));
    }

    private static File sourceFile() throws FileNotFoundException {
        return ResourceUtils.getFile("classpath:data/Test.xlsx");
    }
}
