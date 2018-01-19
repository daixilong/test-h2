package com.xdl.test_h2;

import java.util.List;
import java.util.Random;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.IDAutoGen;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.H2Style;
import org.beetl.sql.core.db.SQLiteStyle;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.ext.DebugInterceptor;
import com.xdl.test_h2.model.TbUser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	ConnectionSource source=ConnectionSourceHelper.getSimple("org.sqlite.JDBC", "jdbc:sqlite:D:\\Program Files\\Sqlite\\", "sa", "sa");
     //	ConnectionSource source=ConnectionSourceHelper.getSimple("org.h2.Driver", "jdbc:h2:tcp://localhost/D:\\Program Files\\H2Test\\db", "sa", "");//h2的相关测试连接
      UnderlinedNameConversion nc = new  UnderlinedNameConversion();
     // DefaultNameConversion  nc=new DefaultNameConversion();
      SQLLoader loader=new ClasspathLoader("/sql");
     // DBStyle sbStyle=new H2Style();
      DBStyle sbStyle=new SQLiteStyle();
      SQLManager sqlManager=new SQLManager(sbStyle, loader,source,nc,new Interceptor[]{new DebugInterceptor()});
      //sqlManager.genPojoCode("TB_USER", "com.xdl.test_h2.model");//设置pojo文件生成的位置
     // sqlManager.genSQLFile("TB_USER","tbuser");//设置sql文件生成
			//sqlManager.genPojoCodeToConsole("TB_USER");//控制台自动生成代码
			//sqlManager.genSQLTemplateToConsole("TB_USER");//控制台自动生成sql文件
      sqlManager.genPojoCodeToConsole("TB_USER");
      /*
       * 执行了添加的方法
       * TbUser tbUser=new TbUser();
      tbUser.setName("小呆");
      sqlManager.insert(tbUser);*/
      
      /*
       * 执行了更新的方法
       * TbUser tbUser=new TbUser();
      tbUser.setId(1);
      tbUser.setName("张三");
      sqlManager.updateById(tbUser);*/
      
     /* 
      * 根据id查询单条数据
      * TbUser tbUser= sqlManager.unique(TbUser.class, 1);
      System.out.println(tbUser.getName());*/
      
  
     /*  
      * 查询所有的相关记录
      * List<TbUser> tbUsers=sqlManager.select("tbUser.sample", TbUser.class);
      for (TbUser tbUser : tbUsers) {
				  System.out.println(tbUser.getName());
			}*/
      
    /*  
     * 分页的相关查询
     * PageQuery<TbUser> query=new PageQuery<TbUser>(0, 1);
      PageQuery<TbUser> s = sqlManager.pageQuery("tbUser.sample", TbUser.class, query);
      List<TbUser> tbUsers= s.getList();
      for (TbUser tbUser : tbUsers) {
				System.out.println(tbUser.getName());
			}*/
    }
}
