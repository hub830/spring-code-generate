package ${classPath}.web.specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import top.lemna.common.specification.TimeRange;
import ${classPath}.web.command.${domain}QueryCommand;
import ${classPath}.persistence.domain.${domain};


public class ${domain}Specification implements Specification<${domain}> {

  private static final long serialVersionUID = 1L;

  private ${domain}QueryCommand criteria;


  public  ${domain}Specification(${domain}QueryCommand criteria) {
    super();
    this.criteria = criteria;
  }



  @Override
  public Predicate toPredicate(Root<${domain}> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

    List<Predicate> predicate = new ArrayList<>();

<#list fieldList as field>
  
    /** ${field.comment} */
    if (criteria.get${field.name?cap_first}() != null) {
      predicate.add(cb.equal(root.get("${field.name}"), criteria.get${field.name?cap_first}()));
    }
</#list>
 
    TimeRange timeRange = criteria.getCreateTime();
    if (timeRange != null && timeRange.getStart() != null) {
      predicate.add(cb.greaterThanOrEqualTo(root.get("createTime"), timeRange.getStart()));
    }
    if (timeRange != null && timeRange.getEnd() != null) {
      predicate.add(cb.lessThanOrEqualTo(root.get("createTime"), timeRange.getEnd()));
    }
    
    Predicate[] pre = new Predicate[predicate.size()];
    return query.where(predicate.toArray(pre)).getRestriction();
  }
}
