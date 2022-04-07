package pack_project;

import java.io.IOException;
import java.util.Scanner;

public class MenuDisplay extends FileOperations {

	public MenuDisplay() {
		System.out.println("Initializing Application .........");
		System.out.println("=================================================");
		System.out.println("!!!!WELCOME TO LOCKEDME (Beta Version)!!!!");
		System.out.println("Author :- Suresh Nadar");
		System.out.println("=================================================");
	}

	public static void main(String[] args) {
		MenuDisplay m = new MenuDisplay();
		m.MainMenu();
	}
	
	public void MainMenu()
	{
		int x=0;
		boolean flag=true;
		Scanner s =new Scanner(System.in);
		do
		{
			System.out.println("========================MAIN MENU==========================");			
			System.out.println("Enter 1 to display the Content of Root Directory");
			System.out.println("Enter 2 to goto file Operation Menu");
			System.out.println("Enter 3 to close the Application");
			System.out.println("===========================================================");
			System.out.print("Enter your Option :");	
			try
			{
				x = Integer.parseInt(s.next());
			}
			catch(Exception e)
			{
				x=4;
			}
			switch (x)
			{
			case 1:
				this.ListDirectoryAsc();
				break;
			case 2:
				this.SubMenu();
				break;
			case 3:
				this.DeleteOnExit();
				flag = false;
				break;
			default :	
				System.out.println("Invalid option Enter a valid Option");
				break;	
			}
		}while (flag);
		s.close();
		return;
	}

	public void SubMenu()
	{
		int y=0;
		boolean flag=true;
		String inp;
		int param=0;
		@SuppressWarnings("resource")
		Scanner s =new Scanner(System.in);
		do
		{
			System.out.println("========================SUB MENU==========================");			
			System.out.println("ENTER 1 TO ADD A FILE TO DIRECTORY");
			System.out.println("ENTER 2 TO DELETE A FILE FROM DIRECTORY");
			System.out.println("ENTER 3 TO SEARCH A FILE FROM DIRECTORY");
			System.out.println("ENTER 4 TO RETURN TO THE MAIN MENU");
			System.out.println("===========================================================");
			System.out.print("ENTER YOUR OPTION :");
			try
			{
				y = Integer.parseInt(s.next());
			}
			catch(Exception e)
			{
				y=5;
			}
			switch (y)
			{
			case 1:
				System.out.print("Enter the Name of file to be Created : ");
				inp=s.next();
				try {
					this.AddFile(inp);
				} catch (IOException e) {
					System.out.println("File Cannot be Created please try a valid filename!!!");
				}
				break;
			case 2:
				System.out.print("Enter the Name of file to be Deleted : ");
				inp =s.next();
				param = 1;
				this.Search_DeleteFile(inp,param);
				break;
			case 3:
				System.out.print("Enter the Name of file to be Searched : ");
				inp =s.next();
				param = 0;
				this.Search_DeleteFile(inp,param);
				break;			
			case 4:
				flag = false;
				break;
			default :	
				System.out.println("Invalid option Enter a valid Option");
				break;	
			}
		}while (flag);
		return;
	}
}
