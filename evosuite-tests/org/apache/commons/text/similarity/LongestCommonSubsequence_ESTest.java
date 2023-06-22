/*
 * This file was automatically generated by EvoSuite
 * Thu Jun 22 09:30:01 GMT 2023
 */

package org.apache.commons.text.similarity;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.nio.CharBuffer;
import org.apache.commons.text.similarity.LongestCommonSubsequence;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class LongestCommonSubsequence_ESTest extends LongestCommonSubsequence_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      char[] charArray0 = new char[3];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      CharBuffer charBuffer1 = CharBuffer.allocate(492);
      int[][] intArray0 = longestCommonSubsequence0.longestCommonSubstringLengthArray(charBuffer0, charBuffer1);
      assertEquals(4, intArray0.length);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = LongestCommonSubsequence.INSTANCE;
      char[] charArray0 = new char[8];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      charBuffer0.append(']');
      CharSequence charSequence0 = longestCommonSubsequence0.logestCommonSubsequence("I<n*d-e]", charBuffer0);
      assertEquals("", charSequence0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      char[] charArray0 = new char[2];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      CharBuffer charBuffer1 = CharBuffer.allocate(2458);
      Integer integer0 = longestCommonSubsequence0.apply(charBuffer1, charBuffer0);
      assertEquals(2, (int)integer0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.allocate(760);
      // Undeclared exception!
      longestCommonSubsequence0.longestCommonSubstringLengthArray(charBuffer0, charBuffer0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      // Undeclared exception!
      try { 
        longestCommonSubsequence0.longestCommonSubstringLengthArray((CharSequence) null, (CharSequence) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.text.similarity.LongestCommonSubsequence", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      char[] charArray0 = new char[2];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      CharBuffer charBuffer1 = CharBuffer.allocate(2458);
      // Undeclared exception!
      longestCommonSubsequence0.longestCommonSubsequence(charBuffer0, charBuffer1);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      char[] charArray0 = new char[2];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
      charBuffer0.append('W');
      // Undeclared exception!
      try { 
        longestCommonSubsequence0.longestCommonSubsequence(charBuffer0, charBuffer1);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.Buffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.allocate(760);
      // Undeclared exception!
      longestCommonSubsequence0.logestCommonSubsequence(charBuffer0, charBuffer0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.allocate(3712);
      // Undeclared exception!
      longestCommonSubsequence0.apply(charBuffer0, charBuffer0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      char[] charArray0 = new char[2];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      CharSequence charSequence0 = longestCommonSubsequence0.longestCommonSubsequence(";", charBuffer0);
      assertEquals("", charSequence0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      char[] charArray0 = new char[2];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      charBuffer0.get();
      CharBuffer charBuffer1 = charBuffer0.append('W');
      CharSequence charSequence0 = longestCommonSubsequence0.longestCommonSubsequence(charBuffer1, charBuffer0);
      assertEquals("", charSequence0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = LongestCommonSubsequence.INSTANCE;
      // Undeclared exception!
      try { 
        longestCommonSubsequence0.longestCommonSubsequence((CharSequence) null, (CharSequence) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Inputs must not be null
         //
         verifyException("org.apache.commons.text.similarity.LongestCommonSubsequence", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = LongestCommonSubsequence.INSTANCE;
      // Undeclared exception!
      try { 
        longestCommonSubsequence0.longestCommonSubsequence("q+", (CharSequence) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Inputs must not be null
         //
         verifyException("org.apache.commons.text.similarity.LongestCommonSubsequence", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = LongestCommonSubsequence.INSTANCE;
      char[] charArray0 = new char[8];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      charArray0[0] = 'I';
      int[][] intArray0 = longestCommonSubsequence0.longestCommonSubstringLengthArray(charBuffer0, "I<n*d-e]");
      assertEquals(9, intArray0.length);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.allocate(3);
      char[] charArray0 = new char[8];
      CharBuffer charBuffer1 = CharBuffer.wrap(charArray0);
      CharSequence charSequence0 = longestCommonSubsequence0.logestCommonSubsequence(charBuffer0, charBuffer1);
      assertEquals("\u0000\u0000\u0000", charSequence0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) "\u0000\u0000\u0000", 3, 3);
      CharSequence charSequence0 = longestCommonSubsequence0.longestCommonSubsequence("\u0000\u0000\u0000", charBuffer0);
      assertEquals("", charSequence0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.allocate(0);
      // Undeclared exception!
      try { 
        longestCommonSubsequence0.logestCommonSubsequence(charBuffer0, (CharSequence) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Inputs must not be null
         //
         verifyException("org.apache.commons.text.similarity.LongestCommonSubsequence", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = LongestCommonSubsequence.INSTANCE;
      Integer integer0 = longestCommonSubsequence0.apply("<n*d-e]", "I<n*d-e]");
      assertEquals(7, (int)integer0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.allocate(3);
      Integer integer0 = longestCommonSubsequence0.apply(charBuffer0, "");
      assertEquals(0, (int)integer0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = LongestCommonSubsequence.INSTANCE;
      CharBuffer charBuffer0 = CharBuffer.allocate(0);
      Integer integer0 = longestCommonSubsequence0.apply(charBuffer0, charBuffer0);
      assertEquals(0, (int)integer0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.allocate(3);
      // Undeclared exception!
      try { 
        longestCommonSubsequence0.apply(charBuffer0, (CharSequence) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Inputs must not be null
         //
         verifyException("org.apache.commons.text.similarity.LongestCommonSubsequence", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = LongestCommonSubsequence.INSTANCE;
      char[] charArray0 = new char[8];
      CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
      CharSequence charSequence0 = longestCommonSubsequence0.longestCommonSubsequence(charBuffer0, charBuffer0);
      assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000", charSequence0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      LongestCommonSubsequence longestCommonSubsequence0 = new LongestCommonSubsequence();
      CharBuffer charBuffer0 = CharBuffer.allocate(3);
      // Undeclared exception!
      try { 
        longestCommonSubsequence0.apply((CharSequence) null, charBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Inputs must not be null
         //
         verifyException("org.apache.commons.text.similarity.LongestCommonSubsequence", e);
      }
  }
}
