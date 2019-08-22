package top.lemna.shashou.dictionary.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.lemna.common.base.persistence.entity.AutoIdEntity;

/**
 * 字典表
 * 
 * @author fox
 *
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table
@NoArgsConstructor
public class TestDictionary extends AutoIdEntity {

  private static final long serialVersionUID = 1L;
 

  /**
   * 字典名称 一般用于显示
   */
  @NotNull
  @Column(length = 32) 
  private String name;

  /**
   * 字典值
   */
  @Column(length = 32)
  private Long value;

  /**
   * 备注
   */
  @Column(length = 512)
  private String remark;

  public TestDictionary(@NotNull String name, Long value, String remark) {
    super();
    this.name = name;
    this.value = value;
    this.remark = remark;
  }
  
}
