package com.hong.qrcode.repository;

import com.hong.qrcode.domain.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GoodsRepository extends JpaRepository<Goods, Integer> {

    Page<Goods> getAllBy(Pageable pageable);

    Goods findByName(String name);

    void deleteByName(String name);

}
