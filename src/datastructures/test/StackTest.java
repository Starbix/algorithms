package datastructures.test;
import static org.junit.Assert.*;

import org.junit.rules.Timeout;

import datastructures.Stack;

import org.junit.Rule;
import org.junit.Test;

public class StackTest {

	@Rule
	public Timeout globalTimeout= Timeout.seconds(5);

	@Test
	public void custom() {
		Stack<String> ll = new Stack<String>();
		ll.push("3");
		ll.push("1");

		assertEquals("1", ll.pop());
		assertEquals("3", ll.pop());

	}

	@Test
	public void testAddLastEasy() {
		Stack<String> ll = new Stack<String>();
		ll.push("asdf");
		ll.push("11");
		assertEquals("11", ll.pop());
		assertEquals(1, ll.getSize());

		ll.push("42");
		assertEquals("42", ll.pop());
		assertEquals("asdf", ll.pop());
		assertEquals(0, ll.getSize());

		ll.push("57");
		assertEquals("57", ll.pop());
		assertEquals(null, ll.pop());
		assertEquals(0, ll.getSize());
	}

}
