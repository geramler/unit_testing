package com.in28minutes.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {

	List<String> mock = Mockito.mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValue() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals("in28Minutes", mock.get(1));
	}

	@Test
	public void verificationBasics() {
		// SUT
		mock.get(0);
		mock.get(1);

		// Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(2)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}

	@Test
	public void argumentCapturing() {
		// SUT
		mock.add("Something");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());

		assertEquals("Something", captor.getValue());
	}

	@Test
	public void multipleArgumentCapturing() {
		// SUT
		mock.add("Something1");
		mock.add("Something2");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		assertEquals("Something1", allValues.get(0));
		assertEquals("Something2", allValues.get(1));
	}

}