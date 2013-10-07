package scale.rename;

public class ScaleRename {

	public ScaleRename() {
		Rename rename = new Rename();
		RenameWindow window = new RenameWindow(rename);
	}
	public static void main(String[] argc) {
		new ScaleRename();
	}
}
