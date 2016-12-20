package com.chatIn.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class ObjectUtil {
  /**
   * Checks for variety of equality conditions.
   *
   * @param a
   * @param b
   * @return 1. If object reference are equal than return true 2. If only one of the object reference is null than
   * return false 3. return if contents of a is equal to b via a.equals(b)
   */
  public static boolean equalityCheck(Object a, Object b) {
    if (a == b) return true;
    if (a == null || b == null) return false;
    return a.equals(b);
  }

  /**
   * Checks for variety of equality conditions.
   *
   * @param a
   * @param b
   * @return 1. If byte[] reference are equal than return true 2. If only one of the byte[] reference is null than
   * return false 3. return if contents of a is equal to b via Arrays.equals(a,b)
   */
  public static boolean equalityCheck(byte[] a, byte[] b) {
    if (a == b) return true;
    if (a == null || b == null) return false;
    return Arrays.equals(a, b);
  }

  public static void printBytes(byte[] ba, boolean doHex) {
    String format = doHex ? "0x%x " : "%d ";
    for (byte b : ba) {
      System.out.printf(format, b);
    }
  }

  public static void printBytes(byte[] ba) {
    printBytes(ba, false);
  }

  private static final String defaultBytePrintFormat = "#,###,###.##";
  private static final String defaultSingleBytePrintFormat = "#,###,###.#";


  public static String bytePrettyPrint(long nbytes) {
    return bytePrettyPrint(nbytes, defaultBytePrintFormat);
  }

  public static String bytePrettySingleDecimalPrint(long nbytes) {
    return bytePrettyPrint(nbytes, defaultSingleBytePrintFormat, RoundingMode.UP);
  }

  public static String bytePrettyPrint(long nbytes, String pattern) {
    return bytePrettyPrint(nbytes, pattern, RoundingMode.HALF_EVEN);

  }

  private static final long FOLDER_SIZE = -1;
  public static String bytePrettyPrint(long nbytes, String pattern, RoundingMode roundingMode) {
    if (nbytes == FOLDER_SIZE)
      return "-";
    DecimalFormat df = new DecimalFormat(pattern);
    df.setRoundingMode(roundingMode);
    long mult = 1024;
    if (nbytes < mult)
      return df.format(nbytes) + "  B";

    double bytes = nbytes;
    if ((bytes /= mult) < mult) return df.format(bytes) + " KB";
    if ((bytes /= (mult)) < mult) return df.format(bytes) + " MB";
    if ((bytes /= (mult)) < mult) return df.format(bytes) + " GB";
    // bytes is in GB; convert to TB
    bytes /= (mult);    // anything above 1024 GB will be printed as terabytes
    return df.format(bytes) + " TB";
  }

  public static Long getLong(Object o, Long def) {
    if (o == null) {
      return def;
    }
    if (o instanceof Long)
      return (Long) o;
    Long l = null;
    try {
      if (o != null) {
        l = Long.valueOf(o.toString());
      }
    } catch (NumberFormatException e) {
      l = def;
    }
    return l;
  }


  public static Float getFloat(Object o, Float def) {
    if (o == null) {
      return def;
    }
    if (o instanceof Float)
      return (Float) o;
    Float l = null;
    try {
      if (o != null) {
        l = Float.valueOf(o.toString());
      }
    } catch (NumberFormatException e) {
      l = def;
    }
    return l;
  }

  public static boolean isLong(Object o) {
    return o != null && o instanceof Long;
  }

  /**
   * Checks the given object is null or not.<br>
   * If it is null then throws the illegal argument exception with passed error.<br>
   *
   * @param object Object to check against for null.
   * @param error  Error message to passed to illegal argument exception.
   */
  public static void throwIllegalArgumentIfNull(Object object, String error) {
    if (object == null) {
      throw new IllegalArgumentException(error);
    }
  }


}
