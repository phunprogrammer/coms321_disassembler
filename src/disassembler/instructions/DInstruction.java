package disassembler.instructions;

public class DInstruction extends Instruction{
    private int DTAddress;
    @SuppressWarnings("unused")
    private int op;
    private int Rn;
    private int Rt;

    public DInstruction(int binary, String name, int line) {
        super(binary, name, line);
        this.DTAddress = (binary << 11) >>> 23;
        this.op = (binary << 20) >>> 30;
        this.Rn = (binary << 22) >>> 27;
        this.Rt = (binary << 27) >>> 27;
    }

    public String toString() {
        return String.format("%s X%d, [X%d, #%d]", opName, Rt, Rn, DTAddress);
    }
}
