/*
Name and Surname:  Regan Koopmans
Student/staff Number: 15043143
*/

import java.io.*;

public class Main
{
	public static void main(String [] args) throws IOException
	{
		
//		FileInputStream fstream = new FileInputStream("test.txt");
//		DataInputStream in = new DataInputStream(fstream);
//		BufferedReader br = new BufferedReader(new InputStreamReader(in));
//		String strLine;
//		
//		PatriciaTree pt = new PatriciaTree();
//		
//		while ((strLine = br.readLine()) != null)
//		{
//			System.out.println(strLine);
//			//pt.insert(strLine);
//		}
//		
//		in.close();
		
		
		PatriciaTree patriciaTree  = new PatriciaTree();
		patriciaTree.insert("APPLES");
		patriciaTree.insert("TIM");
		patriciaTree.insert("APT");
		//patriciaTree.insert("APT");
		patriciaTree.printTree();
		
	}
} 