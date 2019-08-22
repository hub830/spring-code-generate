package top.lemna.shashou.dictionary.persistence.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lemna.common.base.persistence.service.BaseService;
import top.lemna.shashou.dictionary.persistence.domain.TestDictionary;
import top.lemna.shashou.dictionary.persistence.repository.TestDictionaryRepository;

@Service
public class TestDictionaryService extends BaseService<TestDictionary> {

  @Autowired
  private TestDictionaryRepository repository;

  
  /** 字典名称 一般用于显示 */
  public List<TestDictionary> findByName(String name){
    return repository.findByName(name);
  }
  
  /** 字典值 */
  public List<TestDictionary> findByValue(Long value){
    return repository.findByValue(value);
  }
  
  /** 备注 */
  public List<TestDictionary> findByRemark(String remark){
    return repository.findByRemark(remark);
  }
  
}
