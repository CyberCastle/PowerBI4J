package cl.cc.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author CyberCastle
 */
public class FileProcessor {

    public void run() throws IOException {
        File f = new File("/Users/CyberCastle/Downloads/test.zip Folder/DataMashup");
        byte[] fileContent = FileUtils.readFileToByteArray(f);
        ByteBuffer fileContentBuffer = ByteBuffer.wrap(fileContent);

        // String searchPattern = "PK";
        /*
         * byte[] pattern = {0x0, 0x0, 0x50, 0x4b}; StreamSearcher searcher = new
         * StreamSearcher(pattern);
         * 
         * int[] positions = searcher.getFoundList(fileContentBuffer);
         * 
         * System.out.println(positions.length); System.out.println(positions[0]);
         * System.out.println(positions[1]); //System.out.println(positions[3]);
         * 
         * this.saveFile(fileContentBuffer, positions[1] - 2, fileContentBuffer.limit(),
         * new
         * File("/Users/CyberCastle/Downloads/EcocleanBI_20180327_FG.zip Folder/ee.zip")
         * );
         * 
         * 
         * File f = new
         * File("/Users/CyberCastle/Downloads/EcocleanBI_20180327_FG.zip Folder/DataMashup"
         * ); byte[] fileContent = FileUtils.readFileToByteArray(f); ByteBuffer
         * fileContentBuffer = ByteBuffer.wrap(fileContent);
         */
        String searchPattern = "LocalPackageMetadataFile";
        StreamSearcher searcher = new StreamSearcher(searchPattern.getBytes());

        int[] positions = searcher.getFoundList(fileContentBuffer);

        System.out.println(positions[0]);
        System.out.println(positions[1]);

        saveFile(fileContentBuffer, positions[0] - 1, positions[1] + searchPattern.length() + 1,
                new File("/Users/CyberCastle/Downloads/test.zip Folder/DataMashup.xml"));

        System.exit(0);

    }

    /**
     * Retrieves the content of a ByteBuffer and saves it to a file.
     */
    private void saveFile(ByteBuffer b, int offset, int len, File outFile) {
        if (len > 0) {
            FileOutputStream fileOutputStream = null;
            try {

                ByteBuffer src = b.duplicate();
                fileOutputStream = new FileOutputStream(outFile);
                FileChannel dest = fileOutputStream.getChannel();
                src.position(offset).limit(len);
                dest.write(src.slice());
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                safeClose(fileOutputStream);
            }
        }
    }

    private void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
