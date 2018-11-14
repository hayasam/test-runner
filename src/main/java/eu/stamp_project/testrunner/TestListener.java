package eu.stamp_project.testrunner;

import eu.stamp_project.testrunner.runner.test.Failure;
import eu.stamp_project.testrunner.runner.test.TestRunner;

import java.io.Serializable;
import java.util.List;

/**
 * created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 13/11/18
 */
public interface TestListener extends Serializable {

    public static final String SERIALIZE_NAME = "TestListener";

    public static final String OUTPUT_DIR = "target" + TestRunner.FILE_SEPARATOR + "dspot" + TestRunner.FILE_SEPARATOR;

    public static final String EXTENSION = ".ser";

    /**
     * Aggregate result of this instance to the given instance
     * @param that the other instance of TestListener of which we need to add the values to this instance
     * @return this
     */
    public TestListener aggregate(TestListener that);

    public List<Failure> getFailingTests();

    public List<Failure> getAssumptionFailingTests();

    public List<String> getIgnoredTests();

    public Failure getFailureOf(String testMethodName);

    public List<String> getPassingTests();

    public List<String> getRunningTests();

    public void save();

}