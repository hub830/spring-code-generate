package top.lemna.common.base.persistence.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import top.lemna.common.base.persistence.repository.BaseRepository;
import top.lemna.common.exceptions.RecordNotExistException;


public abstract class BaseService<T> {
	
  @Autowired
  private BaseRepository<T, Long> repository; 


  public void delete(Long id) {
    repository.deleteById(id);
  }

  public void delete(T entity) {
    repository.delete(entity);
  }

  public void delete(Iterable<? extends T> entities) {
    repository.deleteAll(entities);
  }

  public void exists(Long id) {
    repository.existsById(id);
  }

  public Iterable<T> findAll() {
    return repository.findAll();
  }

  public T findById(Long id) {
    Optional<T> t = repository.findById(id);
    return t.orElseThrow(() -> new RecordNotExistException(String.valueOf(id)));
  }

  @Transactional
  public T save(T entity) {
    return repository.save(entity);
  }

  public Page<T> findAll(Specification<T> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }
}
