public class BitArray {

	private int bitarray[];

	public void generate(int l, int k) { // Заполнение массива на k ячеек,
											// начиная с L-го

		for (int i = l; i < (k + l); i++) {
			int j = 1 + (int) (Math.random() * 128); // генерим произвольное
														// чиселко
			int num = shifttobit(j); // "переводим" его в двоичное
			bitarray[i] = num;
		}
	}

	public void insert(int i, int n) { // Записать на i-ое место число n
		int j = n; // Проверка на бинарность
		int ost = 0;
		while (j > 1 && (ost == 0 || ost == 1)) {
			ost = j % 10;
			j = j / 10;
		}

		if (ost == 0 || ost == 1) { // Если число бинарное, то записать
			bitarray[i] = n;
		} else {
			System.out.println("Error! Your's number " + n + " is not binary");
		}
	}

	public int takeout(int i) { // Выдать i-ое значение массива
		return bitarray[i];
	}

	public BitArray(int i) { // Выделение памяти под массив
		bitarray = new int[i];
	}

	public void print(int i, int k) { // Вывод k значений из массива, начиная с
										// i-го
		for (int j = i; j < (k + i); j++) {
			System.out.println(bitarray[j]);
		}
	}

	public void printindec(int i, int k) { // Вывод k значений из массива,
											// начиная с i-го
		int dec;
		for (int j = i; j < (k + i); j++) {
			dec = shifttodec(bitarray[j]);
			System.out.println(dec);
		}
	}

	public int sum(int i, int j) { // Возвращает сумму двух элементов массива с
									// номерами i и j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 + s2);
	}

	public int multy(int i, int j) { // Возвращает сумму двух элементов массива
										// с номерами i и j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 * s2);
	}

	public int div(int i, int j) { // Возвращает сумму двух элементов массива с
									// номерами i и j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 / s2);
	}

	private int shifttobit(int j) { // Перевод в двоичную систему
		int m = 1; // Множитель десятков
		int res = 0; // Результат
		while (j != 0) {
			res = res + (j % 2) * m;
			m = m * 10;
			j = j / 2;
		}

		if (res < 0)
			return -1; // Проверка что не выходит за пределы
		return res;
	}

	private int shifttodec(int j) { // Перевод в десятичную систему

		int ost; // Остаток от деления
		int m = 0; // Множитель степени
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
			return -1; // Проверка что не выходит за пределы
		return res;
	}

}
