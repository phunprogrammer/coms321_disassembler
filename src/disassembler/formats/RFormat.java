package disassembler.formats;

public class RFormat extends Instruction {
    String opName;
    int opCode;
    int Rm;
    int shamt;
    int Rn;
    int Rd;

    public RFormat(int binary, String name) {
        this.binary = binary;
        opName = name;
        opCode = binary >> 21;
        Rm = (binary << 11) >> 27;
        shamt = (binary << 15) >> 26;
        Rn = (binary << 21) >> 26;
		Rd = (binary << 26) >> 26;
    }

    @Override
    public String toString() {
        return String.format("%s X%s, X%s, X%s", opName, Rd, Rn, Rm);
    }
}
