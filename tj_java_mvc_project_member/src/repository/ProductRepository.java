package repository;

import vo.ProductVO;

public class ProductRepository extends AbstractRepository<ProductVO>  {
	public ProductRepository() {
		super(ProductVO.class);	
	}
}
