package org.bedu;

/*
 *  Escribir un programa que verifique si
 *  una secuencia de parentesis está balanceada
 *  y en caso de no estarlo, regrese la cantidad de
 *  paréntesis para balancearlo.
 * 
 *  Ejemplos:
 * 
 *  "(" -> No está balanceada, necesita 1
 * 
 *  ")))))(" -> No está balanceada, necesita 6
 * 
 *  "(((((())))" -> No está balanceada, necesita 2
 * 
 *  "()" -> Está balanceada, necesita 0
 * 
 *  "(((())))" -> Está balanceada, necesita, 0
 * 
 *  "((()))()()()((()()()()))" -> Está balanceada, necesita 0
 * 
 *  "(()" -> No está balanceado
 * 
 *  "))((" -> No está balanceado
 */

public class BalancedParentheses {

  public int isBalanced(String sequence) {
    if (sequence.isEmpty()) {
      return 0;
    } else if (sequence.length() == 1) {
      return 1;
    }

    int cont = 0;
    int aux = 0;

    for (int i = 0; i < sequence.length(); i++) {
      if (sequence.charAt(i) == '(') {
        cont++;
      } else {
        if (cont - 1 < 0) {
          aux++;
        } else {
          cont--;
        }
      }
    }
    return aux + cont;
  }
}
