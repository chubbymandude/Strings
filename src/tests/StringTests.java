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
}
