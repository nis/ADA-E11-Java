import java.io.File;

public class FindFileOfType {
	public int number_of_files_found = 0;
	public String filetype;
	
	public static void main (String[] args) {
		System.out.println("Search started!");
		
		FindFileOfType my_class = new FindFileOfType();
		my_class.FindFileOfType();
	}
	
	public void FindFileOfType() {
		search_for_files("mp3");
	}
	
	public void search_for_files(String e) {
		filetype = e.toLowerCase();
		System.out.print("Searching for: \"");
		System.out.print(filetype);
		System.out.println("\".");
		
		File start_point = new File("/Users/tamen/Desktop/mp3test/");
		search_dir(start_point);
		System.out.print("Found ");
		System.out.print(number_of_files_found);
		System.out.print(" files of type \"");
		System.out.print(filetype);
		System.out.println("\".");
	}
	
	public void search_dir(File p) {
		File[] files = p.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				String n = files[i].getName();
				n = n.toLowerCase();
				if (n.endsWith(filetype)) {
					//System.out.println(n);
					number_of_files_found++;
				}
			} else if (files[i].isDirectory()) {
				String path = files[i].getAbsolutePath();
				System.out.println(path);
			}
		}
	}
}