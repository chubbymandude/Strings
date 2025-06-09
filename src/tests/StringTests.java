package tests;

import string.*;

import static org.junit.Assert.*;

import org.junit.Assert.*;
import org.junit.Test;

@SuppressWarnings("unused")
public class StringTests 
{
	//Default constructor should give "" for toString()
	@Test
	public void testDefaultConstructor()
	{
		Stringy defaultConst = new Stringy();
		assertEquals("", defaultConst.toString());
	}
	
	//Byte constructor should be the bytes converted to characters
	@Test
	public void testByteConstructor()
	{
		byte[] bytes = "hello world".getBytes();
		Stringy byteConst = new Stringy(bytes);
		assertEquals("hello world", byteConst.toString());
	}
	
	/*
	 * Character constructor should simply perform 
	 * deep copy of the parameter to the class
	 */
	@Test
	public void testCharConstructor()
	{
		char[] characters = {'h', 'e', 'l', 'l', 'o'};
		Stringy charConst = new Stringy(characters);
		assertEquals("hello", charConst.toString());
	}
	
	//Should convert a String to a Stringy
	@Test
	public void testStringToStringyConstructor()
	{
		String test = "hello world";
		Stringy stringConst = new Stringy(test);
		assertEquals("hello world", stringConst.toString());
	}
	
	/*
	 * Tests methods associated with the CharSequence interface.
	 * 
	 * These are:
	 * --> compareTo
	 * --> length
	 * --> charAt
	 * --> subSequence
	 */
	@Test
	public void testCharSequenceInterface()
	{
		//Test compareTo (also tests length and charAt in implementation)
		Stringy apple = new Stringy("apple");
		Stringy panda = new Stringy("panda");
		Stringy appletown = new Stringy("appletown");
		assertTrue(apple.compareTo(panda) < 0); //Character comparison
		assertTrue(apple.compareTo(apple) == 0); //Equivalent
		assertTrue(apple.compareTo(appletown) < 0); //Length comparison
		
		//Test subsequence
		Stringy pan = (Stringy) panda.subSequence(0, 3);
		assertEquals("pan", pan.toString());
	}
}
