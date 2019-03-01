[![Build Status](https://travis-ci.org/micwypych/java-with-jpf-example.svg?branch=master)](https://travis-ci.org/micwypych/java-with-jpf-example)

# java-with-jpf-example
Java Path Finder and Gradle configuration with dining philosopher problem and racer example.

Currently the code works only on Linux with JDK 8 because of the usage of JPF. 

please visit [WIKI page](https://github.com/micwypych/java-with-jpf-example/wiki) for instruction how to run the code
or investigate travis.yml script in this repository. 

After correct setup running ./gradlew test should result with running 4 test of which 1 test fails, cf. the following output:
``` bash
:compileJava
:processResources NO-SOURCE
:classes
:compileTestJava
Download https://jcenter.bintray.com/junit/junit/4.12/junit-4.12.pom
Download https://jcenter.bintray.com/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.pom
Download https://jcenter.bintray.com/org/hamcrest/hamcrest-parent/1.3/hamcrest-parent-1.3.pom
Download https://jcenter.bintray.com/junit/junit/4.12/junit-4.12.jar
Download https://jcenter.bintray.com/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
:processTestResources NO-SOURCE
:testClasses
:test
RacerTest > testRacer FAILED
    java.lang.AssertionError at RacerTest.java:19
4 tests completed, 1 failed
:test FAILED
FAILURE: Build failed with an exception.
* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///home/travis/build/micwypych/java-with-jpf-example/build/reports/tests/test/index.html
* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
BUILD FAILED
Total time: 17.982 secs
The command "./gradlew test" exited with 1.
```

It is then recommended to investigate the generated JUnit report of index.html (link is given in the output) in the webbrowser. 
Especially, the section of Standard Output contains useful info generated by the JPF. 


There are currently 4 test in the project:
  - AppTest.testAppHasGreeting - should always pass and if it fails something is wrong with gradle or java
  - RacerTest.testRacer - is failing becase JPF found racing condition, please try to fix it (standard output of the test should help)
  - DiningPhilosophersTest.catchDeadlock - is passing becase JPF is instructed to find deadlock in the system and it succeeds, please try to make this test fail 
  - DiningPhilosophersTest.catchDeadlockInInfiniteCase - is passing becase JPF is instructed to find deadlock in the system and it succeeds, please try to make this test fail


If the JPF was not correctly set up prior to runnig the tests then 3 of 4 tests are failing and the standard output and standard error sections of the JUnit report gives you hint about missing java classes

By clicking on the badge at the beggining of this readme you can see the build logs from Travis. One can see the correct build under the Ubuntu only with openjdk8 and oraclejdk8 (then logs contain 4174 lines (not all the lines are immediately loaded by the webpage, so please wait). Versions of jdk above 8 fail to compile and fail to run examples from jpf-core.
