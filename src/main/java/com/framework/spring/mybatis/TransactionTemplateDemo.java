package com.framework.spring.mybatis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSON;
import com.framework.spring.SpringUtil;

public class TransactionTemplateDemo {

	private static JdbcTemplate jdbc = null;

	static {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				SpringUtil.SPRING_BASE_CLASSPATH + "/mybatis/beans.xml");
		jdbc = context.getBean(JdbcTemplate.class);
	}

	public static void main(String[] args) {
		List<Menu> ls = new ArrayList<Menu>();
		List<Menu> rts = getRoots();
		for (int i = 0; i < rts.size(); i++) {
			Menu root = rts.get(i);
			List<Menu> chs = getMenuById(root.getId(), root.getId());
			root.setChildren(chs);
			for (int j = 0; j < chs.size(); j++) {
				Menu m = chs.get(j);
				String mid = "";
				if (m.getId() != null) {
					mid = m.getId().split("_")[1];
				}
				List<Menu> funcs = getFuncByMenuId(root.getId() + "_" + mid, mid);
				m.setChildren(funcs);
			}
			ls.add(root);
		}
		System.out.println(JSON.toJSONString(ls));
	}

	@SuppressWarnings("unchecked")
	public static List<Menu> getRoots() {
		String sql = "select id,menu_name from en_menu m where m.super_id is null";
		MyRowMapper map = new TransactionTemplateDemo().new MyRowMapper(null);
		return jdbc.query(sql, map);
	}

	@SuppressWarnings("unchecked")
	public static List<Menu> getMenuById(String prefixId, String id) {
		String sql = "select id,menu_name,super_id from en_menu m where m.super_id = ?";
		MyRowMapper map = new TransactionTemplateDemo().new MyRowMapper(prefixId);
		return jdbc.query(sql, new String[] { id }, map);
	}

	@SuppressWarnings("unchecked")
	public static List<Menu> getFuncByMenuId(String prefixId, String menuId) {
		String sql = "select id,func_desc from en_func f where f.menu_id = ?;";
		MyRowMapper map = new TransactionTemplateDemo().new MyRowMapper(prefixId);
		return jdbc.query(sql, new String[] { menuId }, map);
	}

	class MyRowMapper implements RowMapper {
		String prefix;

		public MyRowMapper(String prefix) {
			this.prefix = prefix;
		}

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Menu menu = new Menu();
			if (prefix != null) {
				menu.setId(prefix + "_" + rs.getString(1));
			} else {
				menu.setId(rs.getString(1));
			}
			menu.setName(rs.getString(2));
			return menu;
		}

	}
}
