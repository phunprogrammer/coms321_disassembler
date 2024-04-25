package disassembler.instructions;

import java.util.HashMap;
import java.util.Map;

public class CBInstruction extends Instruction {
    private int Rt;
    private int condBRAddress;

    private static final Map<Integer, String> COND_STRINGS;
    static {
        COND_STRINGS = new HashMap<>();
        COND_STRINGS.put(0, "EQ");
        COND_STRINGS.put(1, "NE");
        COND_STRINGS.put(2, "HS");
        COND_STRINGS.put(3, "LO");
        COND_STRINGS.put(4, "MI");
        COND_STRINGS.put(5, "PL");
        COND_STRINGS.put(6, "VS");
        COND_STRINGS.put(7, "VC");
        COND_STRINGS.put(8, "HI");
        COND_STRINGS.put(9, "LS");
        COND_STRINGS.put(10, "GE");
        COND_STRINGS.put(11, "LT");
        COND_STRINGS.put(12, "GT");
        COND_STRINGS.put(13, "LE");
    }

    public CBInstruction(int binary, String name, int line) {
        super(binary, name, line);

        this.condBRAddress = (binary << 8) >> 13;
        this.Rt = (binary << 27) >>> 27;
    }

    public String toString() {
        String out = String.format("%s.%s %d", opName, COND_STRINGS.get(Rt), line + condBRAddress);

        if(opName.equals("CBZ") || opName.equals("CBNZ"))
            out = String.format("%s X%d, %d", opName, Rt, line + condBRAddress);
        
        return out;
    }
}
