import java.io.File;

public class MP3Player {
	
	public static void main (String[] args) {
		MP3Player c = new MP3Player();
		c.start_up();
	}
	
	private void start_up() {
		long time = System.currentTimeMillis();
		QuadraticProbingHashTable mp3table = new QuadraticProbingHashTable();
		search_dir(new File("/Users/tamen"), mp3table);
		time = System.currentTimeMillis() - time;
		System.out.println("Execution took " + time/1000 + " seconds.");
		System.out.println("Table holds " + mp3table.get_current_size() + " paths.");
	}
	
	private void search_dir(File p, QuadraticProbingHashTable h) {
		File[] files = p.listFiles();
		int result = 0;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().toLowerCase().endsWith("mp3")) {
				h.insert(files[i].getAbsolutePath());
				//result++;
			} else if (	files[i].isDirectory() && 
						!files[i].isHidden() && 
						files[i].getName().toLowerCase().indexOf(".") == -1) {
				search_dir(new File(files[i].getAbsolutePath()), h);
			}
		}
	}
}