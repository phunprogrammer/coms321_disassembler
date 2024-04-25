package disassembler.instructions;

public class DInstruction extends Instruction{
    private int DTAddress;
    private int op;
    private int Rn;
    private int Rt;

    public DInstruction(int binary, String name, int line) {
        super(binary, name, line);
    }

    public String toString() {
        return null;
    }
}
