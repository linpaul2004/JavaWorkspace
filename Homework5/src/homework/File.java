package homework;

public class File extends Document {
	private String pathname;

	public String toString() {
		return "Path: " + pathname + "\n" + text;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public String getPathname() {
		return pathname;
	}
}
