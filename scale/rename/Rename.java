package scale.rename;

import java.io.File;

public class Rename {

	String dir;
	String pre;
	String sub;
	String[] oldPath = new String[100];
	String newPath;
		
//	public Rename(RenameWindow window) {
//		getDir(window);
//		getOldPath();
//		changeName();
//	}
	
	public void getDir(RenameWindow window) {

		int len = 0;
		
		if (window.dir != null) {
			len = window.dir.length();
			if (window.dir.charAt(len-1) != '/') {
				this.dir = window.dir + "/";
			}
		}

		this.pre = window.pre;
		this.sub = window.sub;
//		System.out.println(dir);
//		System.out.println(pre);
//		System.out.println(sub);
	}
	public void getOldPath() {
		if (this.dir != null) {
			File file = new File(this.dir);
			oldPath = file.list();			
		}
		for (int i = 0; i < oldPath.length; i++)
			System.out.println(oldPath[i]);
	}
	public void changeName(RenameWindow window) {
		getDir(window);
		getOldPath();
		if (this.oldPath != null) {
			int i = 0;
			int len = this.oldPath.length;
			for (i = 0; i < len; ++i) {
				if (oldPath[i] != null) {
					File oldFile = new File(this.dir+oldPath[i]);
					if (!oldFile.isDirectory()) {
						newPath = this.dir + this.pre + i + this.sub;
						File newFile = new File(newPath);
						oldFile.renameTo(newFile);	
					}
				
				}

			}
		}
	}
}
