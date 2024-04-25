package disassembler.formats;

public abstract class Instruction {
	protected String opName;
	protected int opCode;
	protected int binary;
	

    public abstract String toString();
    
}
