package disassembler;
import java.util.ArrayList;
import java.util.List;

public class Operations {
	
	private List<String> conditions;
	
	private static List<String> bFormat(int parameters) {
		return null;
	}
	
	private static List<String> cbFormat(int parameters) {
		return null;
	}
	
	private static List<String> rFormat(int binI) {
		List<String> params = new ArrayList<>();

		params.add(((Integer)((binI << 11) >> 27)).toString());
		params.add(((Integer)((binI << 15) >> 26)).toString());
		params.add(((Integer)((binI << 21) >> 26)).toString());
		params.add(((Integer)((binI << 26) >> 26)).toString());

		return params;
	}
	
	private static List<String> iFormat(int parameters) {
		return null;
	}
	
	
	public static String branch(int binI) {
		String opName = "B"; 
		return null;
	}

	public static String branchCond(int binI) {
		return null;
	}

	public static String orrI(int binI) {
		String opName = "ORRI"; 
		return null;
	}

	public static String eorI(int binI) {
		String opName = "EORI"; 
		return null;
	}

	public static String and(int binI) {
		String opName = "AND"; 
		List<String> params = rFormat(binI);
		return String.format("%s X%s, X%s, X%s", opName, params.get(3), params.get(2), params.get(0));
	}

	public static String add(int binI) {
		String opName = "ADD"; 
		List<String> params = rFormat(binI);
		return String.format("%s X%s, X%s, X%s", opName, params.get(3), params.get(2), params.get(0));
	}

	public static String addI(int binI) {
		String opName = "ADDI"; 
		return null;
	}

	public static String andI(int binI) {
		String opName = "ANDI"; 
		return null;
	}

	public static String branchLink(int binI) {
		String opName = "BL"; 
		return null;
	}

	public static String mul(int binI) {
		String opName = "MUL"; 
		return null;
	}

	public static String orr(int binI) {
		String opName = "ORR"; 
		return null;
	}

	public static String cbz(int binI) {
		String opName = "CBZ"; 
		return null;
	}

	public static String cbnz(int binI) {
		String opName = "CBNZ"; 
		return null;
	}

	public static String eor(int binI) {
		String opName = "EOR"; 
		return null;
	}

	public static String sub(int binI) {
		String opName = "SUB"; 
		return null;
	}

	public static String subI(int binI) {
		String opName = "SUBI"; 
		return null;
	}

	public static String lsr(int binI) {
		String opName = "LSR"; 
		return null;
	}

	public static String lsl(int binI) {
		String opName = "LSL"; 
		return null;
	}

	public static String branchRegister(int binI) {
		String opName = "BR"; 
		return null;
	}

	public static String subs(int binI) {
		String opName = "SUBS"; 
		return null;
	}

	public static String subIs(int binI) {
		String opName = "SUBIS"; 
		return null;
	}

	public static String prnl(int binI) {
		String opName = "PRNL"; 
		return null;
	}

	public static String prnt(int binI) {
		String opName = "PRNT"; 
		return null;
	}

	public static String dump(int binI) {
		String opName = "DUMP"; 
		return null;
	}

	public static String halt(int binI) {
		String opName = "HALT"; 
		return null;
	}
	
}
