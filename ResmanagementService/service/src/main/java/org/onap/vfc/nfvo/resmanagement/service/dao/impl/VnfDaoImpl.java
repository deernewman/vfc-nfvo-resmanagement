/*
 * Copyright 2016 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onap.vfc.nfvo.resmanagement.service.dao.impl;

import java.util.List;
import java.util.Map;

import org.onap.vfc.nfvo.resmanagement.service.dao.inf.VnfDao;
import org.onap.vfc.nfvo.resmanagement.service.entity.VnfEntity;
import org.onap.vfc.nfvo.resmanagement.service.mapper.VnfMapper;

/**
 * <br>
 * <p>
 * </p>
 * 
 * @author
 * @version VFC 1.0 Oct 28, 2016
 */
public class VnfDaoImpl extends AbstractDao implements VnfDao {

    /**
     * <br>
     * 
     * @param id
     * @return
     * @since VFC 1.0
     */
    @Override
    public VnfEntity getVnf(String id) {
        return getMapperManager(VnfMapper.class).selectByPrimaryKey(id);
    }

    /**
     * <br>
     * 
     * @param condition
     * @return
     * @since VFC 1.0
     */
    @Override
    public List<VnfEntity> getVnfs(Map<String, Object> condition) {
        return getMapperManager(VnfMapper.class).getVnfs(condition);
    }

    /**
     * <br>
     * 
     * @param vnfEntity
     * @return
     * @since VFC 1.0
     */
    @Override
    public int addVnf(VnfEntity vnfEntity) {
        return getMapperManager(VnfMapper.class).insert(vnfEntity);
    }

    /**
     * <br>
     * 
     * @param id
     * @return
     * @since VFC 1.0
     */
    @Override
    public int deleteVnfById(String id) {
        return getMapperManager(VnfMapper.class).deleteByPrimaryKey(id);
    }

}
