import java.io.File;

public class FindFileOfType {
	public int number_of_files_found = 0;
	public String filetype;
	
	public static void main (String[] args) {
		FindFileOfType my_class = new FindFileOfType();
		my_class.search_for_files("mp3");
	}
	
	public void search_for_files(String e) {
		filetype = e.toLowerCase();
		System.out.println("Searching for: \"" + filetype + "\".");
		
		long time = System.currentTimeMillis();
		search_dir(new File("/Users/tamen/Desktop/mp3test"));
		time = System.currentTimeMillis() - time;
		System.out.println("Found " + number_of_files_found + " files of type \"" + filetype + "\".");
		System.out.println("The search took " + time/1000 + "s.");
	}
	
	public void search_dir(File p) {
		File[] files = p.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().toLowerCase().endsWith(filetype)) {
				number_of_files_found++;
			} else if (files[i].isDirectory() && !files[i].getName().startsWith(".")) { // Directory
				search_dir(new File(files[i].getAbsolutePath()));
			}
		}
	}
}