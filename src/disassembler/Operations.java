package disassembler;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Operations {
	
	private static ArrayList<String> conditions = new ArrayList<String>();
	
	
	private List<String> bFormat(int parameters, Hashtable<Interger, String> labels) {
		List<String> params = new ArrayList<String>();
		int BRaddress = (parameters << 6) >> 6;
		
		
		
	}
	
	private List<String> cbFormat(int parameters) {
		
	}
	
	private List<String> rFormat(int parameters) {
		
	}
	
	private static List<String> iFormat(int parameters) {
		
	}
	
	public static String branch(int binI) {
		
	}
	
	public static String branchCond(int binI) {
		if (conditions == null) {
			conditions.add("EQ");
			conditions.add("NE");
			conditions.add("HS");
			conditions.add("LO");
			conditions.add("MI");
			conditions.add("PL");
			conditions.add("VS");
			conditions.add("VC");
			conditions.add("HI");
			conditions.add("LS");
			conditions.add("GE");
			conditions.add("LT");
			conditions.add("GT");
			conditions.add("LE");
		}
		
		int condition = (binI << 28) >> 28;
		String opName = "B" + condition;
		
		
	}

	public static String orrI(int binI) {
		String opName = "ORRI"; 
		
	}

	public static String eorI(int binI) {
		String opName = "EORI"; 
		
	}

	public static String and(int binI) {
		String opName = "AND"; 
		
	}

	public static String add(int binI) {
		String opName = "ADD"; 
		
	}

	public static String addI(int binI) {
		String opName = "ADDI"; 
		
	}

	public static String andI(int binI) {
		String opName = "ANDI"; 
		
	}

	public static String branchLink(int binI) {
		String opName = "BL"; 
		
	}

	public static String mul(int binI) {
		String opName = "MUL"; 
		
	}

	public static String orr(int binI) {
		String opName = "ORR"; 
		
	}

	public static String cbz(int binI) {
		String opName = "CBZ"; 
		
	}

	public static String cbnz(int binI) {
		String opName = "CBNZ"; 
		
	}

	public static String eor(int binI) {
		String opName = "EOR"; 
		
	}

	public static String sub(int binI) {
		String opName = "SUB"; 
		
	}

	public static String subI(int binI) {
		String opName = "SUBI"; 
		
	}

	public static String lsr(int binI) {
		String opName = "LSR"; 
		
	}

	public static String lsl(int binI) {
		String opName = "LSL"; 
		
	}

	public static String branchRegister(int binI) {
		String opName = "BR"; 
		
	}

	public static String subs(int binI) {
		String opName = "SUBS"; 
		
	}

	public static String subIs(int binI) {
		String opName = "SUBIS"; 
		
	}

	public static String prnl(int binI) {
		String opName = "PRNL"; 
		
	}

	public static String prnt(int binI) {
		String opName = "PRNT"; 
		
	}

	public static String dump(int binI) {
		String opName = "DUMP"; 
		
	}

	public static String halt(int binI) {
		String opName = "HALT"; 
		
	}
	
}
