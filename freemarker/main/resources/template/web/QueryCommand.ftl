package ${classPath}.web.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.Data;
import lombok.ToString;
import top.lemna.common.specification.TimeRange;

@Data
@ToString
public class  ${domain}QueryCommand {

<#list fieldList as field>
  

<#compress>
  /** ${field.comment} */<#list field.annotations as annotation> 
<#if annotation?starts_with("@Column")>
<#if field.type="String">
  @Length(max = ${annotation?substring(annotation?last_index_of("length")+7)}
</#if>
<#if field.type="Long">
  @Min(0)
  @Max(Integer.MAX_VALUE)
</#if>
</#if>
</#list>
  private ${field.type} ${field.name};
</#compress>
</#list>

  
  /** 创建时间 */
  private TimeRange createTime; 
}