/*
Name and Surname:  Regan Koopmans
Student/staff Number: 15043143
*/

import java.io.*;

public class Main
{
	public static void main(String [] args) throws IOException
	{
		
//		FileInputStream fstream = new FileInputStream("wordsEn.txt");
//		DataInputStream in = new DataInputStream(fstream);
//		BufferedReader br = new BufferedReader(new InputStreamReader(in));
//		String strLine;
//		
//		PatriciaTree pt = new PatriciaTree();
//		
//		while ((strLine = br.readLine()) != null)
//		{
//			strLine = strLine.toUpperCase();
////			System.out.println();
////			System.out.println("Inserting " + strLine);
//			pt.insert(strLine);
////			pt.printTree();
////			System.out.println();
//		}
//		
//		pt.printTree();
//		in.close();
		
		
		PatriciaTree patriciaTree  = new PatriciaTree();
		patriciaTree.insert("APPLES");
		patriciaTree.printTree();
		
		System.out.println();
		
		patriciaTree.insert("ABBA");
		patriciaTree.printTree();
		
		System.out.println();
		
		patriciaTree.insert("AY");
		patriciaTree.printTree();
		
		System.out.println();
		
		patriciaTree.insert("ABBAL");
		patriciaTree.printTree();
		
	}
} 