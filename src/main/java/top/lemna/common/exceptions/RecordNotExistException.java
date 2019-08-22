package top.lemna.common.exceptions;

public class RecordNotExistException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private String recordId;

  public RecordNotExistException(Long recordId) {
    super(format("数据库中不存在对应的记录, recordId:{}", recordId));
    this.recordId = String.valueOf(recordId);
  }

  public RecordNotExistException(String message, Object... param) {
    super(format(message, param));
  }

  public String getRecordId() {
    return recordId;
  }

  public void setRecordId(String recordId) {
    this.recordId = recordId;
  }
  

  public static String format(String str, Object... args) {
    for (int i = 0; i < args.length; i++) {
      str = str.replaceFirst("\\{\\}", String.valueOf(args[i]));
    }
    return str;
  }
}
