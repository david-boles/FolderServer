package space.davidboles.folderserver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import space.davidboles.lib.ht.tp.FolderHttpHandler;
import space.davidboles.lib.ht.tp.HTTPServerSimpleManager;
import space.davidboles.lib.program.ProgramFs;

public class Start {

	public static void main(String[] args) {
		try {
			HTTPServerSimpleManager server = new HTTPServerSimpleManager(Integer.valueOf(args[0]));
			
			File webFolder = ProgramFs.getProgramFile("web");
			webFolder.mkdirs();
			server.addHandler(new FolderHttpHandler("/", webFolder));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		while(!(scanner).nextLine().equals("stop"));
		scanner.close();
		System.exit(0);
	}

}
