package top.lemna.shashou.dictionary.web.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.Data;
import lombok.ToString;
import top.lemna.common.specification.TimeRange;

@Data
@ToString
public class  TestDictionaryQueryCommand {

  

/** 字典名称 一般用于显示 */
@Length(max = 32)
private String name;  

/** 字典值 */
@Min(0)
@Max(Integer.MAX_VALUE)
private Long value;  

/** 备注 */
@Length(max = 512)
private String remark;
  
  /** 创建时间 */
  private TimeRange createTime; 
}