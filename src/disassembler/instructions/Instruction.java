package disassembler.instructions;

public abstract class Instruction {
    protected String opName;
    protected int opCode;
    protected int binary;
    protected int line;

    public abstract String toString();
}
