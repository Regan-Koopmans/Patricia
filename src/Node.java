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
		this.nodeString = nodeString.toUpperCase();
	}
	
	public char keyAt(char inputChar)
	{
		return keys[inputChar-'A'];
	}
	
	//Generate String Representation
	
	public String toString()
	{
		if (keys == null)
		{
			return "This is string : " + nodeString;
		}
		
		String stringRepresentation = "";
		if (endOfWord)
		{
			stringRepresentation+="[#]";
		}
		
		for (int x = 0; x < 26; x++)
		{
			if (keys[x] != nullCharacter)
				stringRepresentation += "[" + keys[x] + "]";
		}
		return stringRepresentation;
	}
	
	//Test if a node is a leaf
	
	public String getString()
	{
		return nodeString;
	}
	
	public boolean pointsToString(char input)
	{
		if (children == null ||  children[(input-'A')] == null)
		{
			return false;
		}
		else 
		{
			return children[(int)input-(int)'A'].isString();
		}
	}
	
	public boolean isString()
	{
		return (nodeString != null);
	}
}
