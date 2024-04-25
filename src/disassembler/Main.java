package disassembler;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Disassembler dis = new Disassembler("assignment1.legv8asm");
		dis.disassembleInstructions();
		dis.PrintInstructions();
	}
}
