package com.hong.qrcode.controller;

import com.hong.qrcode.form.GoodsForm;
import com.hong.qrcode.form.OutGoodsForm;
import com.hong.qrcode.service.GoodsService;
import com.hong.qrcode.utils.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/list/page")
    public ResultVO GetGoodsList(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        return ResultVO.success(goodsService.GetGoodsListByPage(request));
    }

    @GetMapping("/list")
    public ResultVO GetGoodsList() {
        return ResultVO.success(goodsService.GetGoodsList());
    }


    @PostMapping("/add")
    public ResultVO AddGoodsToStock(@RequestBody List<GoodsForm> goodsList) {
        goodsService.AddGoodsToStock(goodsList);
        return ResultVO.success();
    }

    @PostMapping("/delete")
    public ResultVO DeleteStockById(@RequestBody String name) {
        goodsService.DeleteByName(name);
        return ResultVO.success();
    }

    @PostMapping("/update")
    public ResultVO GoodsOutOfStocks(@RequestBody OutGoodsForm goods) {
        try {
            goodsService.PopGoods(goods);
            return ResultVO.success();
        } catch (Exception e) {
            return ResultVO.error(1, e.getMessage());
        }
    }

    @PostMapping("/delete/list")
    public ResultVO DeleteByIdList(@RequestBody List<String> nameList) {
        goodsService.DeleteByNameList(nameList);
        return ResultVO.success();
    }

}
