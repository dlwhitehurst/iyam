/**
 * Copyright 2014 David L. Whitehurst
 * 
 * Licensed under the Apache License, Version 2.0 
 * (the "License"); You may not use this file except 
 * in compliance with the License. You may obtain a 
 * copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific 
 * language governing permissions and limitations under the 
 * License.
 * 
 */

package com.dlw.webapp.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.Context;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.slf4j.Logger;

import com.dlw.Constants;
import com.dlw.model.Upload;
import com.dlw.model.User;
import com.dlw.service.UserManager;
import com.dlw.webapp.services.SecurityContext;

/**
 * @author <a href="mailto:dlwhitehurst@me.com">David L. Whitehurst</a>
 *
 */
public class UploadList {

	@Inject
    private Logger logger;

    @Inject
    private Messages messages;

    @Inject
    private UserManager userManager;

    @Inject
    private BeanModelSource beanModelSource;

    @Inject
    private JavaScriptSupport jsSupport;

    @Inject
    private HttpServletRequest request;

    @Inject
    private AlertManager alertManager;

    @Inject
    private Context context;

    @Inject
    private SecurityContext securityContext;
    
    private String infoMessage;

    @Property
    private String errorMessage;

    @Property
    private List<String> uploads;
    
    @Property
    private String _upload;    
    
    @Log
    void onActivate() {
    	
    	uploads = new ArrayList<String>();
    	
    	// the directory to upload to
        String uploadDir = request.getServletContext().getRealPath("/resources");

        // The following seems to happen when running jetty:run
        if (uploadDir == null) {
            uploadDir = new File("src/main/webapp/resources").getAbsolutePath();
        }
        
        uploadDir += Constants.FILE_SEP + securityContext.getUsername() + Constants.FILE_SEP;

    	File root = new File( uploadDir);
        File[] list = root.listFiles();
        for ( File f : list ) {
            if ( !f.isDirectory() ) {
                logger.info( "File:" + f.getAbsolutePath() );
                uploads.add("/resources/" + securityContext.getUsername() + Constants.FILE_SEP + f.getName());
            }
        }
        
    }
}
