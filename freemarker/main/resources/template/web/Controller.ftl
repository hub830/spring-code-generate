package ${classPath}.web.controller;

import java.util.Set;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lemna.common.utils.BeanUtils;
import ${classPath}.persistence.domain.${domain};
import ${classPath}.persistence.service.${domain}Service;
import ${classPath}.web.command.${domain}AddCommand;
import ${classPath}.web.command.${domain}EditCommand;
import ${classPath}.web.command.${domain}QueryCommand;
import ${classPath}.web.specification.${domain}Specification;


@RestController

@RequestMapping("/${artifact}/${domain}")
public class ${domain}Controller {

  @Autowired
  private ${domain}Service service;

  @GetMapping("{id}")
  public ${domain} get(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @GetMapping
  public Page<${domain}> search(//
      @Valid ${domain}QueryCommand command, //
      @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable //
  ) {
    ${domain}Specification specification = new ${domain}Specification(command);
    return service.findAll(specification, pageable);
  }
    
  @PostMapping
  public ${domain} add(@RequestBody @Valid ${domain}AddCommand command) {
    ${domain} entity = new ${domain}();
    BeanUtils.copyPropertiesIgnoreNull(command, entity);
    return service.save(entity);
  }
  
  @PutMapping("{id}")
  public ${domain} edit(@PathVariable("id") Long id, @RequestBody @Valid ${domain}EditCommand command) {
    ${domain} entity = service.findById(id);
    BeanUtils.copyPropertiesIgnoreNull(command, entity);
    return service.save(entity);
  }
  
  @DeleteMapping("{id}")
  public void del(@PathVariable("id") Long id) {
    service.delete(id);
  }
  
  @DeleteMapping
  public void del(Set<Long> ids) {
    for (Long id : ids) {
      service.delete(id);
    }
  }
}
