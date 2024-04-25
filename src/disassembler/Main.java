package disassembler;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Disassembler dis = new Disassembler(args[0]);
		dis.disassembleInstructions();
		dis.printInstructions();
	}
}
