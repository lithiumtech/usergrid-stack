/*******************************************************************************
 * Copyright 2012 Apigee Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.usergrid.persistence.query;


import org.junit.Test;
import org.usergrid.cassandra.Concurrent;
import org.usergrid.persistence.Query;
import org.usergrid.persistence.Results;


/**
 * @author tnine
 */
@Concurrent()
public class AllInConnectionNoTypeIT extends AbstractIteratingQueryIT
{
    @Test
    public void allInConnectionNoType() throws Exception {
        allIn(new ConnectionNoTypeHelper("allInConnectionNoType"));
    }

  class ConnectionNoTypeHelper extends ConnectionHelper {

    ConnectionNoTypeHelper(String name) {
      super(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.usergrid.persistence.query.SingleOrderByMaxLimitCollection.ConnectionHelper#getResults
     * (org.usergrid.persistence.Query)
     */
    @Override
    public Results getResults(Query query) throws Exception {
      query.setConnectionType(CONNECTION);
      // don't set it on purpose
      query.setEntityType(null);
      return em.searchConnectedEntities(rootEntity, query);

    }

  }

}