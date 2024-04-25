package disassembler.instructions;

public class ImmInstruction extends Instruction{
	int Rn;
	int Rd;
	int ALUImm;
	
	public ImmInstruction(int binary, String opName, int line) {
		this.opName = opName;
		this.binary = binary;
		this.line = line;
		Rd = (binary << 27) >> 27;
		Rn = (binary << 21) >> 27;
		ALUImm = (binary << 10) >> 21;
	}
	
	@Override
	public String toString() {
		return String.format("%s X%s, X%s, #%s", opName, Rd, Rn, ALUImm);
	}
}
