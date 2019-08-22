package top.lemna.common.specification;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TimeRange {

  private Date start;

  private Date end;

  public TimeRange(Date start, Date end) {
    this.start = start;
    this.end = end;
  }
}
