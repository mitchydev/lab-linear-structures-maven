package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.Stack;
import edu.grinnell.csc207.linear.LinkedStack;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(' || ch == '[') {
        parens.push(ch);
      } else if (ch == ')' || ch == ']') {
        if (parens.isEmpty()) {
          return false;
        }
        char open = parens.pop();
        if ((ch == ')' && open != '(') || (ch == ']' && open != '[')) {
          return false;
        }
      }
    }
    return parens.isEmpty();
  } // checkMatching
} // class StringUtils

