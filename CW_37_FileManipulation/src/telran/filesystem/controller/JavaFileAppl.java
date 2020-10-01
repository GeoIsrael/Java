package telran.filesystem.controller;

import java.io.File;

public class JavaFileAppl {

	private static String string;

	public static void main(String[] args) {
		System.out.println(File.separator);
		System.out.println("File.separator = " + File.separator);
        System.out.println("File.separatorChar = " + File.separatorChar);
        System.out.println("File.pathSeparator = " + File.pathSeparator);
        System.out.println("File.pathSeparatorChar = " + File.pathSeparatorChar);
        System.out.println("---------------");
		
		String path = File.separator + "home" + File.separator
				+ "g" + File.separator + "jpg" + File.separator ;  //+ "20200528_162423.jpg"
		File file = new File(path);
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.getName());
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
		}
		String newPath = path + File.separator + "my";
		File newDir = new File(newPath);
		System.out.println(newDir.exists());
		newDir.mkdir();
		System.out.println(newDir.exists());
		newDir.delete();
		System.out.println(newDir.exists());
	}

}
