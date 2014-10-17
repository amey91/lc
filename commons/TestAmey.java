package leetcode.commons;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAmey {

	@Test
	public void testCheckPalindrome1() {
		assertEquals(Amey.checkPalindrome("abccba"), true);
	}

	@Test
	public void testCheckPalindrome2() {
		assertEquals(Amey.checkPalindrome("abbb"), false);
	}
	
	@Test
	public void testCheckPalindrome3() {
		assertEquals(Amey.checkPalindrome("abcdcba"), true);
	}
	
	@Test
	public void testCheckPalindrome4() {
		assertEquals(Amey.checkPalindrome("aaaaaaa"), true);
		
	}
	
	@Test
	public void testCheckPalindrome5() {
		assertEquals(Amey.checkPalindrome("aaaaaaaa"), true);
	}
	
	@Test
	public void testCheckPalindrome6() {
		assertEquals(Amey.checkPalindrome(""), false);
	}
	
	@Test
	public void testCheckPalindrome7() {
		assertEquals(Amey.checkPalindrome("aaaabbbaaaa"), true);
	}
	
	@Test
	public void testCheckPalindrome(){
		assertFalse(Amey.checkPalindrome("abcabc"));
	}
	
}
