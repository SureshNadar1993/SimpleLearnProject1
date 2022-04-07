package pack_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperations {

	static String root= "ROOT_DIRECTORY";
	static String seprator="\\";
	File f;
	
	public FileOperations() {
		f=new File(root);
		f.mkdir();
		System.out.println("Root Directory Initialized...");
	}
	
	public void AddFile(String s) throws IOException {
		String path=new String(root+seprator+s);
		//path = path.concat(seprator);
		//path = path.concat(s);
		f=new File(path);
		f.createNewFile();
		System.out.println("File "+s+ " Created Successfully.");
	}	
			
	public void Search_DeleteFile(String inp_file,int param) {
		String path=new String(root+seprator+inp_file);
		String file_name;
		boolean flag = false;
		f=new File(path);
		if(f.exists())
		{
			File f1=new File(root);
			ArrayList<String> filenames= new ArrayList<>();
			String[] listNames = f1.list();
			for (String listName : listNames) 
			{
				filenames.add(listName);
			}

			int i=0;
			while(i < filenames.size())
			{
				file_name=filenames.get(i);
				if(file_name.compareTo(inp_file) == 0)
				{
				  flag = true;
				  break;
				}
				i++;
			}			
			
			if(flag)
			{
				if(param==1)
				{
					f.delete();
					System.out.println("File '"+inp_file+ "' Deleted Successfully.");
				}
				else
				{
					System.out.println("File '"+inp_file+ "' found Successfully in Directory.");
				}
			}
			else
			{
				System.out.println("File '"+inp_file+ "' Not Found Verify File Name.");
			}
		}
		else
		{
			System.out.println("File '"+inp_file+ "' Not Found Verify File Name.");
		}
	}	
	
	public void ListDirectoryAsc()
	{
		f=new File(root);
		ArrayList<String> filenames= new ArrayList<>();
		String[] listNames = f.list();
		for (String listName : listNames) 
		{
			filenames.add(listName);
		}
		if (filenames.isEmpty())
		{
			System.out.println("No Files to Display as the Folder is Empty!!!!");
			return;
		}
		filenames.sort(null);

		System.out.println("Displaying Content of Directory in Ascending Order =====>");
		int i=0;
		while(i < filenames.size())
		{
			System.out.println(filenames.get(i));
			i++;
		}
		return;
	}

	
	
	public void DeleteOnExit()
	{
		f=new File(root);
    	File[] path=f.listFiles();
    	for (File paths : path) {
            paths.delete(); //DELETE FILES
    	}
    	f.delete();//DELETE FOLDER ON EMPTY
    	System.out.println("Deleting the Root Directory and Exiting .......Bye!!!!! ");
		return;
	}	
}
