package com.gupb.base;

import com.gupb.page.WrapMapperResult;
import com.gupb.page.WrapMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = Exception.class)
	public WrapMapperResult<Object> handleException(Exception e) {
		e.printStackTrace();
		logger.info("BaseController Exception: " + e.getMessage(), e);
		return WrapMapperUtil.failSys(e.getMessage());
	}
}
  