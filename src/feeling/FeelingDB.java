package feeling;

import java.io.IOException;

public interface FeelingDB {
	void add(int feeling) throws IOException; // �Խñ� ���Ͽ� ��� ��ġ�� �߰��� �޼���

	double average() throws IOException; // ��� �� ����ϴ� �޼���
}
