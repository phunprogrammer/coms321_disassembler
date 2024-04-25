package disassembler;
import java.io.IOException;
import java.util.List;
import disassembler.Operations;

public class Disassembler {
	
	private String fileName;
	
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
	
	public Disassembler(String fileName) {
		this.fileName = fileName;
	}
	
	private void determineOp(int opCode, int binI) {
		if (opCode <= BRANCH_RANGE) {
			Operations.branch(binI);
		} else if (opCode <= BRANCHCOND_RANGE) {
			Operations.branchCond(binI);
		} else if (opCode <= ORRI_RANGE) {
			Operations.orrI(binI);
		} else if (opCode <= EORI_RANGE) {
			Operations.eorI(binI);
		} else if (opCode <= AND_RANGE) {
			Operations.and(binI);
		} else if (opCode <= ADD_RANGE) {
			Operations.add(binI);
		} else if (opCode <= ADDI_RANGE) {
			Operations.addI(binI);
		} else if (opCode <= ANDI_RANGE) {
			Operations.andI(binI);
		} else if (opCode <= BRANCHLINK_RANGE) {
			Operations.branchLink(binI);
		} else if (opCode <= MUL_RANGE) {
			Operations.mul(binI);
		} else if (opCode <= ORR_RANGE) {
			Operations.orr(binI);
		} else if (opCode <= CBZ_RANGE) {
			Operations.cbz(binI);
		} else if (opCode <= CBNZ_RANGE) {
			Operations.cbnz(binI);
		} else if (opCode <= EOR_RANGE) {
			Operations.eor(binI);
		} else if (opCode <= SUB_RANGE) {
			Operations.sub(binI);
		} else if (opCode <= SUBI_RANGE) {
			Operations.subI(binI);
		} else if (opCode <= EOR_RANGE) {
			Operations.eor(binI);
		} else if (opCode <= LSR_RANGE) {
			Operations.lsr(binI);
		} else if (opCode <= LSL_RANGE) {
			Operations.lsl(binI);
		} else if (opCode <= BRANCHREGISTER_RANGE) {
			Operations.branchRegister(binI);
		} else if (opCode <= SUBS_RANGE) {
			Operations.subs(binI);
		} else if (opCode <= SUBIS_RANGE) {
			Operations.subIs(binI);
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
	
	public void disassembleInstructions() throws IOException{
		List<Integer> instructions = Converter.BinaryToInt(fileName, false);
		for (int curIndex = 0; curIndex < instructions.size(); curIndex++) {
			int binI = instructions.get(curIndex);
			int opCode = binI >> 21;
			determineOp(opCode, binI);
					
			}
		}
	}
