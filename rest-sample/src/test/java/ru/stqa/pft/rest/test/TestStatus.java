package ru.stqa.pft.rest.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestStatus extends TestBase {

    @Test
    public void testIssueStatus() throws IOException {
        skipIfNotFixed(15);
        System.out.println("catch");
    }
}
