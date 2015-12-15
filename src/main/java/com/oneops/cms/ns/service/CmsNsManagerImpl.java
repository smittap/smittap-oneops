/*******************************************************************************
 *  
 *   Copyright 2015 Walmart, Inc.
 *  
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *  
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  
 *******************************************************************************/
package com.oneops.cms.ns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oneops.cms.ns.dal.NSMapper;
import com.oneops.cms.ns.domain.CmsNamespace;

/**
 * The Class CmsNsManagerImpl.
 */
public class CmsNsManagerImpl implements CmsNsManager {

	private NSMapper nsMapper;
	
	/**
	 * Sets the ns mapper.
	 *
	 * @param nsMapper the new ns mapper
	 */
	@Autowired
	public void setNsMapper(NSMapper nsMapper) {
		this.nsMapper = nsMapper;
	}

	/**
	 * Creates the ns.
	 *
	 * @param ns the ns
	 * @return the cms namespace
	 */
	@Override
	public CmsNamespace createNs(CmsNamespace ns) {
		nsMapper.createNamespace(ns);
		return nsMapper.getNamespace(ns.getNsPath());
	}

	/**
	 * Gets the ns.
	 *
	 * @param nsPath the ns path
	 * @return the ns
	 */
	@Override
	public CmsNamespace getNs(String nsPath) {
		return nsMapper.getNamespace(nsPath);
	}

	/**
	 * Delete ns.
	 *
	 * @param nsPath the ns path
	 */
	@Override
	public void deleteNs(String nsPath) {
		nsMapper.deleteNamespace(nsPath);
	}

	/**
	 * Gets the ns by id.
	 *
	 * @param nsId the ns id
	 * @return the ns by id
	 */
	@Override
	public CmsNamespace getNsById(long nsId) {
		return nsMapper.getNamespaceById(nsId);
	}

	/**
	 * Delete ns by id.
	 *
	 * @param nsId the ns id
	 */
	@Override
	public void deleteNsById(long nsId) {
		CmsNamespace ns = nsMapper.getNamespaceById(nsId);
		nsMapper.deleteNamespace(ns.getNsPath());
	}

	/**
	 * Gets the ns like.
	 *
	 * @param nsPath the ns path
	 * @return the ns like
	 */
	@Override
	public List<CmsNamespace> getNsLike(String nsPath) {
		return nsMapper.getNamespaceLike(nsPath);
	}

	/**
	 * Lock ns.
	 *
	 * @param nsPath the ns path
	 */
	@Override
	public void lockNs(String nsPath) {
		nsMapper.lockNamespace(nsPath);
		
	}

}
