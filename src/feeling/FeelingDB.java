package feeling;

import java.io.IOException;

public interface FeelingDB {
	void add(int feeling) throws IOException; // 게시글 파일에 기분 수치를 추가할 메서드

	double average() throws IOException; // 통계 후 출력하는 메서드
}
