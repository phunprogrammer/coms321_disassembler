package disassembler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class temp {
	public static void main(String[] args) throws IOException {
		List<Integer> instructions = new ArrayList<>();
		instructions.add(-1962737599);

		Disassembler dis = new Disassembler(instructions);
		dis.disassembleInstructions();
		dis.PrintInstructions();
	}
}
