package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

public class EasyUIDataGridResult implements Serializable {

  private static final long serialVersionUID = -4893151564258271574L;
  private Long total;

  private List<?> rows;

  public EasyUIDataGridResult() {

  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public List<?> getRows() {
    return rows;
  }

  public void setRows(List<?> rows) {
    this.rows = rows;
  }

  public EasyUIDataGridResult(Long total, List<?> rows) {

    this.total = total;
    this.rows = rows;
  }
}
