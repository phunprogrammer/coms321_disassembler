package disassembler.instructions;

public class ImmInstruction extends Instruction{
	int Rn;
	int Rd;
	int ALUImm;
	
	public ImmInstruction(int binary, String opName, int line) {
		super(binary, opName, line);
		this.opCode = binary >>> 22; 
		Rd = (binary << 27) >>> 27;
		Rn = (binary << 22) >>> 27;
		ALUImm = (binary << 10) >>> 20;
	}
	
	@Override
	public String toString() {
		return String.format("%s X%s, X%s, #%s", opName, Rd, Rn, ALUImm);
	}
}
