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

package com.dlw.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dlw.dao.InventoryDao;
import com.dlw.model.InventoryItem;

/**
 * @author <a href="mailto:dlwhitehurst@me.com">David L. Whitehurst</a>
 *
 */
@Repository("inventoryDao")
public class InventoryDaoHibernate extends GenericDaoHibernate<InventoryItem, Long> implements InventoryDao {
	// dlw
    public InventoryDaoHibernate() {
        super(InventoryItem.class);
    }

	/* (non-Javadoc)
	 * @see com.dlw.dao.InventoryDao#getInventory()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<InventoryItem> getInventory() {
        Query qry = getSession().createQuery("from inventory_item ii order by upper(ii.name)");
        return qry.list();
	}

	/* (non-Javadoc)
	 * @see com.dlw.dao.InventoryDao#saveInventoryItem(com.dlw.model.InventoryItem)
	 */
	@Override
	public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
        if (log.isDebugEnabled()) {
            log.debug("inventory item's id: " + inventoryItem.getId());
        }
        getSession().saveOrUpdate(inventoryItem);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return inventoryItem;
	}

}
