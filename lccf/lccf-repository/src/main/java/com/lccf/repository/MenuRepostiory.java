package com.lccf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lccf.domain.Menu;

public interface MenuRepostiory extends JpaRepository<Menu, Long> {
	List<Menu> findByDeleteFlagAndParentId(Boolean deleteFlag,Long parentId);

}
