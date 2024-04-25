package disassembler.instructions;

public class RInstruction extends Instruction {
    private int Rm;
    private int shamt;
    private int Rn;
    private int Rd;

    public RInstruction(int binary, String name, int line) {
        this.binary = binary;
        this.opName = name;
        this.line = line;
        this.opCode = binary >> 21;
        this.Rm = (binary << 11) >> 27;
        this.shamt = (binary << 15) >> 26;
        this.Rn = (binary << 21) >> 26;
		this.Rd = (binary << 26) >> 26;
    }

    @Override
    public String toString() {
        String out = String.format("%s X%d, X%d, X%d", opName, Rd, Rn, Rm);

        if(opName.equals("BR"))
            out = String.format("%s X%d", opName, Rn);

        return out;
    }
}
