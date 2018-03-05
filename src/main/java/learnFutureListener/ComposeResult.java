/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureListener;

/**
 * @author LouHF
 *
 */
public class ComposeResult{
  
  private String name;
  private Integer result;
  /**
   * @param name
   * @param result
   */
  public ComposeResult(String name, Integer result) {
    super();
    this.name = name;
    this.result = result;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getResult() {
    return result;
  }
  public void setResult(Integer result) {
    this.result = result;
  }
  
  
  
}