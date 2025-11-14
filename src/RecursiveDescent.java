import java.util.ArrayList;

public class RecursiveDescent {
	
	static ArrayList<String> tokens;;

	public static void main(String[ ] args) {
		ArrayList<String> t = new ArrayList<String>();
		t.add("int");
		t.add("+");
		t.add("int");
		System.out.println("Parsing " + t);
		boolean result = parse(t);
		if (result)
			System.out.println("Success!");
		else
			System.out.println("ERROR: Could not parse.");
	}

	static boolean parse(ArrayList<String> t) {
		tokens = t;
		return parse_P();
	}

	static boolean parse_P() {
		System.out.println("1. P->E");
		return parse_E();
	}

	static boolean parse_E() {
		System.out.println("2. E->TE'");
		return parse_T() && parse_E_prime();
	}

	static boolean parse_E_prime() {
		String t = scan_token();
		if (t == null) {
			System.out.println("4. E'->epsilon");
			return true;
		}
		
		if(t.equals("+"))
			return parse_T()&& parse_E_prime();
		else {
			putback_token(t);
		return false;
		}
	}

	static boolean parse_T() {
		String t = scan_token();
		if (t == null) {
			System.out.println("parse error: no more tokens");
			return false;
		}
		else if(t.equals("int")) {
			System.out.println("5. T->int");
			return true;
		}else {
			return false;
		}
	}
	
	static String scan_token() {
		if (!tokens.isEmpty())
			return tokens.remove(0);
		else
			return null;
	}
	
	static void putback_token(String t) {
		tokens.add(0, t);
	}

}
