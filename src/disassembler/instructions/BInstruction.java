package disassembler.instructions;

public class BInstruction extends Instruction{

	private int branchAddress;
	
	public BInstruction(int binary, String opName, int line) {
		this.opName = opName;
		this.binary = binary;
		this.line = line;
		this.opCode = binary >> 26;
		branchAddress = (binary << 6) >> 6;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", opName, Integer.toString(line + branchAddress));
	}

}
