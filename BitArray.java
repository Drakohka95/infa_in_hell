public class BitArray {

	private int bitarray[];
	//just add comment for test)

	public void generate(int l, int k) { // Çàïîëíåíèå ìàññèâà íà k ÿ÷ååê,
											// íà÷èíàÿ ñ L-ãî

		for (int i = l; i < (k + l); i++) {
			int j = 1 + (int) (Math.random() * 128); // ãåíåðèì ïðîèçâîëüíîå
														// ÷èñåëêî
			int num = shifttobit(j); // "ïåðåâîäèì" åãî â äâîè÷íîå
			bitarray[i] = num;
		}
	}

	public void insert(int i, int n) { // Çàïèñàòü íà i-îå ìåñòî ÷èñëî n
		int j = n; // Ïðîâåðêà íà áèíàðíîñòü
		int ost = 0;
		while (j > 1 && (ost == 0 || ost == 1)) {
			ost = j % 10;
			j = j / 10;
		}

		if (ost == 0 || ost == 1) { // Åñëè ÷èñëî áèíàðíîå, òî çàïèñàòü
			bitarray[i] = n;
		} else {
			System.out.println("Error! Your's number " + n + " is not binary");
		}
	}

	public int takeout(int i) { // Âûäàòü i-îå çíà÷åíèå ìàññèâà
		return bitarray[i];
	}

	public BitArray(int i) { // Âûäåëåíèå ïàìÿòè ïîä ìàññèâ
		bitarray = new int[i];
	}

	public void print(int i, int k) { // Âûâîä k çíà÷åíèé èç ìàññèâà, íà÷èíàÿ ñ
										// i-ãî
		for (int j = i; j < (k + i); j++) {
			System.out.println(bitarray[j]);
		}
	}

	public void printindec(int i, int k) { // Âûâîä k çíà÷åíèé èç ìàññèâà,
											// íà÷èíàÿ ñ i-ãî
		int dec;
		for (int j = i; j < (k + i); j++) {
			dec = shifttodec(bitarray[j]);
			System.out.println(dec);
		}
	}

	public int sum(int i, int j) { // Âîçâðàùàåò ñóììó äâóõ ýëåìåíòîâ ìàññèâà ñ
									// íîìåðàìè i è j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 + s2);
	}

	public int multy(int i, int j) { // Âîçâðàùàåò ñóììó äâóõ ýëåìåíòîâ ìàññèâà
										// ñ íîìåðàìè i è j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 * s2);
	}

	public int div(int i, int j) { // Âîçâðàùàåò ñóììó äâóõ ýëåìåíòîâ ìàññèâà ñ
									// íîìåðàìè i è j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 / s2);
	}

	private int shifttobit(int j) { // Ïåðåâîä â äâîè÷íóþ ñèñòåìó
		int m = 1; // Ìíîæèòåëü äåñÿòêîâ
		int res = 0; // Ðåçóëüòàò
		while (j != 0) {
			res = res + (j % 2) * m;
			m = m * 10;
			j = j / 2;
		}

		if (res < 0)
			return -1; // Ïðîâåðêà ÷òî íå âûõîäèò çà ïðåäåëû
		return res;
	}

	private int shifttodec(int j) { // Ïåðåâîä â äåñÿòè÷íóþ ñèñòåìó

		int ost; // Îñòàòîê îò äåëåíèÿ
		int m = 0; // Ìíîæèòåëü ñòåïåíè
		int res = 0;
		int st;
		while (j != 0) {
			ost = j % (10);
			st = (int) Math.pow(2, m);
			res = res + ost * st;
			m++;
			j = j / 10;
		}

		if (res < 0)
			return -1; // Ïðîâåðêà ÷òî íå âûõîäèò çà ïðåäåëû
		return res;
	}

}
