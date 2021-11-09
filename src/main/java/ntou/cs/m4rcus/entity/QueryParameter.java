package ntou.cs.m4rcus.entity;

public class QueryParameter {
	private String orderedBy;
	private String keyword;
	private String sortRule;
	
	public QueryParameter(String orderedBy, String keyword,String sortrule)
	{
		this.orderedBy = orderedBy;
		this.keyword = keyword;
		this.sortRule = sortrule;
	}
	public void setOrderedBy(String orderedBy)
	{
		this.orderedBy = orderedBy;
	}
	public String getOrderedBy()
	{
		return this.orderedBy;
	}
	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}
	public String getKeyword()
	{
		return this.keyword;
	}
	public void setSortrule(String sortrule)
	{
		this.sortRule = sortrule;
	}
	public String getSortrule()
	{
		return this.sortRule;
	}
}
