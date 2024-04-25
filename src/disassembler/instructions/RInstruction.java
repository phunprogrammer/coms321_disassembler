package disassembler.instructions;

public class RInstruction extends Instruction {
    private int Rm;
    private int shamt;
    private int Rn;
    private int Rd;

    public RInstruction(int binary, String name, int line) {
        super(binary, name, line);
        this.opCode = binary >> 21;
        this.Rm = (binary << 12) >> 27;
        this.shamt = (binary << 16) >> 27;
        this.Rn = (binary << 21) >> 27;
		this.Rd = (binary << 27) >> 27;
    }

    @Override
    public String toString() {
        String out = String.format("%s X%d, X%d, X%d", opName, Rd, Rn, Rm);

        if(opName.equals("BR")) {
            out = String.format("%s X%d", opName, Rn);
        } else if(opName.equals("LSR") || opName.equals("LSL")) {
            out = String.format("%s X%d", opName, Rd);
        } else if(opName.equals("PRNL") || opName.equals("PRNT")) {
            out = String.format("%s X%d, #%d", opName, Rn, shamt);
        } else if(opName.equals("DUMP") || opName.equals("HALT")) {
            out = String.format("%s", opName);
        }
        return out;
    }
}
