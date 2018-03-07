package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.service.ItemCatService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCatServiceImpl implements ItemCatService {

  @Autowired
  private TbItemCatMapper itemCatMapper;

  @Override
  public List<EasyUITreeNode> getCatList(long parentId) {
    // 1、根据parentId查询节点列表
    TbItemCatExample example = new TbItemCatExample();
    //设置查询条件
    final TbItemCatExample.Criteria criteria = example.createCriteria();
    criteria.andParentIdEqualTo(parentId);
    // 2、转换成EasyUITreeNode列表。
    final List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);

    final List<EasyUITreeNode> nodes = new ArrayList<>();
    for(TbItemCat itemCat : tbItemCats){
      EasyUITreeNode node = new EasyUITreeNode();
      node.setId(itemCat.getId());
      node.setText(itemCat.getName());
      node.setState(itemCat.getIsParent()?"closed":"open");
      nodes.add(node);
    }
    return nodes;
  }
}
