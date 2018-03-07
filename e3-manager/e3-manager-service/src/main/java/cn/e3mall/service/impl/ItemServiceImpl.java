package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private TbItemMapper itemMapper;

  @Override
  public TbItem getItemById(long itemId) {
    final TbItem item = itemMapper.selectByPrimaryKey(itemId);
    return item;
  }

  @Override
  public EasyUIDataGridResult getItemList(int page, int rows) {
    //设置分页信息
    PageHelper.startPage(page, rows);
    //执行查询
    TbItemExample example = new TbItemExample();
    List<TbItem> list = itemMapper.selectByExample(example);
    //取分页信息
    PageInfo<TbItem> pageInfo = new PageInfo<>(list);

    //创建返回结果对象
    EasyUIDataGridResult result = new EasyUIDataGridResult();
    result.setTotal(pageInfo.getTotal());
    result.setRows(list);

    return result;

  }
}
