package cn.e3mall.controller;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.service.ItemCatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemCatController {

  @Autowired
  private ItemCatService itemCatService;

  @ResponseBody
  @RequestMapping("/item/cat/list")
  public List<EasyUITreeNode> getCatList(@RequestParam(value = "id",
                                                       defaultValue = "0") Long parentId) {
    return itemCatService.getCatList(parentId);
  }
}
