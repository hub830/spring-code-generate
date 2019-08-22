package top.lemna.common.exceptions;

public class InvalidArgumentException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvalidArgumentException(String message, Object... args) {
    super(format(message, args));
  }

  public static String format(String str, Object... args) {
    for (int i = 0; i < args.length; i++) {
      str = str.replaceFirst("\\{\\}", String.valueOf(args[i]));
    }
    return str;
  }
}
