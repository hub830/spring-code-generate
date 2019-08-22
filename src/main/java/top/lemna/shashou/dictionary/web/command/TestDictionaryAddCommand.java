package top.lemna.shashou.dictionary.web.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class TestDictionaryAddCommand {

  

/** 字典名称 一般用于显示 */
@NotNull
@Length(max = 32)
private String name;  

/** 字典值 */
@Min(0)
@Max(Integer.MAX_VALUE)
private Long value;  

/** 备注 */
@Length(max = 512)
private String remark;
}

