import java.io.File;

public class FindFileOfType {
	
	public static void main (String[] args) {
		FindFileOfType my_class = new FindFileOfType();
		my_class.search_for_files("mp3");
	}
	
	private void search_for_files(String e) {
		System.out.println("Searching for: \"" + e + "\".");
		long time = System.currentTimeMillis();
		int number_of_files_found = search_dir(new File("/Users/nis"), e.toLowerCase());
		time = System.currentTimeMillis() - time;
		System.out.println("Found " + number_of_files_found + " files of type \"" + e + "\".");
		System.out.println("The search took " + time/1000 + "s.");
	}
	
	private int search_dir(File p, String filetype) {
		File[] files = p.listFiles();
		int result = 0;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().toLowerCase().endsWith(filetype)) {
				result++;
			} else if (	files[i].isDirectory() && 
						!files[i].isHidden() && 
						files[i].getName().toLowerCase().indexOf(".") == -1) {
				result += search_dir(new File(files[i].getAbsolutePath()), filetype);
			}
		}
		return result;
	}
}