import java.io.File;

public class FindFileOfType {
	public int number_of_files_found = 0;
	public String filetype;
	File start_point;
	long time;
	
	public static void main (String[] args) {
		
		FindFileOfType my_class = new FindFileOfType();
		my_class.search_for_files("mp3");
	}
	
	public void search_for_files(String e) {
		filetype = e.toLowerCase();
		System.out.println("Searching for: \"" + filetype + "\".");
		
		//start_point = new File("/Users/tamen/Desktop/mp3test");
		start_point = new File("/Users/tamen");
		time = System.currentTimeMillis();
		search_dir(start_point);
		time = System.currentTimeMillis() - time;
		System.out.println("Found " + number_of_files_found + " files of type \"" + filetype + "\".");
		System.out.println("The search took " + time/1000 + "s.");
	}
	
	public void search_dir(File p) {
		File[] files = p.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				if (files[i].getName().toLowerCase().endsWith(filetype)) {
					number_of_files_found++;
				}
			} else if (files[i].isDirectory()) {
				if (!files[i].getName().startsWith(".")) {
					search_dir(new File(files[i].getAbsolutePath()));
				}
			}
		}
	}
}