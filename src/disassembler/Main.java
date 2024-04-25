package disassembler;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Disassembler dis = new Disassembler("test1.txt.machine");
		dis.disassembleInstructions();
		dis.PrintInstructions();
	}
}
