package com.github.gamepiaynmo.custommodel.expression;

public enum TokenType {
   IDENTIFIER("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_:."),
   NUMBER("0123456789", "0123456789."),
   OPERATOR("+-*/%!&|<>=", "&|="),
   COMMA(","),
   BRACKET_OPEN("("),
   BRACKET_CLOSE(")");

   private String charsFirst;
   private String charsNext;
   public static final TokenType[] VALUES = values();

   TokenType(String charsFirst) {
      this(charsFirst, "");
   }

   TokenType(String charsFirst, String charsNext) {
      this.charsFirst = charsFirst;
      this.charsNext = charsNext;
   }

   public String getCharsFirst() {
      return this.charsFirst;
   }

   public String getCharsNext() {
      return this.charsNext;
   }

   public static TokenType getTypeByFirstChar(char ch) {
      for (TokenType type : VALUES) {
         if (type.getCharsFirst().indexOf(ch) >= 0) {
            return type;
         }
      }

      return null;
   }

   public boolean hasCharNext(char ch) {
      return this.charsNext.indexOf(ch) >= 0;
   }

   private static class Const {
      static final String ALPHAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
      static final String DIGITS = "0123456789";
   }
}
