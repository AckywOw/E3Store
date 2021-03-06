package cn.e3mall.controller;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
  @Autowired
  private ItemService itemService;

  @RequestMapping("/item/{itemId}")
  @ResponseBody
  private TbItem getItemById(@PathVariable Long itemId) {
    final TbItem item = itemService.getItemById(itemId);
    return item;
  }

  @RequestMapping("/item/list")
  @ResponseBody
  private EasyUIDataGridResult getItemList(Integer page, Integer rows) {
    EasyUIDataGridResult result = itemService.getItemList(page, rows);
    return result;
  }
}
