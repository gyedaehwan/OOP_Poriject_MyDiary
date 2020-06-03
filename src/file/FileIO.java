// ���� ����� �θ� Ŭ����
// �����ڷ� �����̸��� �޾Ƽ� ������ �ִ��� ������ Ȯ��

package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class FileIO {

	// ������ �����ϰ� �ҷ��� ��ü ����
	File file;

	// �����̸�
	String compare;

	// login ��� �� ���
	// ���ھ��� ������ ȣ�� �� login.txt ������ ��ü�� �ҷ���
	FileIO() {
		file = new File("./login.txt");
	}

	// post ��� �� ���
	// String���ڷ� ������ ������ �ش� �̸��� ������ ��ü�� �ҷ���
	FileIO(String compare) {
		this.compare = compare;
		file = new File("./" + compare + ".txt");
	}

	// �����ڷ� ���� String�� ���� Ȥ�� login.txt �� �ִ��� ������ Ȯ��
	// ������ true , ������ ���� ������ .txt ���� ���� �� false ��ȯ

	protected boolean checkFile() throws IOException {
		// ������ ������ true ����
		if (file.exists()) {
			return true;

		}
		// �������� ������ �������ְ� false����
		else {
			FileOutputStream output = new FileOutputStream("./" + compare + ".txt");
			output.close();
			return false;
		}
	};

}