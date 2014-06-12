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

package com.dlw.webapp.pages.work;

import java.util.List;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.slf4j.Logger;

import com.dlw.dao.SearchException;
import com.dlw.model.InventoryItem;
import com.dlw.model.User;
import com.dlw.service.InventoryManager;
import com.dlw.service.UserManager;
import com.dlw.webapp.pages.Home;

/**
 * @author <a href="mailto:dlwhitehurst@me.com">David L. Whitehurst</a>
 *
 */
public class Inventory {

    @Inject
    private Logger logger;

    @Inject
    private Messages messages;

    @Inject
    private InventoryManager inventoryManager;

    @Inject
    private BeanModelSource beanModelSource;

    @Inject
    private JavaScriptSupport jsSupport;
	
    @Property
    private InventoryItem currentItem;
    
    private String infoMessage;

    @Property
    private String errorMessage;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String q;

    @Property
    private List<InventoryItem> inventory;
    
    public BeanModel<InventoryItem> getModel() {
        final BeanModel<InventoryItem> model = beanModelSource.createDisplayModel(InventoryItem.class, messages);

        model.include("name", "size", "notes");
        // Set labels
        model.get("name").label(messages.get("inventory.item.name"));
        model.get("size").label(messages.get("inventory.item.size"));
        model.get("notes").label(messages.get("inventory.item.notes"));
 
        return model;
    }

    void setupRender() {
        //try {
          //  inventory = inventoryManager.search(q);
        //} catch (SearchException se) {
          //  errorMessage = se.getMessage();
            inventory = inventoryManager.getInventory();
        //}
    }
    
    Object onDone() {
        return Home.class;
    }
}
