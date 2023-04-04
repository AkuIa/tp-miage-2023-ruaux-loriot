package com.acme.todolist;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

class TodolistApplicationTests {

	void contextLoads() {
	}

	@Test
	public void testFinalContent() {
		// Item en retard
		TodoItem lateItem = new TodoItem("1", Instant.now().minus(2, ChronoUnit.DAYS), "Item en retard");
		assertEquals("[LATE!] Item en retard", lateItem.finalContent());

		// Item en avance
		TodoItem earlyItem = new TodoItem("2", Instant.now().plus(2, ChronoUnit.DAYS), "Item en avance");
		assertEquals("Item en avance", earlyItem.finalContent());

		// Item à l'heure (créé juste avant la vérification)
		TodoItem onTimeItem = new TodoItem("3", Instant.now(), "Item à l'heure");
		assertEquals("Item à l'heure", onTimeItem.finalContent());
	}

}


