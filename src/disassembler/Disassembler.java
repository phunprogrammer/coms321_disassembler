package disassembler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import disassembler.instructions.BInstruction;
import disassembler.instructions.CBInstruction;
import disassembler.instructions.DInstruction;
import disassembler.instructions.ImmInstruction;
import disassembler.instructions.Instruction;
import disassembler.instructions.RInstruction;

public class Disassembler {
	
	private List<Integer> binaryInstructions;
	private List<Instruction> instructions;

	
	// CONSTANT OPCODE RANGES
	private static final int BRANCH_RANGE = 191;
	private static final int BRANCHCOND_RANGE = 679;
	private static final int AND_RANGE = 1104;
	private static final int ADD_RANGE = 1112;
	private static final int ADDI_RANGE = 1161;
	private static final int ANDI_RANGE = 1169;
	private static final int BRANCHLINK_RANGE = 1215;
	private static final int MUL_RANGE = 1240;
	private static final int ORR_RANGE = 1360;
	private static final int ORRI_RANGE = 1425;
	private static final int CBZ_RANGE = 1447;
	private static final int CBNZ_RANGE = 1455;
	private static final int EOR_RANGE = 1616;
	private static final int SUB_RANGE = 1624;
	private static final int SUBI_RANGE = 1673;
	private static final int EORI_RANGE = 1681;
	private static final int LSR_RANGE = 1690;
	private static final int LSL_RANGE = 1691;
	private static final int BRANCHREGISTER_RANGE = 1712;
	private static final int SUBS_RANGE = 1880;
	private static final int SUBIS_RANGE = 1929;
	private static final int STUR_RANGE = 1984;
	private static final int LDUR_RANGE = 1986;
	private static final int PRNL_RANGE = 2044;
	private static final int PRNT_RANGE = 2045;
	private static final int DUMP_RANGE = 2046;
	private static final int HALT_RANGE = 2047;
	
	
	
	
	public Disassembler(String fileName) throws IOException {
		this.binaryInstructions = Converter.BinaryToInt(fileName, false);
		instructions = new ArrayList<>();
	}
	
	private void determineOp(int opCode, int binI, int line) {
		if (opCode <= BRANCH_RANGE) {
			instructions.add(new BInstruction(binI, "B", line));
		} else if (opCode <= BRANCHCOND_RANGE) {
			instructions.add(new CBInstruction(binI, "B", line));
		} else if (opCode <= AND_RANGE) {
			instructions.add(new RInstruction(binI, "AND", line));
		} else if (opCode <= ADD_RANGE) {
			instructions.add(new RInstruction(binI, "ADD", line));
		} else if (opCode <= ADDI_RANGE) {
			instructions.add(new ImmInstruction(binI, "ADDI", line));
		} else if (opCode <= ANDI_RANGE) {
			instructions.add(new ImmInstruction(binI, "ANDI", line));
		} else if (opCode <= BRANCHLINK_RANGE) {
			instructions.add(new BInstruction(binI, "BL", line));
		} else if (opCode <= MUL_RANGE) {
			instructions.add(new RInstruction(binI, "MUL", line));
		} else if (opCode <= ORR_RANGE) {
			instructions.add(new RInstruction(binI, "ORR", line));
		} else if (opCode <= ORRI_RANGE) {
			instructions.add(new ImmInstruction(binI, "ORRI", line));
		} else if (opCode <= CBZ_RANGE) {
			instructions.add(new CBInstruction(binI, "CBZ", line));
		} else if (opCode <= CBNZ_RANGE) {
			instructions.add(new CBInstruction(binI, "CBNZ", line));
		} else if (opCode <= EOR_RANGE) {
			instructions.add(new RInstruction(binI, "EOR", line));
		} else if (opCode <= SUB_RANGE) {
			instructions.add(new RInstruction(binI, "SUB", line));
		} else if (opCode <= SUBI_RANGE) {
			instructions.add(new ImmInstruction(binI, "SUBI", line));
		} else if (opCode <= EORI_RANGE) {
			instructions.add(new ImmInstruction(binI, "EORI", line));
		} else if (opCode <= LSR_RANGE) {
			instructions.add(new RInstruction(binI, "LSR", line));
		} else if (opCode <= LSL_RANGE) {
			instructions.add(new RInstruction(binI, "LSL", line));
		} else if (opCode <= BRANCHREGISTER_RANGE) {
			instructions.add(new RInstruction(binI, "BR", line));
		} else if (opCode <= SUBS_RANGE) {
			instructions.add(new RInstruction(binI, "SUBS", line));
		} else if (opCode <= SUBIS_RANGE) {
			instructions.add(new ImmInstruction(binI, "SUBIS", line));
		} else if (opCode <= STUR_RANGE) {
			instructions.add(new DInstruction(binI, "STUR", line));
		} else if (opCode <= LDUR_RANGE) {
			instructions.add(new DInstruction(binI, "LDUR", line));
		} else if (opCode <= PRNL_RANGE) {
			instructions.add(new RInstruction(binI, "PRNL", line));
		} else if (opCode <= PRNT_RANGE) {
			instructions.add(new RInstruction(binI, "PRNT", line));
		} else if (opCode <= DUMP_RANGE) {
			instructions.add(new RInstruction(binI, "DUMP", line));
		} else if (opCode <= HALT_RANGE) {
			instructions.add(new RInstruction(binI, "HALT", line));
		} 
	}
	
	public void disassembleInstructions() throws IOException {
		instructions.clear();
		for (int curIndex = 0; curIndex < binaryInstructions.size(); curIndex++) {
			int binI = binaryInstructions.get(curIndex);
			long binL = (long)(binI) & 0x00000000ffffffffL;
			int opCode = (int)(binL >>> 21);
			determineOp(opCode, (int)binI, curIndex + 1);
		}
	}

	public void printInstructions() {
		for (int curIndex = 0; curIndex < instructions.size(); curIndex++) {
			Instruction curInstruction = instructions.get(curIndex);
			System.out.println(String.format("%d:%c %s", curInstruction.getLine(), ' ', curInstruction.toString()));
		}
	}
}
