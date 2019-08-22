package top.lemna.shashou.dictionary.web.controller;

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
import top.lemna.shashou.dictionary.persistence.domain.TestDictionary;
import top.lemna.shashou.dictionary.persistence.service.TestDictionaryService;
import top.lemna.shashou.dictionary.web.command.TestDictionaryAddCommand;
import top.lemna.shashou.dictionary.web.command.TestDictionaryEditCommand;
import top.lemna.shashou.dictionary.web.command.TestDictionaryQueryCommand;
import top.lemna.shashou.dictionary.web.specification.TestDictionarySpecification;


@RestController

@RequestMapping("/dictionary/TestDictionary")
public class TestDictionaryController {

  @Autowired
  private TestDictionaryService service;

  @GetMapping("{id}")
  public TestDictionary get(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @GetMapping
  public Page<TestDictionary> search(//
      @Valid TestDictionaryQueryCommand command, //
      @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable //
  ) {
    TestDictionarySpecification specification = new TestDictionarySpecification(command);
    return service.findAll(specification, pageable);
  }
    
  @PostMapping
  public TestDictionary add(@RequestBody @Valid TestDictionaryAddCommand command) {
    TestDictionary entity = new TestDictionary();
    BeanUtils.copyPropertiesIgnoreNull(command, entity);
    return service.save(entity);
  }
  
  @PutMapping("{id}")
  public TestDictionary edit(@PathVariable("id") Long id, @RequestBody @Valid TestDictionaryEditCommand command) {
    TestDictionary entity = service.findById(id);
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
