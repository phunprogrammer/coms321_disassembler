package disassembler;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class converter {
    static List<Integer> BinaryToInt(String filename) throws IOException {
        FileInputStream file;

        try {
            file = new FileInputStream(filename);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
        DataInputStream binaryStream = new DataInputStream(file);

        List<Integer> bigEndianList = new ArrayList<>();

        while(binaryStream.available() > 0) {
            int bigEndian = binaryStream.readInt();

            bigEndianList.add(bigEndian);
            //System.out.println(String.format("%32s", Integer.toBinaryString(bigEndian)).replace(' ', '0'));
        }

        binaryStream.close();
        return bigEndianList;
    }
}
