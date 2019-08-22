package ${classPath}.persistence.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import top.lemna.common.base.persistence.repository.BaseRepository;
import ${classPath}.persistence.domain.${domain};

@Repository
public interface ${domain}Repository extends BaseRepository<${domain}, Long> {
 
  <#list fieldList as field>
  
  /** ${field.comment} */
  List<${domain}> findBy${field.name?cap_first}(${field.type} ${field.name});
  </#list>
 
}
