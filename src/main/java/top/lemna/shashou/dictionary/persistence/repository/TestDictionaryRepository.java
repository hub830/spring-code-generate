package top.lemna.shashou.dictionary.persistence.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.common.base.persistence.repository.BaseRepository;
import top.lemna.shashou.dictionary.persistence.domain.TestDictionary;

@Repository
public interface TestDictionaryRepository extends BaseRepository<TestDictionary, Long> {
 
  
  /** 字典名称 一般用于显示 */
  List<TestDictionary> findByName(String name);
  
  /** 字典值 */
  List<TestDictionary> findByValue(Long value);
  
  /** 备注 */
  List<TestDictionary> findByRemark(String remark);
 
}
