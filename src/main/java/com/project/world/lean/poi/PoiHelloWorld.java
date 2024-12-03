package com.project.world.lean.poi;

import cn.hutool.core.io.FileUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class PoiHelloWorld {

    public static void main(String[] args) throws IOException {


        Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(FileUtil.readBytes(sourceFile())));

        Sheet firstSheet = workbook.getSheetAt(0);
        firstSheet.shiftRows(16, firstSheet.getLastRowNum(), 10, true, true);
//        for (int rowNum = 16; rowNum < 10; rowNum++) {
//            firstSheet.createRow(rowNum).createCell(0).setCellValue("test" + rowNum);
//        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        FileCopyUtils.copy(outputStream.toByteArray(), new File("test2.xlsx"));
        outputStream.close();
    }

    private static File sourceFile() throws FileNotFoundException {
        return ResourceUtils.getFile("classpath:data/Test.xlsx");
    }
}
