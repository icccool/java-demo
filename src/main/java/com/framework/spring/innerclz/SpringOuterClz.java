package com.framework.spring.innerclz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringOuterClz {

	@Autowired
	BeanClz beanClz;

	int headNum;

	public SpringOuterClz() {

	}

	public class InnerClz {

		public int getHeadNum() {
			//内部类可以掉用外部类属性 
			return SpringOuterClz.this.headNum;
		}
		
		public int beanClzUpdate() {
			return SpringOuterClz.this.beanClz.UpdateOp();
		}
		
		public SpringOuterClz getOuterClz() {
			return SpringOuterClz.this;
		}

	}

}
