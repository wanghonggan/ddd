package cn.loosing.demo.dao.repository;

import cn.loosing.demo.dao.entity.Demo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DemoRepository extends JpaRepository<Demo, String> {


    @Query("select d from Demo d where d.name like %?1%")
    List<Demo> findAllByNameContaining(String name);

    Optional<Demo> findFirstByNameEqualsOrderByCreatedAtDesc(String name);

    List<Demo> findFirst10ByNameEqualsOrderByCreatedAtDesc(String name);

    @Override
    Page<Demo> findAll(Pageable pageable);
}