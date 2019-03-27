package pdf;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


/**
 * 用于合并一个文件夹下所有的PDF文件到一个PDF文件中
 */
public class PDFMerger {

    public static void main(String[] args) throws IOException {

        String dirPath = args[0];
        String pdfExt = args[1];

        File dir = new File(dirPath);

        PDFMergerUtility ut = new PDFMergerUtility();
        ut.setDestinationFileName(dir.getName() + pdfExt);

        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.getName().toLowerCase().endsWith(pdfExt)) {
                ut.addSource(file);
            }
        }

        ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }
}
