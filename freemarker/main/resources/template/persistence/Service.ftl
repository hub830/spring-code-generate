package ${classPath}.persistence.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lemna.common.base.persistence.service.BaseService;
import ${classPath}.persistence.domain.${domain};
import ${classPath}.persistence.repository.${domain}Repository;

@Service
public class ${domain}Service extends BaseService<${domain}> {

  @Autowired
  private ${domain}Repository repository;

  <#list fieldList as field>
  
  /** ${field.comment} */
  public List<${domain}> findBy${field.name?cap_first}(${field.type} ${field.name}){
    return repository.findBy${field.name?cap_first}(${field.name});
  }
  </#list>
  
}
