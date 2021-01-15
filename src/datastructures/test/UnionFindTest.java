package datastructures.test;
import static org.junit.Assert.*;

import org.junit.rules.Timeout;

import datastructures.UnionFind;

import org.junit.Rule;
import org.junit.Test;

public class UnionFindTest {

	@Rule
	public Timeout globalTimeout= Timeout.seconds(5);

	@Test
	public void customFast() {
		UnionFind u = new UnionFind(10);
		u.union(3,4);
		u.union(5,6);
		assertTrue(u.same(3,4));
		assertFalse(u.same(3,5));
		u.union(3,6);

		assertEquals(u.find(3), u.find(6));
		assertEquals(u.find(4), u.find(6));
		assertEquals(u.find(5), u.find(6));



	}

	@Test
	public void customSlow() {
		UnionFind u = new UnionFind(10, false);
		u.union(3,4);
		u.union(5,6);
		assertTrue(u.same(3,4));
		assertFalse(u.same(3,5));
		u.union(3,6);


		assertEquals(u.find(3), u.find(6));
		assertEquals(u.find(4), u.find(6));
		assertEquals(u.find(5), u.find(6));


	}

}
