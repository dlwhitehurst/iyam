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

package com.dlw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlw.dao.InventoryDao;
import com.dlw.dao.UserDao;
import com.dlw.model.work.InventoryItem;
import com.dlw.service.InventoryItemExistsException;
import com.dlw.service.InventoryManager;

/**
 * @author <a href="mailto:dlwhitehurst@me.com">David L. Whitehurst</a>
 *
 */
public class InventoryManagerImpl extends GenericManagerImpl<InventoryItem, Long>implements InventoryManager {

    private InventoryDao inventoryDao;

    @Override
    @Autowired
    public void setInventoryDao(final InventoryDao inventoryDao) {
        this.dao = inventoryDao;
        this.inventoryDao = inventoryDao;
    }
    
	/* (non-Javadoc)
	 * @see com.dlw.service.InventoryManager#getInventoryItem(java.lang.String)
	 */
	@Override
	public InventoryItem getInventoryItem(String inventoryItemId) {
        return inventoryDao.get(new Long(inventoryItemId));
	}

	/* (non-Javadoc)
	 * @see com.dlw.service.InventoryManager#getInventory()
	 */
	@Override
	public List<InventoryItem> getInventory() {
		return inventoryDao.getAllDistinct();
	}

	/* (non-Javadoc)
	 * @see com.dlw.service.InventoryManager#saveInventoryItem(com.dlw.model.InventoryItem)
	 */
	@Override
	public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
		return inventoryDao.saveInventoryItem(inventoryItem);	
	}

	/* (non-Javadoc)
	 * @see com.dlw.service.InventoryManager#removeInventoryItem(java.lang.String)
	 */
	@Override
	public void removeInventoryItem(String inventoryItemId) {
        log.debug("removing inventory item: " + inventoryItemId);
        inventoryDao.remove(new Long(inventoryItemId));
	}

}
