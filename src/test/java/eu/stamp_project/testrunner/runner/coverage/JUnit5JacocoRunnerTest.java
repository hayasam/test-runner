package eu.stamp_project.testrunner.runner.coverage;

import eu.stamp_project.testrunner.AbstractTest;
import eu.stamp_project.testrunner.listener.Coverage;
import eu.stamp_project.testrunner.listener.impl.CoverageImpl;
import eu.stamp_project.testrunner.runner.JUnit4Runner;
import eu.stamp_project.testrunner.runner.ParserOptions;
import eu.stamp_project.testrunner.utils.ConstantsHelper;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 19/12/17
 */
public class JUnit5JacocoRunnerTest extends AbstractTest {

    @Test
    public void testWithoutNewJvmOnTestClass() throws Exception {

        /*
            Using the api to compute the coverage on a test class
         */

        JUnit5JacocoRunner
                .main(new String[]{ParserOptions.FLAG_pathToCompiledClassesOfTheProject, TEST_PROJECT_CLASSES,
                        ParserOptions.FLAG_fullQualifiedNameOfTestClassToRun, "junit5.TestSuiteExample",});
        final Coverage load = CoverageImpl.load();
        assertEquals(30, load.getInstructionsCovered());
        assertEquals(107, load.getInstructionsTotal());
        assertEquals(expectedExecutionPath, load.getExecutionPath());
    }

    private static final String expectedExecutionPath = "tobemocked/LoginDao:<init>+()V+0|login+" +
            "(Ltobemocked/UserForm;)I+0-tobemocked/LoginController:<init>+()V+0|login+(Ltobemocked/UserForm;)" +
            "Ljava/lang/String;+0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0-tobemocked/LoginService:<init>+()V+0|login+" +
            "(Ltobemocked/UserForm;)Z+0,0,0,0,0,0,0,0,0|setCurrentUser+(Ljava/lang/String;)V+0,0,0,0|setLoginDao+" +
            "(Ltobemocked/LoginDao;)V+0,0-example/Example:charAt+(Ljava/lang/String;I)C+2,0,0,4,4,0,7|<init>+()V+2,0," +
            "2,5,1,0,3-tobemocked/UserForm:<init>+()V+0|getUsername+()Ljava/lang/String;+0-";

    @Test
    public void testWithoutNewJvmOnTestCases() throws Exception {

        /*
            Using the api to compute the coverage on test cases
         */

        JUnit5JacocoRunner
                .main(new String[]{ParserOptions.FLAG_pathToCompiledClassesOfTheProject, TEST_PROJECT_CLASSES,
                        ParserOptions.FLAG_fullQualifiedNameOfTestClassToRun, "junit5.TestSuiteExample",
                        ParserOptions.FLAG_testMethodNamesToRun, "test8:test2"});
        final Coverage load = CoverageImpl.load();
        assertEquals(23, load.getInstructionsCovered());
        assertEquals(107, load.getInstructionsTotal());
    }

    @Ignore
    @Test
    public void testWithoutNewJvmOnTestCasesOnParametrized() throws Exception {

        /*
            Using the api to compute the coverage on test cases
         */

        JUnit5JacocoRunner
                .main(new String[]{ParserOptions.FLAG_pathToCompiledClassesOfTheProject, TEST_PROJECT_CLASSES,
                        ParserOptions.FLAG_fullQualifiedNameOfTestClassToRun, "junit5.ParametrizedTest",
                        ParserOptions.FLAG_testMethodNamesToRun, "test"});
        final Coverage load = CoverageImpl.load();
        assertEquals(23, load.getInstructionsCovered());
        assertEquals(107, load.getInstructionsTotal());
    }

}
