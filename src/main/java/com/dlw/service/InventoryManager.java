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

package com.dlw.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.dlw.dao.InventoryDao;
import com.dlw.model.InventoryItem;

/**
 * @author <a href="mailto:dlwhitehurst@me.com">David L. Whitehurst</a>
 *
 */
public interface InventoryManager {

    void setInventoryDao(InventoryDao inventoryDao);
	
    InventoryItem getInventoryItem(String inventoryItemId);

    List<InventoryItem> getInventory();

    InventoryItem saveInventoryItem(InventoryItem inventoryItem) throws InventoryItemExistsException;

    void removeInventoryItem(String inventoryItemId);
	
}
