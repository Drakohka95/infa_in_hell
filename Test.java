public class Test {

	public static void main(String[] args) {

		BitArray a = new BitArray(10); // Ñîçäàííûé ìàññèâ çàïîëíåí íóëÿìè

		// b.insert(1,1);

		a.generate(0, 10);

		a.print(0, 5);

		a.printindec(0, 5);

		int b = a.sum(0, 1);
		System.out.println("Sum eq " + b);

		int c = a.multy(0, 1);
		System.out.println("Multy eq " + c);

		int d = a.div(0, 1);
		System.out.println("Div eq " + d);

		a.insert(2, 102);

		a.insert(1, 10);

		int e = a.takeout(2);
		System.out.println("We take " + e);
		
		System.out.println("Just add this message for test))");

	}

}
