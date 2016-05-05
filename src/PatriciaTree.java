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
		//System.out.println("Compressing prefix");
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
			System.out.println("Root null case");
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

			while (p.children[(word.charAt(wordIndex))-'A'] != null &&  !p.children[(word.charAt(wordIndex))-'A'].isLeaf && wordIndex < word.length() && p.keys[(word.charAt(wordIndex))-'A'] != nullCharacter)
			{
				System.out.println("iterate");
				p = p.children[convertToIndex(word.charAt(wordIndex))];
				wordIndex++; 
			}
			
			
			if (wordIndex < word.length() && p.keys[word.charAt(wordIndex)-'A'] == nullCharacter)
			{
				System.out.println("Case 1");
				p.children[(int)(word.charAt(wordIndex)-'A')] = new Node(word);
				p.keys[word.charAt(wordIndex)-'A'] = word.charAt(wordIndex);
				
			}
			else if (!p.isLeaf && wordIndex == word.length() -1)
			{
				System.out.println("Case 2");
						
				p.children[word.charAt(wordIndex)-'A'] = new Node(word);
				p.keys[word.charAt(wordIndex)-'A'] = word.charAt(wordIndex);

			}
			else 
			{
				System.out.println("Case 3");
				String currentString = p.children[word.charAt(wordIndex)-'A'].getString();
				//System.out.println(currentString);
				
				while (p.children != null && wordIndex < word.length() && wordIndex <currentString.length() && word.charAt(wordIndex) == currentString.charAt(wordIndex))
				{

					if (p.keys[word.charAt(wordIndex)-'A'] == '@')
					{
						System.out.println("Creating node");
						Node newNode = new Node();
						p.children[word.charAt(wordIndex)-'A'] = newNode;
						p.keys[word.charAt(wordIndex)-'A'] = word.charAt(wordIndex);
						p = newNode;
					}
					else
					{
						System.out.println("Skipping to next");
						if (!p.children[word.charAt(wordIndex)-'A'].isLeaf)
						p = p.children[word.charAt(wordIndex)-'A'];
					}
					wordIndex++;
				}
				
				Node separatingNode = new Node();
				
				separatingNode.children[word.charAt(wordIndex)-'A'] = new Node(word);
				separatingNode.keys[word.charAt(wordIndex)-'A'] = word.charAt(wordIndex);
				separatingNode.isLeaf = false;
				
				if (wordIndex < currentString.length())
				{
					separatingNode.children[currentString.charAt(wordIndex)-'A'] = new Node(currentString);
					separatingNode.keys[currentString.charAt(wordIndex)-'A'] = currentString.charAt(wordIndex);
				}
				else
				{
					//separatingNode.endOfWord = true;
					separatingNode.setString(currentString);
				}
				if (p.children == null)
					p.initializeChildren();
				p.setString(null);
				//p = separatingNode;
				p.children[(word.charAt(wordIndex-1))-'A'] = separatingNode;
				//p.keys[word.charAt(wordIndex-1)-'A'] = word.charAt(wordIndex-1);
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
		
		for (int x= 0; x < 26; x++)
			if (node.children != null && node.children[x] != null)
				printTree(node.children[x]);
	}
}