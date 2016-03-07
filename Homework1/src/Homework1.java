
public class Homework1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String attribute;
		StringBuffer tag = new StringBuffer(args[0].substring(args[0].indexOf("<tag>") + 5, args[0].indexOf("</tag>")));
		if (args[0].indexOf("<" + tag + " ") > 0) {
			if (args[0].indexOf("</" + tag + ">") > 0) {
				attribute = args[0].substring(args[0].indexOf("<" + tag + " ") + tag.length() + 2,
						args[0].indexOf(">", args[0].indexOf("<" + tag + " ")));
				System.out.println(attribute);
			} else {
				attribute = args[0].substring(args[0].indexOf("<" + tag + " ") + tag.length() + 2,
						args[0].indexOf("/>", args[0].indexOf("<" + tag + " ")));
				System.out.println(attribute);
			}
		}
	}

}
