package top.lemna.shashou.dictionary.web.specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import top.lemna.common.specification.TimeRange;
import top.lemna.shashou.dictionary.web.command.TestDictionaryQueryCommand;
import top.lemna.shashou.dictionary.persistence.domain.TestDictionary;


public class TestDictionarySpecification implements Specification<TestDictionary> {

  private static final long serialVersionUID = 1L;

  private TestDictionaryQueryCommand criteria;


  public  TestDictionarySpecification(TestDictionaryQueryCommand criteria) {
    super();
    this.criteria = criteria;
  }



  @Override
  public Predicate toPredicate(Root<TestDictionary> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

    List<Predicate> predicate = new ArrayList<>();

  
    /** 字典名称 一般用于显示 */
    if (criteria.getName() != null) {
      predicate.add(cb.equal(root.get("name"), criteria.getName()));
    }
  
    /** 字典值 */
    if (criteria.getValue() != null) {
      predicate.add(cb.equal(root.get("value"), criteria.getValue()));
    }
  
    /** 备注 */
    if (criteria.getRemark() != null) {
      predicate.add(cb.equal(root.get("remark"), criteria.getRemark()));
    }
 
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
