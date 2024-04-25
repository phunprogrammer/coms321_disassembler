package disassembler;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Disassembler dis = new Disassembler("321assignment1.txt.machine");
		dis.disassembleInstructions();
		dis.printInstructions();
	}
}
