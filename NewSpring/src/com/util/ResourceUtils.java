/*
 * $Id: ResourceUtils.java,v 1.1 2016/06/06 09:04:16 wangjin Exp $
 *
 * Copyright 2011 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.util;

import java.io.InputStream;

import org.springframework.core.io.Resource;

/**
 * @author william.xu
 * @version $Id: ResourceUtils.java,v 1.1 2016/06/06 09:04:16 wangjin Exp $
 * Created on Mar 13, 2011 10:56:34 PM
 */
public class ResourceUtils extends org.springframework.util.ResourceUtils {
	
	public static String getStringFromResource(Resource resource) throws Exception{
		if (resource != null && resource.exists()){
			InputStream is = resource.getInputStream();
			byte[] fileData = new byte[(int) is.available()];
		    is.read(fileData);
		    return new String(fileData, "UTF-8");
		}else{
			return null;
		}
	}

	

}
