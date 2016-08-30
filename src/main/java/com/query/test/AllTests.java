package com.query.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HttpRequestTest.class, OmdbJsonReaderTest.class, OmdbUriTest.class})
public class AllTests {

}