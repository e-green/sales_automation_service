package io.egreen.erp.grn.data.dao.impl;/*
 * Copyright (c) E-Green. (http://www.egreen.io) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * Created by dewmal on 8/24/16.
 */

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.grn.data.dao.GRNDAOController;
import io.egreen.erp.grn.data.entity.GrnModel;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.Date;

public class GrnDAOControllerImpl extends AbstractDAOController<GrnModel> implements GRNDAOController {

    public GrnDAOControllerImpl() {
        super(GrnModel.class);
    }

    @Override
    public boolean finish(String code) {
        Query<GrnModel> filterQuery = getDatastore().find(entityClass, "code", code);
        UpdateOperations<GrnModel> updateOperations = getDatastore().createUpdateOperations(entityClass);
        updateOperations.set("finished", true);
        updateOperations.set("finishedTime", new Date());
        UpdateResults update = getDatastore().update(filterQuery, updateOperations);
        return true;
    }
}
