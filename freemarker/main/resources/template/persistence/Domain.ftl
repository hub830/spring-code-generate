package ${classPath}.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.lemna.shashou.core.entity.AutoIdEntity;

/**
 * 店铺表
 * 
 * @author fox
 *
 */
@Data
@ToString
@Entity
@EqualsAndHashCode(callSuper = false)
@Table
@NoArgsConstructor
public class Shop extends AutoIdEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 字典编号
   */
  @NotNull
  @Column(length = 32)
  private Long shopNo;

  /**
   * 卖家编号
   */
  @NotNull
  @Column(length = 32)
  private Long merchantNo;

  /**
   * 字典名称 一般用于显示
   */
  @NotNull
  @Column(length = 64)
  private String name;

}
