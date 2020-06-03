package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class FileIO {
	File file;
	String compare;

	FileIO() {
		file = new File("./login.txt");
	}

	FileIO(String compare) {
		this.compare = compare;
		file = new File("./" + compare + ".txt");
	}

	protected boolean checkFile() throws IOException {
		// 파일이 있으면 true 리턴
		if (file.exists()) {
			return true;

		}
		// 없을때는 파일을 생성해주고 false리턴
		else {
			FileOutputStream output = new FileOutputStream("./" + compare + ".txt");
			// output.close();
			return false;
		}
	};

}
