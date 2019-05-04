package com.hong.qrcode.service;

import com.hong.qrcode.domain.Goods;
import com.hong.qrcode.form.GoodsForm;
import com.hong.qrcode.form.OutGoodsForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {

    Page<Goods> GetGoodsListByPage(Pageable pageable);

    List<Goods> GetGoodsList();

    void AddGoodsToStock(List<GoodsForm> goodsList);

    void DeleteByName(String name);

    void DeleteByNameList(List<String> names);

    void PopGoods(OutGoodsForm goodsList) throws Exception;
}