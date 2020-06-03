// 파일 입출력 부모 클래스
// 생성자로 파일이름을 받아서 파일이 있는지 없는지 확인

package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class FileIO {

	// 파일을 생성하고 불러올 객체 생성
	File file;

	// 파일이름
	String compare;

	// login 기능 시 사용
	// 인자없는 생성자 호출 시 login.txt 파일을 객체로 불러옴
	FileIO() {
		file = new File("./login.txt");
	}

	// post 기능 시 사용
	// String인자로 생성자 생성시 해당 이름의 파일을 객체에 불러옴
	FileIO(String compare) {
		this.compare = compare;
		file = new File("./" + compare + ".txt");
	}

	// 생성자로 받은 String의 파일 혹은 login.txt 가 있는지 없는지 확인
	// 있으면 true , 없으면 현재 폴더에 .txt 파일 생성 후 false 반환

	protected boolean checkFile() throws IOException {
		// 파일이 있으면 true 리턴
		if (file.exists()) {
			return true;

		}
		// 없을때는 파일을 생성해주고 false리턴
		else {
			FileOutputStream output = new FileOutputStream("./" + compare + ".txt");
			output.close();
			return false;
		}
	};

}