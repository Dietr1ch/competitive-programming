import java.util.*;

class Dwarf {
	static HashMap<String, Dwarf> dwarves = new HashMap();
	static void addStatement(String line) {
		String[] words = line.split(" ");
		Dwarf a = getDwarf(words[0]);
		Dwarf b = getDwarf(words[2]);
		if(words[1].equals("<"))
			b.smaller.add(a);
		else
			a.smaller.add(b);
	}

	static Dwarf getDwarf(String name) {
		if(dwarves.containsKey(name))
			return dwarves.get(name);

		Dwarf d = new Dwarf();
		dwarves.put(name, d);
		return d;
	}
	HashSet<Dwarf> smaller = new HashSet();
	boolean exploring, checked;

	static boolean isConsistent() {
		for(Dwarf d : dwarves.values())
			if(!d.consistent())
				return false;
		return true;
	}

	boolean consistent() {
		if(checked)
			return true; // Consistency already checked

		exploring = true;
		for(Dwarf d : smaller)
			if(d.exploring || !d.consistent())
				return false;
		exploring = false;

		checked = true;
		return true;
	}

}

class A {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] aoeu) {
		int statements = s.nextInt(); s.nextLine();
		for(int i=0; i<statements; i++)
			Dwarf.addStatement(s.nextLine());

		if(Dwarf.isConsistent())
			System.out.println("possible");
		else
			System.out.println("impossible");
	}
}
