package disassembler.instructions;

public class RInstruction extends Instruction {
    private int Rm;
    private int shamt;
    private int Rn;
    private int Rd;

    public RInstruction(int binary, String name) {
        this.binary = binary;
        this.opName = name;
        this.opCode = binary >> 21;
        this.Rm = (binary << 11) >> 27;
        this.shamt = (binary << 15) >> 26;
        this.Rn = (binary << 21) >> 26;
		this.Rd = (binary << 26) >> 26;
    }

    @Override
    public String toString() {
        return String.format("%s X%s, X%s, X%s", opName, Rd, Rn, Rm);
    }
}
