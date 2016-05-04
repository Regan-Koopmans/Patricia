import javax.swing.JComboBox.KeySelectionManager;

/*
Name and Surname:  Regan Koopmans
Student/staff Number: 15043143
*/

/*You must implement a fully functional Patricia tree.*/
public class PatriciaTree
{
	/*You will have to design and implement your own node classes.
	You may add any additional fields or methods but you are not
	allowed to remove or change anything you were given apart from
	implementing the methods.*/
	
	Node root = null;
	private char nullCharacter = Node.nullCharacter;
	
	public PatriciaTree()
	{
		/*You may add any initialization which your
		require for your trie here.  Your default constructor
		will be used to create your tree for marking*/
		
		
	}
	
	public void collapsePrefix()
	{
		System.out.println("Compressing prefix");
	}
	
	public int convertToIndex(char input)
	{
		return input-'A';
	}
	
	public boolean insert(String word)
	{
		/*Insert the word passed as a parameter into the tree.
		No duplicates are allowed.  If the insert fails for 
		whatever reason, you should return false. You must return 
		true to indicate a successful insert.*/
		
		word  = word.toUpperCase(); 
		
		if (root == null)
		{
			root = new Node();
			root.children[word.charAt(0)-'A'] = new Node(word);
			root.keys[word.charAt(0)-'A'] = word.charAt(0);
			return true;
		}
		else 
		{
			//Search node to insert into
			Node p = root;
			int wordIndex = 0;
			while (!p.pointsToString(word.charAt(wordIndex)) && wordIndex < word.length() && p.keys[(word.charAt(wordIndex))-'A'] != nullCharacter)
			{
				p = p.children[convertToIndex(word.charAt(wordIndex))];
				System.out.println("String : " + p.getString());
				wordIndex++; 
			}
			
			if (p.keys != null && wordIndex < word.length() && p.keyAt(word.charAt(wordIndex)) == nullCharacter)
			{
//				p.addWordLiteral(wordIndex,word);

				p.children[(int)(word.charAt(wordIndex)-'A')] = new Node(word);
				p.keys[word.charAt(wordIndex)-'A'] = word.charAt(wordIndex);
			}
			else if (p.keys != null && wordIndex == word.length() -1)
			{
				p.endOfWord = true;
			}
			else 
			{
				String currentString = p.children[word.charAt(wordIndex)-'A'].getString();
				System.out.println(currentString);
				
				
				
				while (word.charAt(wordIndex) == currentString.charAt(wordIndex))
				{
					System.out.println(word.charAt(wordIndex));
					wordIndex++;
				}
			}
		}
		collapsePrefix();
		return false;
	}
	
	public String search(String word)
	{
		/*Search for the word passed as a parameter.
		If the tree is empty, return an exclamation mark.
		See the specification for more details.*/
		String searchString = "";
		
		if (root == null)
		{
			searchString = "!";
		}
		else
		{
			
		}
		
		return searchString;
	}
	
	public String remove(String word)
	{
		/*Deletes the word passed as a parameter from the tree.
		If the tree was empty, then return an exclamation mark.*/
		
		
		return "";
	}
	
	public void printTree()
	{
		printTree(root);
	}
	
	public void printTree(Node node)
	{
		System.out.println(node);
	}
}