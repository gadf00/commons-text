/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Jun 22 09:09:00 GMT 2023
 */

package org.apache.commons.text.lookup;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class StringLookupFactory_ESTest_scaffolding {

  @org.junit.Rule
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "org.apache.commons.text.lookup.StringLookupFactory"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "Cp1252"); 
    java.lang.System.setProperty("user.dir", "C:\\Users\\shahr\\OneDrive\\Desktop\\evosuite"); 
    java.lang.System.setProperty("sun.arch.data.model", "64"); 
    java.lang.System.setProperty("java.io.tmpdir", "C:\\Users\\shahr\\AppData\\Local\\Temp\\"); 
    java.lang.System.setProperty("sun.os.patch.level", ""); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(StringLookupFactory_ESTest_scaffolding.class.getClassLoader() ,
      "org.apache.commons.text.lookup.JavaPlatformStringLookup",
      "org.apache.commons.text.lookup.StringLookupFactory",
      "org.apache.commons.text.lookup.InterpolatorStringLookup",
      "org.apache.commons.text.lookup.PropertiesStringLookup",
      "org.apache.commons.text.lookup.AbstractStringLookup",
      "org.apache.commons.text.lookup.DateStringLookup",
      "org.apache.commons.text.lookup.UrlEncoderStringLookup",
      "org.apache.commons.text.lookup.FileStringLookup",
      "org.apache.commons.text.lookup.FunctionStringLookup",
      "org.apache.commons.text.lookup.XmlStringLookup",
      "org.apache.commons.text.lookup.UrlDecoderStringLookup",
      "org.apache.commons.text.lookup.ScriptStringLookup",
      "org.apache.commons.text.lookup.DnsStringLookup",
      "org.apache.commons.text.lookup.LocalHostStringLookup",
      "org.apache.commons.text.lookup.BiStringLookup",
      "org.apache.commons.text.lookup.StringLookup",
      "org.apache.commons.text.lookup.ConstantStringLookup",
      "org.apache.commons.text.lookup.BiFunctionStringLookup",
      "org.apache.commons.text.lookup.ResourceBundleStringLookup",
      "org.apache.commons.text.lookup.UrlStringLookup",
      "org.apache.commons.text.lookup.DefaultStringLookup",
      "org.apache.commons.text.lookup.StringLookupFactory$DefaultStringLookupsHolder"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(StringLookupFactory_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.apache.commons.text.lookup.AbstractStringLookup",
      "org.apache.commons.text.lookup.FunctionStringLookup",
      "org.apache.commons.text.lookup.StringLookupFactory",
      "org.apache.commons.text.lookup.ConstantStringLookup",
      "org.apache.commons.text.lookup.DateStringLookup",
      "org.apache.commons.text.lookup.DnsStringLookup",
      "org.apache.commons.text.lookup.FileStringLookup",
      "org.apache.commons.text.lookup.JavaPlatformStringLookup",
      "org.apache.commons.text.lookup.LocalHostStringLookup",
      "org.apache.commons.text.lookup.PropertiesStringLookup",
      "org.apache.commons.text.lookup.ResourceBundleStringLookup",
      "org.apache.commons.text.lookup.ScriptStringLookup",
      "org.apache.commons.text.lookup.UrlStringLookup",
      "org.apache.commons.text.lookup.UrlDecoderStringLookup",
      "org.apache.commons.text.lookup.UrlEncoderStringLookup",
      "org.apache.commons.text.lookup.XmlStringLookup",
      "org.apache.commons.text.lookup.DefaultStringLookup",
      "org.apache.commons.text.lookup.StringLookupFactory$DefaultStringLookupsHolder",
      "org.apache.commons.text.lookup.InterpolatorStringLookup",
      "org.apache.commons.text.lookup.BiFunctionStringLookup",
      "org.apache.commons.text.lookup.IllegalArgumentExceptions"
    );
  }
}
