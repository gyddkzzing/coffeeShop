package kr.ac.yja.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.yja.cse.model.Product;

/*주석 처리 부분 jdbc framework 템플릿 */ //-> hibernate 진행
@Repository
@Transactional //AOP으로 ...
public class ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Product getProductById(String product_id) {

		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, product_id);
		// sessionFactory는 하이버네이트의 고유한 class이다. ->객체로 변환되어서 넘어온다.
		return product;
	}
	/*
	 * // dao에서는 jdbc 템플릿을 사용하므로 datasource를 사용하는데-> hibernate로 해주겠다. private
	 * JdbcTemplate jdbcTemplate;
	 * 
	 * @Autowired // datasource주입 받는 것 dao-context.xml에 datasource있음. 이걸로 템플릿 사용가능
	 * public void setDataSource(DataSource dataSource) { jdbcTemplate = new
	 * JdbcTemplate(dataSource); }
	 */

	public List<Product> getProducts() { // 이걸 이용함으로써 DB조회 가능

		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product";//session사용 불가능해서 그냥 쿼리 만들어서 조회함.

		Query<Product> query = session.createQuery(hql, Product.class);
		List<Product> productList = query.getResultList();

		return productList;
		/*
		 * String sqlStatement = "select * from product"; return
		 * jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {
		 * 
		 * @Override public Product mapRow(ResultSet rs, int rowNum) throws SQLException
		 * {//로우수 만큼 불림
		 * 
		 * Product product = new Product();
		 * 
		 * product.setProduct_id(rs.getString("product_id"));
		 * product.setProduct_name(rs.getString("product_name"));
		 * product.setProduct_category(rs.getString("product_category"));
		 * product.setProduct_price(rs.getInt("product_price"));
		 * product.setProduct_info(rs.getString("product_info"));
		 * 
		 * return product;
		 * 
		 * }
		 * 
		 * });
		 */
	}

	public void addProduct(Product product) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush(); //꼭 안해줘도 된다. commit할 때 자동으로 flush이뤄짐.

		/*
		 * String product_id= product.getProduct_id(); String product_name=
		 * product.getProduct_name(); String product_category=
		 * product.getProduct_category(); int product_price= product.getProduct_price();
		 * String product_info= product.getProduct_info();
		 * 
		 * String sqlStatement =
		 * "insert into product (product_id, product_name, product_category, product_price, product_info)"
		 * + "values (?,?,?,?,?)";
		 * 
		 * return (jdbcTemplate.update(sqlStatement, new Object[] { product_id,
		 * product_name, product_category, product_price, product_info }) == 1);
		 */
	}

	public void deleteProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		session.flush();

		/*
		 * String sqlStatement ="delete from product where product_id=?";
		 * 
		 * return(jdbcTemplate.update(sqlStatement, new Object[] { product_id }) == 1);
		 * }
		 */
	}

	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();

	}
}
