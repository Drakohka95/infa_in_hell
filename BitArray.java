public class BitArray {

	private int bitarray[];

	public void generate(int l, int k) { // ���������� ������� �� k �����,
											// ������� � L-��

		for (int i = l; i < (k + l); i++) {
			int j = 1 + (int) (Math.random() * 128); // ������� ������������
														// �������
			int num = shifttobit(j); // "���������" ��� � ��������
			bitarray[i] = num;
		}
	}

	public void insert(int i, int n) { // �������� �� i-�� ����� ����� n
		int j = n; // �������� �� ����������
		int ost = 0;
		while (j > 1 && (ost == 0 || ost == 1)) {
			ost = j % 10;
			j = j / 10;
		}

		if (ost == 0 || ost == 1) { // ���� ����� ��������, �� ��������
			bitarray[i] = n;
		} else {
			System.out.println("Error! Your's number " + n + " is not binary");
		}
	}

	public int takeout(int i) { // ������ i-�� �������� �������
		return bitarray[i];
	}

	public BitArray(int i) { // ��������� ������ ��� ������
		bitarray = new int[i];
	}

	public void print(int i, int k) { // ����� k �������� �� �������, ������� �
										// i-��
		for (int j = i; j < (k + i); j++) {
			System.out.println(bitarray[j]);
		}
	}

	public void printindec(int i, int k) { // ����� k �������� �� �������,
											// ������� � i-��
		int dec;
		for (int j = i; j < (k + i); j++) {
			dec = shifttodec(bitarray[j]);
			System.out.println(dec);
		}
	}

	public int sum(int i, int j) { // ���������� ����� ���� ��������� ������� �
									// �������� i � j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 + s2);
	}

	public int multy(int i, int j) { // ���������� ����� ���� ��������� �������
										// � �������� i � j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 * s2);
	}

	public int div(int i, int j) { // ���������� ����� ���� ��������� ������� �
									// �������� i � j
		int s1 = shifttodec(bitarray[i]);
		int s2 = shifttodec(bitarray[j]);
		return shifttobit(s1 / s2);
	}

	private int shifttobit(int j) { // ������� � �������� �������
		int m = 1; // ��������� ��������
		int res = 0; // ���������
		while (j != 0) {
			res = res + (j % 2) * m;
			m = m * 10;
			j = j / 2;
		}

		if (res < 0)
			return -1; // �������� ��� �� ������� �� �������
		return res;
	}

	private int shifttodec(int j) { // ������� � ���������� �������

		int ost; // ������� �� �������
		int m = 0; // ��������� �������
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
			return -1; // �������� ��� �� ������� �� �������
		return res;
	}

}
