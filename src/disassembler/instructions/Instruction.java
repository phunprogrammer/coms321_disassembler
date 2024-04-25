package disassembler.instructions;

public abstract class Instruction {
    protected String opName;
    protected int opCode;
    protected int binary;
    protected int line;

    protected Instruction(int binary, String name, int line) {
        this.binary = binary;
        this.opName = name;
        this.line = line;
    }

    public abstract String toString();
}
