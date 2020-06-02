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
		if (file.exists()) {
			return true;

		} else {
			FileOutputStream output = new FileOutputStream("./" + compare + ".txt");
			// output.close();
			return false;
		}
	};

}
