package com.DevCourses.SpringBoot.service.mapper;

import org.junit.jupiter.api.*;

class StudentMapperTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void setUp() {
        System.out.println("before each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each");
    }

    @Test
    void firstMethod() {
        System.out.println("first method");
    }

    @Test
    void secondMethod() {
        System.out.println("second method");
    }

    /* Notes:
    * ----------------------------------------------
    * Basic JUnit 5 Annotations
    * @DisplayName: Allows you to define a readable name for the test or test class
        @DisplayName("Addition Test")
        @Test
        void testAddition() {
            // test code
        }
    *
    * @Disabled: Disables a test or test class
        @Disabled("This test is temporarily disabled")
        @Test
        void testDisabled() {
            // test code
        }
    *
    * @RepeatedTest: Allows you to repeat a test a specific number of times
        @RepeatedTest(5)
        void testRepeated() {
            // test code
        }
    *
    * @ParameterizedTest: Allows you to run a test with different sets of parameters
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void testParameterized(int number) {
            // test code
        }
    *
    * @Nested: Allows you to group related test in a nested class.
        @Nested
        class NestedTests {
            @Test
            void testNested() {
                // test code
            }
        }
    *
    * ----------------------------------------------
    * Spring Boot-Specific Annotations:
    * @SpringBootTest: Used for integration test that require a full Spring Boot context.
        @SpringBootTest
        class MyIntegrationTest {
            // test code
        }
    *
    * @WebMvcTest: Used for testing MVC controllers. Configures a Spring Boot context limited to web components:
        @WebMvcTest(MyController.class)
        class MyControllerTest {
            // test code
        }
    *
    * @DataJpaTest: Used for testing JPA repositories. Configures a Spring Boot context limited to JPA components.
        @DataJpaTest
        class MyRepositoryTest {
            // test code
        }
    * @MockBean: Allows you to add a mock of a bean to the Spring context.
        @MockBean
        private MyService myService;
    *
    * @SpyBean: Similar to @MockBean, but allows you to use a spy instead of a mock.
        @SpyBean
        private MyService myService;
    *
    * @TestConfiguration: Allows you to define a specific configuration for a test
        @TestConfiguration
        static class TestConfig {
            @Bean
            public MyService myService() {
                return new MyService();
            }
        }
    *
    * @ContextConfiguration: Allows you to specify the configuration classes to load for the test.
        @ContextConfiguration(classes = {MyConfig.class})
        class MyTestWithConfig {
            // test code
        }
    *
    * @ActiveProfiles: Allows you to activate specific profiles for the test.
        @ActiveProfiles("test")
        class MyTestWithProfile {
            // test code
        }
    *
    * @Sql: Allows to you to execute SQL scripts before or after the test.
        @Sql("/scripts/clean-db.sql")
        @Test
        void testWithSqlScript() {
            // test code
        }
    *
    * @Transactional: Allows the test to run within a transaction that is rolled back at the end.
        @Transactional
        @Test
        void testTransactional() {
            // test code
        }
    *
    * @DirtiesContext: Indicates that the Spring context should be reset after the test.
        @DirtiesContext
        @Test
        void testWithContextReset() {
            // test code
        }
    *
    * ----------------------------------------------
    * Other Useful Annotations
    * @ExtendWith: Allows you to extend JUnit functionality with custom or Spring extensions.
        @ExtendWith(SpringExtension.class)
        class MyTestWithExtension {
            // test code
        }
    *
    * @Tag: Allows you to tag test so they can be filtered during execution.
        @Tag("slow")
        @Test
        void testSlow() {
            // test code
        }
    *
    * @Timeout: Allows you to set a maximum execution time for a test:
        @Timeout(5)
        @Test
        void testWithTimeout() {
            // test code
        }
    * */

}