package com.cg.capbook.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {

}
