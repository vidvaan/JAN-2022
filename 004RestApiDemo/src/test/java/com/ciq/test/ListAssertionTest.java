package com.ciq.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
 
import java.util.Arrays;
import java.util.List;
 
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
 
@DisplayName("Writing assertions for lists")
class ListAssertionTest {
 
    @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements {
 
        private Object first;
        private Object second;
 
        private List<Object> list;
 
        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();
 
            list = Arrays.asList(first, second);
        }
 
        @Test
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list, contains(first, second));
        }
    }
}