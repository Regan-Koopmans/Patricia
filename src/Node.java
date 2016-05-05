

public class Node 
{
	public static char nullCharacter = '@';
	public Node [] children;
	protected char [] keys;
	protected int [] prefixLengths;
	public boolean isLeaf = false;
	boolean endOfWord = false;
	
	private String nodeString = null;
	
	
	public Node()
	{
		nodeString = null;
		children = new Node[26];
		keys = new char[26];
		
		for (int x = 0; x < 26; x++)
		{
			keys[x] = nullCharacter;
			children[x] = null;
		}
	}
	
	public Node(String nodeString)
	{
		keys = new char[26];
		for (int x = 0; x < 26; x++)
			keys[x] = '@';
		this.nodeString = nodeString.toUpperCase();
		isLeaf = true;
	}
	
	public int countKeys()
	{
		int count = 0;
		if (keys != null)
		{
			for (int x = 0;  x < 26; x++)
			if (keys[x] != nullCharacter)
				count++;
		}
		return count;
	}
	
	public char keyAt(char inputChar)
	{
		return keys[inputChar-'A'];
	}
	
	//Generate String Representation
	
	public String toString()
	{
		
		String stringRepresentation = "";
		if (endOfWord)
		{
			stringRepresentation += "[#]";
		}
		
		for (int x = 0; x < 26; x++)
		{
//			if (keys[x] != nullCharacter)
//			{
				stringRepresentation = stringRepresentation + ("[" +  keys[x] + "]");
//			}
		}
		
		if (nodeString != null)
		{
			stringRepresentation = "This is string : " + nodeString;
		}
		return stringRepresentation;
	}
	
	//Test if a node is a leaf
	
	
	public void initializeChildren()
	{
		isLeaf = false;
		children = new Node[26];
	}
	
	public String getString()
	{
		return nodeString;
	}
	
	public void setString(String nodeString)
	{
		this.nodeString = nodeString;
	}
	
	public boolean pointsToString(char input)
	{
		if (children == null ||  children[(input-'A')] == null)
		{
			return false;
		}
		else 
		{
			return children[input-'A'].isLeaf;
		}
	}
	
	public boolean isString()
	{
		return (nodeString != null);
	}
}
