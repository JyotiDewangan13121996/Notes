package beans;

import java.util.List;

import dao.BookDaoImpl;

public class BookBean {
	//properties
	private BookDaoImpl dao;
	public BookBean() throws Exception{
		System.out.println("in bk bean ctor");
		//dao inst
		dao=new BookDaoImpl();
	}
	//B.L method for getting category list
	public List<String> listCategories() throws Exception
	{
		System.out.println("in jb : list");
		return dao.getAllCategories();
	}
	

}
