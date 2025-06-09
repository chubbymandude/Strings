package string;

import java.io.Serializable;
import java.nio.charset.Charset;

/*
 * Following class acts as a mimic of the standard String class 
 * that Java provides (meaning that it is immutable)
 * 
 * It includes all the methods associated with the String
 * (but does not include Java-specific features like being able
 * to use + to concatenate a String or make a variable = to String value)
 */
public final class Stringy implements 
CharSequence, Serializable, Comparable<Stringy>
{
	//This is needed to allow the String to be serialized
	private static final long serialVersionUID = 1L;
	
	//String is represented by an array of characters
	char[] string;
	
	//Following constructor simply creates an empty String
	public Stringy()
	{
		string = new char[0]; 
	}
	
	//Converts a series of bytes to a String
	public Stringy(byte[] bytes)
	{
		string = new char[bytes.length];
		//Loop through the bytes and convert each to a character
		for(int index = 0; index < string.length; index++)
		{
			string[index] = (char) bytes[index];
		}
	}
	
	public Stringy(char[] string)
	{
		this.string = new char[string.length];
		/*
		 * Assign each value in the character array
		 * to the corresponding value in the parameter array
		 */
		for(int index = 0; index < string.length; index++)
		{
			this.string[index] = string[index];
		}
	}
	
	@Override
	public int compareTo(Stringy o) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int length() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char charAt(int index) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Uses the String to make a toString of my String class. Because yes.
	 */
	public String toString()
	{
		String display = "";
		//Loop through the character array, add all elements to the display 
		for(int index = 0; index < string.length; index++)
		{
			display += string[index];
		}
		return display;
	}

}
