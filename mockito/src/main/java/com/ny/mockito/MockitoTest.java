package com.ny.mockito;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MockitoTest extends Mockito {
    @Test
    public void T01() {
        List mockedList = mock(List.class);
        //using mock object
        mockedList.add("one");
        //mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void T02() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        //following prints "first"
        // System.out.println(mockedList.get(0));

        //following throws runtime exception
//        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        // System.out.println(mockedList.get(999));
        //Although it is possible to verify a stubbed invocation, usually it's just redundant多余的
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed.
        verify(mockedList).get(0);
    }

    @Test
    //3. Argument matchers
    public void T03() {
        List mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenReturn("element");
        System.out.println(mockedList.get(999));
    }

    @Test
    //4. Verifying exact number of invocations / at least x / never
    //verifying 校验方法是否调用
    /**
     * Wanted but not invoked:
     * linkedList.get(0);
     * -> at com.ny.mockito.MockitoTest.T02(MockitoTest.java:38)
     * Actually, there were zero interactions with this mock.
     *
     * Wanted but not invoked:
     * linkedList.get(0);
     * -> at com.ny.mockito.MockitoTest.T02(MockitoTest.java:38)
     * Actually, there were zero interactions with this mock.
     */
    public void T04() {
        List mockedList = mock(List.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

    @Test
    //5. Stubbing void methods with exceptions
    public void T05() {
        List mockedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();

        //following throws RuntimeException:
        mockedList.clear();
    }

    //特别的; 详细的; 独有的; 挑剔的;
    @Test
    public void T06() {
        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(singleMock);

        //following will make sure that add is first called with "was added first", then with "was added second"
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. Multiple mocks that must be used in a particular order
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

//        //create inOrder object passing any mocks that need to be verified in order
//        InOrder inOrder = inOrder(firstMock, secondMock);
//
//        //following will make sure that firstMock was called before secondMock
//        inOrder.verify(firstMock).add("was called first");
//        inOrder.verify(secondMock).add("was called second");

        // Oh, and A + B can be mixed together at will
    }

    @Test
    //7. Making sure interaction(s) never happened on mock
    public void T07() {
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);

        //using mocks - only mockOne is interacted
        mockOne.add("one");

        //ordinary verification
        verify(mockOne).add("one");

        //verify that method was never called on a mock
        verify(mockOne, never()).add("two");

        //verify that other mocks were not interacted
        verifyZeroInteractions(mockTwo, mockThree);
    }


    //9. Shorthand for mocks creation - @Mock annotation
    //Minimizes repetitive mock creation code.
    //Makes the test class more readable.
    //Makes the verification error easier to read because the field name is used to identify the mock.
    @Mock
    List<String> mockedList;

    @Test
    public void T08() {
        //  MockitoAnnotations.initMocks(MockitoTest.class);
        mockedList.clear();
    }

    @Test
    //10. Stubbing consecutive calls (iterator-style stubbing)
    public void T10() {
        Map<String, String> mock = mock(HashMap.class);

        when(mock.get("some arg"))
                .thenThrow(new RuntimeException())
                .thenReturn("foo");
        //First call: throws runtime exception:
        try {

            mock.get("some arg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Second call: prints "foo"
        System.out.println(mock.get("some arg"));
        //Any consecutive call: prints "foo" as well (last stubbing wins).
        System.out.println(mock.get("some arg"));
    }
}
