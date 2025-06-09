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
	
	//Assigns the character array of this class to the passed in array
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
	
	//Converts a standard String to a Stringy
	public Stringy(String string)
	{
		this(string.toCharArray());
	}
	
	//Converts a StringBuffer object to a Stringy
	public Stringy(StringBuffer buffer)
	{
		this(buffer.toString());
	}
	
	//Converts a StringBuilder object to a Stringy
	public Stringy(StringBuilder builder)
	{
		this(builder.toString());
	}
	
	/*
	 * Compares two Stringy objects by comparing the individual
	 * characters at each index until they are not equal or
	 * one of the arrays goes out of bounds.
	 * 
	 * If the arrays go out of bounds, the formula is this: 
	 * this.length - other.length
	 * 
	 * Otherwise, the formula is this: this.charAt(index) - other.charAt(index)
	 * 
	 * This method does not ignore case
	 */
	@Override
	public int compareTo(Stringy other) 
	{
		int index = 0;
		//Loop until the characters don't match or index is out of bounds
		while(index < this.length() && index < other.length() && 
	    this.charAt(index) == other.charAt(index))
		{
			index++;
		}
		//Compare based on length if out of bounds
		if(index == this.length() || index == other.length())
		{
			return this.length() - other.length();
		}
		//If lengths are equal, compare based on characters at index
		return this.charAt(index) - other.charAt(index);
	}

	//The length of Stringy is the length of the char array
	@Override
	public int length() 
	{
		return string.length;
	}

	//Simple element grab from the array
	@Override
	public char charAt(int index) 
	{
		if(index < 0 || index > string.length)
		{
			throw new IndexOutOfBoundsException("Index are out of bounds.");
		}
		return string[index];
	}

	//Returns a subsequence object of this Stringy object
	@Override
	public CharSequence subSequence(int start, int end) 
	{
		if(start < 0 || end > string.length)
		{
			throw new IndexOutOfBoundsException("Indices are out of bounds.");
		}
		char[] sub = new char[end - start];
		//Re-assign values
		for(int index = 0; index < sub.length; index++)
		{
			sub[index] = string[index + start];
		}
		//Uses the char array constructor to create a new CharSequence
		return new Stringy(sub);
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
