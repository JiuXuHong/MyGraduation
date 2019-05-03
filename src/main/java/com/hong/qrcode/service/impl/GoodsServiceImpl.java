package com.hong.qrcode.service.impl;

import com.hong.qrcode.domain.Goods;
import com.hong.qrcode.domain.Record;
import com.hong.qrcode.form.GoodsForm;
import com.hong.qrcode.form.OutGoodsForm;
import com.hong.qrcode.repository.GoodsRepository;
import com.hong.qrcode.repository.RecordRepository;
import com.hong.qrcode.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final RecordRepository recordRepository;

    @Autowired
    public GoodsServiceImpl(
            GoodsRepository goodsRepository,
            RecordRepository recordRepository) {
        this.goodsRepository = goodsRepository;
        this.recordRepository = recordRepository;
    }

    @Override
    public Page<Goods> GetGoodsList(Pageable pageable) {
        return goodsRepository.getAllBy(pageable);
    }

    @Override
    public void AddGoodsToStock(List<GoodsForm> goodsList) {
        List<Goods> gls = goodsList.stream().map(
                g -> {
                    Goods goods = goodsRepository.findByName(g.getName());
                    if (goods != null) {
                        goods.setNums(goods.getNums() + g.getNums());
                        goods.setPrice(g.getPrice());
                        goods.setUpdateTime(new Date());
                    } else {
                        goods = new Goods(
                                null,
                                g.getName(),
                                g.getNums(),
                                new Date(),
                                g.getPrice(),
                                g.getDescription());
                    }
                    return goods;
                }
        ).collect(Collectors.toList());
        goodsRepository.saveAll(gls);
    }

    @Override
    public void PopGoods(OutGoodsForm goods) throws Exception {
        Goods g = goodsRepository.findByName(goods.getName());
        if (g == null) {
            throw new Exception("this goods: " + goods.getName() + "is not existed");
        }

        g.setNums(g.getNums() - goods.getNums());
        goodsRepository.save(g);
        recordRepository.save(new Record(null, g.getName(), goods.getNums(), new Date(), goods.getNums() * g.getPrice()));
    }

    @Override
    public void DeleteByName(String name) {
        goodsRepository.deleteByName(name);
    }

    @Override
    public void DeleteByNameList(List<String> names) {
        names.forEach(
                goodsRepository::deleteByName
        );
    }

}
