package disassembler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import disassembler.instructions.ImmInstruction;
import disassembler.instructions.Instruction;
import disassembler.instructions.RInstruction;

public class Disassembler {
	
	private List<Integer> binaryInstructions;
	private List<Instruction> instructions;

	
	// CONSTANT OPCODE RANGES
	private static final int BRANCH_RANGE = 191;
	private static final int BRANCHCOND_RANGE = 679;
	private static final int ORRI_RANGE = 713;
	private static final int EORI_RANGE = 841;
	private static final int AND_RANGE = 1104;
	private static final int ADD_RANGE = 1112;
	private static final int ADDI_RANGE = 1161;
	private static final int ANDI_RANGE = 1169;
	private static final int BRANCHLINK_RANGE = 1215;
	private static final int MUL_RANGE = 1240;
	private static final int ORR_RANGE = 1360;
	private static final int CBZ_RANGE = 1447;
	private static final int CBNZ_RANGE = 1455;
	private static final int EOR_RANGE = 1616;
	private static final int SUB_RANGE = 1624;
	private static final int SUBI_RANGE = 1673;
	private static final int LSR_RANGE = 1690;
	private static final int LSL_RANGE = 1691;
	private static final int BRANCHREGISTER_RANGE = 1712;
	private static final int SUBS_RANGE = 1880;
	private static final int SUBIS_RANGE = 1929;
	private static final int PRNL_RANGE = 2044;
	private static final int PRNT_RANGE = 2045;
	private static final int DUMP_RANGE = 2046;
	private static final int HALT_RANGE = 2047;
	
	
	
	
	public Disassembler(List<Integer> binaryInstructions) {
		this.binaryInstructions = binaryInstructions;
		instructions = new ArrayList<>();
	}
	
	private void determineOp(int opCode, int binI) {
		if (opCode <= BRANCH_RANGE) {
			Operations.branch(binI);
		} else if (opCode <= BRANCHCOND_RANGE) {
			Operations.branchCond(binI);
		} else if (opCode <= ORRI_RANGE) {
			instructions.add(new ImmInstruction(binI, "ORRI"));
		} else if (opCode <= EORI_RANGE) {
			instructions.add(new ImmInstruction(binI, "EORI"));
		} else if (opCode <= AND_RANGE) {
			instructions.add(new RInstruction(binI, "AND"));
		} else if (opCode <= ADD_RANGE) {
			instructions.add(new RInstruction(binI, "ADD"));
		} else if (opCode <= ADDI_RANGE) {
			instructions.add(new ImmInstruction(binI, "ADDI"));
		} else if (opCode <= ANDI_RANGE) {
			instructions.add(new ImmInstruction(binI, "ANDI"));
		} else if (opCode <= BRANCHLINK_RANGE) {
			Operations.branchLink(binI);
		} else if (opCode <= MUL_RANGE) {
			instructions.add(new RInstruction(binI, "MUL"));
		} else if (opCode <= ORR_RANGE) {
			Operations.orr(binI);
		} else if (opCode <= CBZ_RANGE) {
			Operations.cbz(binI);
		} else if (opCode <= CBNZ_RANGE) {
			Operations.cbnz(binI);
		} else if (opCode <= EOR_RANGE) {
			instructions.add(new RInstruction(binI, "EOR"));
		} else if (opCode <= SUB_RANGE) {
			instructions.add(new RInstruction(binI, "SUB"));
		} else if (opCode <= SUBI_RANGE) {
			instructions.add(new ImmInstruction(binI, "SUBI"));
		} else if (opCode <= LSR_RANGE) {
			Operations.lsr(binI);
		} else if (opCode <= LSL_RANGE) {
			Operations.lsl(binI);
		} else if (opCode <= BRANCHREGISTER_RANGE) {
			Operations.branchRegister(binI);
		} else if (opCode <= SUBS_RANGE) {
			instructions.add(new RInstruction(binI, "SUBS"));
		} else if (opCode <= SUBIS_RANGE) {
			instructions.add(new ImmInstruction(binI, "SUBIS"));
		} else if (opCode <= PRNL_RANGE) {
			Operations.prnl(binI);
		} else if (opCode <= PRNT_RANGE) {
			Operations.prnt(binI);
		} else if (opCode <= DUMP_RANGE) {
			Operations.dump(binI);
		} else if (opCode <= HALT_RANGE) {
			Operations.halt(binI);
		} 
	}
	
	public void disassembleInstructions() throws IOException {
		for (int curIndex = 0; curIndex < binaryInstructions.size(); curIndex++) {
			int binI = binaryInstructions.get(curIndex);
			long binL = (long)(binI) & 0x00000000ffffffffL;
			int opCode = (int)(binL >> 21);
			determineOp(opCode, (int)binI);
		}
	}

	public void PrintInstructions() {
		for (int curIndex = 0; curIndex < instructions.size(); curIndex++) {
			System.out.println(instructions.get(curIndex));
		}
	}
}
