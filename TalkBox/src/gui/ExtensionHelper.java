package gui;

public class ExtensionHelper {

	public static String getFileExtension(String name) {
		int indexof = name.lastIndexOf(".");
		if(indexof == -1) {
			return null;
		}
		if(indexof == name.length()-1) {
			return null;
		}
		
		return name.substring(indexof, name.length());
	}
}
